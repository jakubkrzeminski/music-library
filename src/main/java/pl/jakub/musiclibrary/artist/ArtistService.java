package pl.jakub.musiclibrary.artist;

import org.springframework.stereotype.Service;
import pl.jakub.musiclibrary.artist.Artist;
import pl.jakub.musiclibrary.artist.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {

    final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Artist getById(long id) {
        return artistRepository.getById(id);
    }

    public List<Artist> save(List<Artist> artists) {
        return artistRepository.saveAll(artists);
    }

//    public int update(long id, Artist updatedArtist) {
//        Artist artist = artistRepository.getById(id);
//
//        if (artist != null) {
//            artist.setName(updatedArtist.getName());
//            artist.setPlaceOfBirth(updatedArtist.getPlaceOfBirth());
//            artist.setDateOfBirth(updatedArtist.getDateOfBirth());
//            artist.setDateOfDeath(updatedArtist.getDateOfDeath());
//
//            artistRepository.update(artist);
//            return 1;
//        } else {
//            return -1;
//        }
//    }

    public void delete(long id) {
        artistRepository.deleteById(id);
    }
}
