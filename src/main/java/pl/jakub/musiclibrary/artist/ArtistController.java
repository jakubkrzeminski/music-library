package pl.jakub.musiclibrary.artist;

import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    final ArtistServiceImpl artistService;

    public ArtistController(ArtistServiceImpl artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAll() {
        List<Artist> allArtists = artistService.findAll();
        if (allArtists == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (allArtists.isEmpty())
            return new ResponseEntity<>(allArtists, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(allArtists, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<Artist>> getSortedPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam String sort, @RequestParam(defaultValue = "false") Boolean descending) {
        List<Artist> page = artistService.findSortedPage(pageNumber, pageSize, sort, descending);
        if (page == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (page.isEmpty())
            return new ResponseEntity<>(page, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getById(@PathVariable Long id) {
        return artistService.findById(id)
                .map(artist -> new ResponseEntity<>(artist, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<Artist>> getByName(@RequestParam String name) {
        List<Artist> artists = artistService.findByName(name);
        if (artists == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (artists.isEmpty())
            return new ResponseEntity<>(artists, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> save(@Valid @RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.save(artist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> update(@PathVariable Long id, @Valid @RequestBody Artist updatedArtist) {
        Optional<Artist> artist = artistService.findById(id);
        if (artist.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(artistService.update(id, updatedArtist), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        Optional<Artist> artist = artistService.findById(id);
        if (artist.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            artistService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
