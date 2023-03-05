package pl.jakub.musiclibrary.track;

import java.util.List;

public interface TrackService {

    List<Track> findAll();

    Track findById(Long id);

    List<Track> save(List<Track> tracks);

    Track update(Long id, Track updatedTrack);

    void delete(Long id);
}
