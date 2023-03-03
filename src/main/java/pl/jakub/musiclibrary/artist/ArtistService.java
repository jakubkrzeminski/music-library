package pl.jakub.musiclibrary.artist;

import java.util.List;

    public interface ArtistService {

    List<Artist> getAll();

    Artist getById(long id);

    List<Artist> save(List<Artist> artists);

//    int update(long id, Artist updatedArtist);

    void delete(long id);
}
