package pl.jakub.musiclibrary.track;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    final TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public Track findById(Long id) {
        return trackRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Track save(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public Track update(Long id, Track updatedTrack) {
        Optional<Track> trackOptional = trackRepository.findById(id);

        if (trackOptional.isPresent()) {
            Track track = trackOptional.get();
            track.setArtist(updatedTrack.getArtist());
            track.setAlbum(updatedTrack.getAlbum());
            track.setLength(updatedTrack.getLength());

            trackRepository.save(track);
            return track;
        }
        throw new RuntimeException();
    }

    @Override
    public void delete(Long id) {
        trackRepository.deleteById(id);
    }
}
