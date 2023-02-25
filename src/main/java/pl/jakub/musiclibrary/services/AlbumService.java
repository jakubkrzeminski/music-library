package pl.jakub.musiclibrary.services;

import org.springframework.stereotype.Service;
import pl.jakub.musiclibrary.models.Album;
import pl.jakub.musiclibrary.repositories.AlbumRepository;

import java.util.List;

@Service
public class AlbumService {

    final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAll() {
        return albumRepository.getAll();
    }

    public Album getById(long id) {
        return albumRepository.getById(id);
    }

    public int save(List<Album> albums) {
        return albumRepository.save(albums);
    }

    public int update(long id, Album updatedArtist) {
        Album album = albumRepository.getById(id);

        if (album != null) {
            album.setArtist(updatedArtist.getArtist());
            album.setName(updatedArtist.getName());
            album.setNumberOfSongs(updatedArtist.getNumberOfSongs());

            albumRepository.update(album);
            return 1;
        } else {
            return -1;
        }
    }

    public int delete(long id) {
        return albumRepository.delete(id);
    }
}
