package pl.jakub.musiclibrary.track;

import java.util.List;

public interface TrackService {

    List<Track> findAll();

    List<Track> findPage(Integer pageNumber, Integer pageSize);

    Track findById(Long id);

    Track save(Track tracks);

    Track update(Long id, Track updatedTrack);

    void delete(Long id);

    List<Track> findByName(String name);
}
