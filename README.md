# SpotifyProject


Base de données créée sur apache accessible via le port 3306
La base de données est composée de deux tables : Album et Artiste

le controller Album :

/api/albums/all. Http method: GET.
permet de retourner la liste de tous les albums

/api/albums/byTitreOrArtist Http method: GET.
permet de récuperer la liste des albums par leurs titre ou bien leur artiste