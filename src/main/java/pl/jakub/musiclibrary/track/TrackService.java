package pl.jakub.musiclibrary.track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    List<Track> findAll();

    List<Track> findSortedPage(Integer pageNumber, Integer pageSize, String sort, Boolean descending);

    Optional<Track> findById(Long id);

    Track save(Track tracks);

    Track update(Long id, Track updatedTrack);

    void delete(Long id);

    List<Track> findByName(String name);
}
