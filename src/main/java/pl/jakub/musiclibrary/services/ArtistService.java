package pl.jakub.musiclibrary.services;

import org.springframework.stereotype.Service;
import pl.jakub.musiclibrary.models.Artist;
import pl.jakub.musiclibrary.repositories.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {

    final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAll() {
        return artistRepository.getAll();
    }

    public Artist getById(long id) {
        return artistRepository.getById(id);
    }

    public int add(List<Artist> Artists) {
        return artistRepository.add(Artists);
    }

    public int update(Artist Artist) {
        return artistRepository.update(Artist);
    }

    public int delete(long id) {
        return artistRepository.delete(id);
    }
}
