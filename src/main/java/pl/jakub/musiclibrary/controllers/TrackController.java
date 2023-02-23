package pl.jakub.musiclibrary.controllers;

import org.springframework.web.bind.annotation.*;
import pl.jakub.musiclibrary.models.Track;
import pl.jakub.musiclibrary.services.TrackService;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<Track> getAll() {
        return trackService.getAll();
    }

    @GetMapping("/{id}")
    public Track getById(@PathVariable long id) {
        return trackService.getById(id);
    }

    @PostMapping
    public int add(List<Track> tracks) {
        return trackService.add(tracks);
    }

    @PutMapping
    public int update(Track track) {
        return trackService.update(track);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable long id) {
        return trackService.delete(id);
    }
}
