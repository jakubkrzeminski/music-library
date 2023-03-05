package pl.jakub.musiclibrary.artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {

    List<Artist> findAll();

    Artist findById(Long id);

    Artist save(Artist artist);

    Artist update(Long id, Artist updatedArtist);

    void delete(Long id);
}
