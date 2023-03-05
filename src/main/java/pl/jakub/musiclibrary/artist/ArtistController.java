package pl.jakub.musiclibrary.artist;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    final ArtistServiceImpl artistService;

    public ArtistController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getAll() {
        return artistService.findAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable Long id) {
        return artistService.findById(id);
    }

    @PostMapping
    public List<Artist> save(@RequestBody List<Artist> artists) {
        return artistService.save(artists);
    }

    @PutMapping("/{id}")
    public Artist update(@PathVariable Long id, @RequestBody Artist updatedArtist) {
        return artistService.update(id, updatedArtist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        artistService.delete(id);
    }
}
