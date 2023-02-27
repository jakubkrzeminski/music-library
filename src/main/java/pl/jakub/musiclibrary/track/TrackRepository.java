package pl.jakub.musiclibrary.track;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jakub.musiclibrary.track.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}
