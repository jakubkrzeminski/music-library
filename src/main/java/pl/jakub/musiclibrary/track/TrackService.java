package pl.jakub.musiclibrary.track;

import java.util.List;

public interface TrackService {

    List<Track> findAll();

    Track findById(Long id);

    Track save(Track tracks);

    Track update(Long id, Track updatedTrack);

    void delete(Long id);
}
