package pl.jakub.musiclibrary.album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {

    List<Album> findAll();

    List<Album> findSortedPage(Integer pageNumber, Integer pageSize, String sort, Boolean descending);

    Optional<Album> findById(Long id);

    Album save(Album album);

    Album update(Long id, Album updatedArtist);

    void delete(Long id);

    List<Album> findByName(String name);
}
