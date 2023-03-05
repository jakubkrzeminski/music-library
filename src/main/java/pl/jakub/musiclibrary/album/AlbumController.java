package pl.jakub.musiclibrary.album;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    final AlbumServiceImpl albumService;

    public AlbumController(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAll() {
        return albumService.findAll();
    }

    @GetMapping("/{id}")
    public Album getById(@PathVariable Long id) {
        return albumService.findById(id);
    }

    @PostMapping
    public Album save(@Valid @RequestBody Album album) {
        return albumService.save(album);
    }

    @PutMapping("/{id}")
    public Album update(@PathVariable Long id, @Valid @RequestBody Album updatedAlbum) {
        return albumService.update(id, updatedAlbum);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        albumService.delete(id);
    }
}
