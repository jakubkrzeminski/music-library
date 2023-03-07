package pl.jakub.musiclibrary.album;

import java.util.List;

public interface AlbumService {

    List<Album> findAll();

    List<Album> findPage(Integer pageNumber, Integer pageSize);

    Album findById(Long id);

    Album save(Album album);

    Album update(Long id, Album updatedArtist);

    void delete(Long id);

    List<Album> findByName(String name);
}
