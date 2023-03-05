package pl.jakub.musiclibrary.album;

import org.springframework.stereotype.Service;
import pl.jakub.musiclibrary.artist.Artist;

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
    public Album findById(Long id) {
        return albumRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Album> save(List<Album> albums) {
        return albumRepository.saveAll(albums);
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
}
