package pl.jakub.musiclibrary.album;

import java.util.List;

public interface AlbumService {

    List<Album> getAll();

    Album getById(Long id);

    List<Album> save(List<Album> albums);

//    int update(Long id, Album updatedArtist);

    void delete(Long id);
}
