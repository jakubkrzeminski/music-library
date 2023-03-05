package pl.jakub.musiclibrary.album;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jakub.musiclibrary.artist.Artist;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    final AlbumServiceImpl albumService;

    public AlbumController(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAll() {
        return new ResponseEntity<>(albumService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable Long id) {
        return new ResponseEntity<>(albumService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> save(@Valid @RequestBody Album album) {
        return new ResponseEntity<>(albumService.save(album), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> update(@PathVariable Long id, @Valid @RequestBody Album updatedAlbum) {
        return new ResponseEntity<>(albumService.update(id, updatedAlbum), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        albumService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<Album>> getByName(@RequestParam String name) {
        return new ResponseEntity<>(albumService.findByName(name), HttpStatus.OK);
    }
}
