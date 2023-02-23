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

    public int add(List<Track> tracks) {
        return trackRepository.add(tracks);
    }

    public int update(Track track) {
        return trackRepository.update(track);
    }

    public int delete(long id) {
        return trackRepository.delete(id);
    }
}
