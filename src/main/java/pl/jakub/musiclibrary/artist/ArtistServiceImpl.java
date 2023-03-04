package pl.jakub.musiclibrary.artist;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Artist> save(List<Artist> artists) {
        return artistRepository.saveAll(artists);
    }

//    @Override
//    public int update(Long id, Artist updatedArtist) {
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

    @Override
    public void delete(Long id) {
        artistRepository.deleteById(id);
    }
}
