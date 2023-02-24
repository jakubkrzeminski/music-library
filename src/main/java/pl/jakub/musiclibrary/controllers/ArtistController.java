package pl.jakub.musiclibrary.controllers;

import org.springframework.web.bind.annotation.*;
import pl.jakub.musiclibrary.models.Artist;
import pl.jakub.musiclibrary.services.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable long id) {
        return artistService.getById(id);
    }

    @PostMapping
    public int add(List<Artist> Artists) {
        return artistService.add(Artists);
    }

    @PutMapping
    public int update(Artist Artist) {
        return artistService.update(Artist);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable long id) {
        return artistService.delete(id);
    }
}
