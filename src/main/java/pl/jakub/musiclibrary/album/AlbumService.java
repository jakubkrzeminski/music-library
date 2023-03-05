package pl.jakub.musiclibrary.album;

import java.util.List;

public interface AlbumService {

    List<Album> findAll();

    Album findById(Long id);

    List<Album> save(List<Album> albums);

    Album update(Long id, Album updatedArtist);

    void delete(Long id);
}
