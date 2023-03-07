package pl.jakub.musiclibrary.artist;

import java.util.List;

public interface ArtistService {

    List<Artist> findAll();

    List<Artist> findSortedPage(Integer pageNumber, Integer pageSize);

    Artist findById(Long id);

    Artist save(Artist artist);

    Artist update(Long id, Artist updatedArtist);

    void delete(Long id);

    List<Artist> findByName(String name);
}
