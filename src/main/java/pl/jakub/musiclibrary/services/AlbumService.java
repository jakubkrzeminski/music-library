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

    public int add(List<Album> Albums) {
        return albumRepository.add(Albums);
    }

    public int update(Album Album) {
        return albumRepository.update(Album);
    }

    public int delete(long id) {
        return albumRepository.delete(id);
    }
}
