package pl.jakub.musiclibrary.artist;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Artist> findSortedPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("name").ascending());
        return artistRepository.findAll(pageable).getContent();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist update(Long id, Artist updatedArtist) {
        Optional<Artist> artistOptional = artistRepository.findById(id);

        if (artistOptional.isPresent()) {
            Artist artist = artistOptional.get();
            artist.setName(updatedArtist.getName());
            artist.setPlaceOfBirth(updatedArtist.getPlaceOfBirth());
            artist.setDateOfBirth(updatedArtist.getDateOfBirth());
            artist.setDateOfDeath(updatedArtist.getDateOfDeath());

            artistRepository.save(artist);
            return artist;
        }
            throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public List<Artist> findByName(String name) {
        return artistRepository.findByName(name);
    }
}
