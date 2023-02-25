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
    public int save(@RequestBody List<Track> tracks) {
        return trackService.save(tracks);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable long id, @RequestBody Track updatedTrack) {
        return trackService.update(id, updatedTrack);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable long id) {
        return trackService.delete(id);
    }
}
