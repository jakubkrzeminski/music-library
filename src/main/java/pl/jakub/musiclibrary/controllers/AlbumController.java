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
    public int add(List<Album> Albums) {
        return albumService.add(Albums);
    }

    @PutMapping
    public int update(Album Album) {
        return albumService.update(Album);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable long id) {
        return albumService.delete(id);
    }
}
