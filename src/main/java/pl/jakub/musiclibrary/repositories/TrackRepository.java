package pl.jakub.musiclibrary.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.jakub.musiclibrary.models.Track;

import java.util.List;

@Repository
public class TrackRepository {

    final JdbcTemplate jdbcTemplate;

    public TrackRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Track> getAll() {
        return jdbcTemplate.query("SELECT id, artist_id, album_id, length FROM track",
                BeanPropertyRowMapper.newInstance(Track.class));
    }

    public Track getById(long id) {
        return jdbcTemplate.queryForObject("SELECT id, artist_id, album_id, length FROM track WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Track.class), id);
    }

    public int add(List<Track> tracks) {
        tracks.forEach(track -> jdbcTemplate.update("INSERT INTO track(artist_id, album_id, length) VALUES(?, ?, ?, ?);",
                track.getArtist().getId(), track.getAlbum().getId(), track.getLength()));
        return 1;
    }

    public int update(Track track) {
        jdbcTemplate.update("UPDATE track SET artist_id = ?, album_id = ?, length = ? WHERE id = ?",
                track.getArtist().getId(), track.getAlbum().getId(), track.getLength());
        return 1;
    }

    public int delete(long id) {
        jdbcTemplate.update("DELETE FROM track WHERE id = ?", id);
        return 1;
    }
}
