package pl.jakub.musiclibrary.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.jakub.musiclibrary.models.Artist;

import java.util.List;

@Repository
public class ArtistRepository {

    final JdbcTemplate jdbcTemplate;

    public ArtistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Artist> getAll() {
        return jdbcTemplate.query("SELECT id, name, place_of_birth, date_of_birth, date_of_death FROM artist",
                BeanPropertyRowMapper.newInstance(Artist.class));
    }

    public Artist getById(long id) {
        return jdbcTemplate.queryForObject("SELECT id, name, place_of_birth, date_of_birth, date_of_death FROM artist WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Artist.class), id);
    }

    public int save(List<Artist> artists) {
        artists.forEach(artist -> jdbcTemplate.update("INSERT INTO artist(name, place_of_birth, date_of_birth, date_of_death) VALUES(?, ?, ?, ?);",
                artist.getName(), artist.getPlaceOfBirth(), artist.getDateOfBirth(), artist.getDateOfDeath()));
        return 1;
    }

    public int update(Artist artist) {
        return jdbcTemplate.update("UPDATE artist SET name = ?, place_of_birth = ?, date_of_birth = ?, date_of_death = ? WHERE id = ?",
                artist.getName(), artist.getPlaceOfBirth(), artist.getDateOfBirth(), artist.getDateOfDeath(), artist.getId());
    }

    public int delete(long id) {
        jdbcTemplate.update("DELETE FROM artist WHERE id = ?", id);
        return 1;
    }
}
