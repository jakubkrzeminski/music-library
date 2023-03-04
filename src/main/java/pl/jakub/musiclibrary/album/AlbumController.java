package pl.jakub.musiclibrary.album;

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
    public List<Album> save(@RequestBody List<Album> albums) {
        return albumService.save(albums);
    }

//    @PutMapping("/{id}")
//    public int update(@PathVariable Long id, @RequestBody Album updatedAlbum) {
//        return albumService.update(id, updatedAlbum);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        albumService.delete(id);
    }
}
