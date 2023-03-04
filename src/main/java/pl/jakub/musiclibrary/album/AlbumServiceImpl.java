package pl.jakub.musiclibrary.album;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album getById(Long id) {
        return albumRepository.getById(id);
    }

    @Override
    public List<Album> save(List<Album> albums) {
        return albumRepository.saveAll(albums);
    }

//    @Override
//    public int update(Long id, Album updatedArtist) {
//        Album album = albumRepository.getById(id);
//
//        if (album != null) {
//            album.setArtist(updatedArtist.getArtist());
//            album.setName(updatedArtist.getName());
//            album.setNumberOfSongs(updatedArtist.getNumberOfSongs());
//
//            albumRepository.update(album);
//            return 1;
//        } else {
//            return -1;
//        }
//    }

    @Override
    public void delete(Long id) {
        albumRepository.deleteById(id);
    }
}
