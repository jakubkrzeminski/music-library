package pl.jakub.musiclibrary.track;

import org.springframework.stereotype.Service;
import pl.jakub.musiclibrary.track.Track;
import pl.jakub.musiclibrary.track.TrackRepository;

import java.util.List;

@Service
public class TrackService {

    final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAll() {
        return trackRepository.findAll();
    }

    public Track getById(long id) {
        return trackRepository.getById(id);
    }

    public List<Track> save(List<Track> tracks) {
        return trackRepository.saveAll(tracks);
    }

//    public int update(long id, Track updatedTrack) {
//        Track track = trackRepository.getById(id);
//
//        if (track != null) {
//            track.setArtist(updatedTrack.getArtist());
//            track.setAlbum(updatedTrack.getAlbum());
//            track.setLength(updatedTrack.getLength());
//
//            trackRepository.update(track);
//            return 1;
//        } else {
//            return -1;
//        }
//    }

    public void delete(long id) {
        trackRepository.deleteById(id);
    }
}
