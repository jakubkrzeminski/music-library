package pl.jakub.musiclibrary.track;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{

    final TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> getAll() {
        return trackRepository.findAll();
    }

    @Override
    public Track getById(long id) {
        return trackRepository.getById(id);
    }

    @Override
    public List<Track> save(List<Track> tracks) {
        return trackRepository.saveAll(tracks);
    }

//    @Override
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

    @Override
    public void delete(long id) {
        trackRepository.deleteById(id);
    }
}
