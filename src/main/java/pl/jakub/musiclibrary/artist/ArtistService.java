package pl.jakub.musiclibrary.artist;

import java.util.List;

    public interface ArtistService {

    List<Artist> getAll();

    Artist getById(Long id);

    List<Artist> save(List<Artist> artists);

//    int update(Long
//   id, Artist updatedArtist);

    void delete(Long id);
}
