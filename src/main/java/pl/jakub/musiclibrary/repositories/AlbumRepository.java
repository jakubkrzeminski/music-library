package pl.jakub.musiclibrary.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.jakub.musiclibrary.models.Album;

import java.util.List;

@Repository
public class AlbumRepository {

    final JdbcTemplate jdbcTemplate;

    public AlbumRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Album> getAll() {
        return jdbcTemplate.query("SELECT id, artist_id, name, number_of_songs FROM album",
                BeanPropertyRowMapper.newInstance(Album.class));
    }

    public Album getById(long id) {
        return jdbcTemplate.queryForObject("SELECT id, artist_id, name, number_of_songs FROM album WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Album.class), id);
    }

    public int add(List<Album> Albums) {
        Albums.forEach(Album -> jdbcTemplate.update("INSERT INTO album(artist_id, name, number_of_songs) VALUES(?, ?, ?, ?);",
                Album.getArtist().getId(), Album.getName(), Album.getNumberOfSongs()));
        return 1;
    }

    public int update(Album Album) {
        jdbcTemplate.update("UPDATE album SET artist_id = ?, name = ?, number_of_songs = ? WHERE id = ?",
                Album.getArtist().getId(), Album.getName(), Album.getNumberOfSongs());
        return 1;
    }

    public int delete(long id) {
        jdbcTemplate.update("DELETE FROM album WHERE id = ?", id);
        return 1;
    }
}
