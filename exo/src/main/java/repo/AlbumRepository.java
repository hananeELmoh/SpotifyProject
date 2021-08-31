package repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
	
	@Query("select a from Album a where titre = :titre")
	List<Album> getByTitre(@Param("titre") String titre);
	
	@Query("select a from Album a inner join a.artiste ar where ar.nom = :artiste")
	List<Album> getByArtist(@Param("artiste") String artiste);
	
}
