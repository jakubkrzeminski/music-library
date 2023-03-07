package pl.jakub.musiclibrary.album;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public List<Album> findSortedPage(Integer pageNumber, Integer pageSize, String sort, Boolean descending) {
        Sort.Direction direction;
        if (descending) direction = Sort.Direction.DESC;
        else direction = Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, sort));
        return albumRepository.findAll(pageable).getContent();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album update(Long id, Album updatedArtist) {
        Optional<Album> albumOptional = albumRepository.findById(id);

        if (albumOptional.isPresent()) {
            Album album = albumOptional.get();
            album.setArtist(updatedArtist.getArtist());
            album.setName(updatedArtist.getName());
            album.setNumberOfSongs(updatedArtist.getNumberOfSongs());

            albumRepository.save(album);
            return album;
        }
        throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public List<Album> findByName(String name) {
        return albumRepository.findByName(name);
    }
}
