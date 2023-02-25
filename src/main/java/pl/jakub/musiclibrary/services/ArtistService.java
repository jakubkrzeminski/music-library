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

    public int save(List<Artist> artists) {
        return artistRepository.save(artists);
    }

    public int update(long id, Artist updatedArtist) {
        Artist artist = artistRepository.getById(id);

        if (artist != null) {
            artist.setName(updatedArtist.getName());
            artist.setPlaceOfBirth(updatedArtist.getPlaceOfBirth());
            artist.setDateOfBirth(updatedArtist.getDateOfBirth());
            artist.setDateOfDeath(updatedArtist.getDateOfDeath());

            artistRepository.update(artist);
            return 1;
        } else {
            return -1;
        }
    }

    public int delete(long id) {
        return artistRepository.delete(id);
    }
}
