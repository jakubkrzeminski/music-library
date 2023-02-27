package pl.jakub.musiclibrary.album;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAll() {
        return albumRepository.findAll();
    }
    
    public Album getById(long id) {
        return albumRepository.getById(id);
    }

    public List<Album> save(List<Album> albums) {
        return albumRepository.saveAll(albums);
    }

//    public int update(long id, Album updatedArtist) {
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

    public void delete(long id) {
        albumRepository.deleteById(id);
    }
}
