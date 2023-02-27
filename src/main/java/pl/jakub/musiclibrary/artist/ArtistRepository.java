package pl.jakub.musiclibrary.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.musiclibrary.artist.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
