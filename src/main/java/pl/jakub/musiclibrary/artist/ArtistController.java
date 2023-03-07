package pl.jakub.musiclibrary.artist;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Artist>> getAll() {
        return new ResponseEntity<>(artistService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<Artist>> getPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return new ResponseEntity<>(artistService.findPage(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getById(@PathVariable Long id) {
        return new ResponseEntity<>(artistService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<Artist>> getByName(@RequestParam String name) {
        return new ResponseEntity<>(artistService.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> save(@Valid @RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.save(artist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> update(@PathVariable Long id, @Valid @RequestBody Artist updatedArtist) {
        return new ResponseEntity<>(artistService.update(id, updatedArtist), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        artistService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
