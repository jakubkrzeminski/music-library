package pl.jakub.musiclibrary.track;

import java.util.List;

public interface TrackService {

    List<Track> getAll();

    Track getById(long id);

    List<Track> save(List<Track> tracks);

//    int update(long id, Track updatedTrack);

    void delete(long id);
}
