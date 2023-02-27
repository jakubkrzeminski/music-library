package pl.jakub.musiclibrary.album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.musiclibrary.album.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
