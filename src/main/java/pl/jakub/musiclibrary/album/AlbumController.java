package pl.jakub.musiclibrary.album;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    final AlbumServiceImpl albumService;

    public AlbumController(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<List<Album>> getAll() {
        List<Album> allAlbums = albumService.findAll();
        if (allAlbums == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (allAlbums.isEmpty())
            return new ResponseEntity<>(allAlbums, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(allAlbums, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<Album>> getSortedPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam String sort, @RequestParam(defaultValue = "false") Boolean descending) {
        List<Album> page = albumService.findSortedPage(pageNumber, pageSize, sort, descending);
        if (page == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (page.isEmpty())
            return new ResponseEntity<>(page, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getById(@PathVariable Long id) {
        return albumService.findById(id)
                .map(album -> new ResponseEntity<>(album, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<Album>> getByName(@RequestParam String name) {
        List<Album> albums = albumService.findByName(name);
        if (albums == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (albums.isEmpty())
            return new ResponseEntity<>(albums, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Album> save(@Valid @RequestBody Album album) {
        return new ResponseEntity<>(albumService.save(album), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> update(@PathVariable Long id, @Valid @RequestBody Album updatedAlbum) {
        Optional<Album> album = albumService.findById(id);
        if (album.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(albumService.update(id, updatedAlbum), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        Optional<Album> album = albumService.findById(id);
        if (album.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            albumService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
