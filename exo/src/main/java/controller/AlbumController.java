package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Album;
import repo.AlbumRepository;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
	
	@Autowired
	AlbumRepository albumRepository;
	
	public AlbumController() {}
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(AlbumController.class);
	
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Album>> allAlbums() {
			
	 logger.debug("appel de la méthode permettant de retourner tous les albums.");
	 List <Album> albums = new ArrayList();
	 
	 albumRepository.findAll().forEach(albums::add);
	 
	 if (albums.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(albums, HttpStatus.OK);
	
		
	}
	
	@GetMapping(value="/byTitreOrArtist")
	public ResponseEntity<List<Album>> vingtsPremiersAlbums(@RequestParam(required = false) String titre, @RequestParam(required = false) String nomArtiste){
		 logger.debug("appel de la méthode permettant de retourner les 20 premiers albums par leurs titres ou bien le nom de l'artiste.");
		 List <Album> albums = new ArrayList();
		 if (titre == null && nomArtiste == null) {
			 albumRepository.findAll().forEach(albums::add);
		 }
		 
		 if(titre == null && nomArtiste != null) {
			 albumRepository.getByArtist(nomArtiste).forEach(albums::add);
		 }
		 
		 if(titre != null && nomArtiste == null) {
			 albumRepository.getByTitre(titre).forEach(albums::add);
		 }
		 
		 if (albums.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
 
		return new ResponseEntity<>(albums, HttpStatus.OK);
	}

}
