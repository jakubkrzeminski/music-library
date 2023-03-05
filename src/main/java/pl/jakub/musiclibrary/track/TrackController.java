package pl.jakub.musiclibrary.track;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    final TrackServiceImpl trackService;

    public TrackController(TrackServiceImpl trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<Track> getAll() {
        return trackService.findAll();
    }

    @GetMapping("/{id}")
    public Track getById(@PathVariable Long id) {
        return trackService.findById(id);
    }

    @PostMapping
    public Track save(@Valid @RequestBody Track track) {
        return trackService.save(track);
    }

    @PutMapping("/{id}")
    public Track update(@PathVariable Long id, @Valid @RequestBody Track updatedTrack) {
        return trackService.update(id, updatedTrack);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trackService.delete(id);
    }
}
