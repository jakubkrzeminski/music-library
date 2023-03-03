package pl.jakub.musiclibrary.album;

import java.util.List;

public interface AlbumService {

    List<Album> getAll();

    Album getById(long id);

    List<Album> save(List<Album> albums);

//    int update(long id, Album updatedArtist);

    void delete(long id);
}
