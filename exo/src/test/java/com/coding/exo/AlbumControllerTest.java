package com.coding.exo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import model.Album;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AlbumControllerTest {

	 @Autowired
	    private TestRestTemplate restTemplate;
	
	 
	 @Test
	    public void getAll() {
	        ResponseEntity<Album[]> response = restTemplate.getForEntity("/api/albums/all", Album[].class);
	        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	    }

	 @Test
	    public void getAlbumsByTitre() {
	        ResponseEntity<Album[]> response = restTemplate.getForEntity("/api/albums/byTitreOrArtist?titre=album 1",  Album[].class);
	        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	    }
	 
	 @Test
	    public void getAlbumsByArtiste() {
	        ResponseEntity<Album[]> response = restTemplate.getForEntity("/api/albums/byTitreOrArtist?artiste=toto",  Album[].class);
	        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
	    }
}
