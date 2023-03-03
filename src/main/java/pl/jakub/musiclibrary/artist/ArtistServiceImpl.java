package pl.jakub.musiclibrary.artist;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist getById(long id) {
        return artistRepository.getById(id);
    }

    @Override
    public List<Artist> save(List<Artist> artists) {
        return artistRepository.saveAll(artists);
    }

//    @Override
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

    @Override
    public void delete(long id) {
        artistRepository.deleteById(id);
    }
}
