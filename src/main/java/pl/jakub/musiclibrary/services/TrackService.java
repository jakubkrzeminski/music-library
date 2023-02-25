package pl.jakub.musiclibrary.services;

import org.springframework.stereotype.Service;
import pl.jakub.musiclibrary.models.Track;
import pl.jakub.musiclibrary.repositories.TrackRepository;

import java.util.List;

@Service
public class TrackService {

    final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAll() {
        return trackRepository.getAll();
    }

    public Track getById(long id) {
        return trackRepository.getById(id);
    }

    public int save(List<Track> tracks) {
        return trackRepository.save(tracks);
    }

    public int update(long id, Track updatedTrack) {
        Track track = trackRepository.getById(id);

        if (track != null) {
            track.setArtist(updatedTrack.getArtist());
            track.setAlbum(updatedTrack.getAlbum());
            track.setLength(updatedTrack.getLength());

            trackRepository.update(track);
            return 1;
        } else {
            return -1;
        }
    }

    public int delete(long id) {
        return trackRepository.delete(id);
    }
}
