package pl.jakub.musiclibrary.controllers;

import org.springframework.web.bind.annotation.*;
import pl.jakub.musiclibrary.models.Album;
import pl.jakub.musiclibrary.services.AlbumService;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAll() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    public Album getById(@PathVariable long id) {
        return albumService.getById(id);
    }

    @PostMapping
    public int save(@RequestBody List<Album> albums) {
        return albumService.save(albums);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable long id, @RequestBody Album updatedAlbum) {
        return albumService.update(id, updatedAlbum);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable long id) {
        return albumService.delete(id);
    }
}
