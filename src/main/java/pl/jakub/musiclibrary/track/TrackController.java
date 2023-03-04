package pl.jakub.musiclibrary.track;

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
        return trackService.getAll();
    }

    @GetMapping("/{id}")
    public Track getById(@PathVariable Long id) {
        return trackService.getById(id);
    }

    @PostMapping
    public List<Track> save(@RequestBody List<Track> tracks) {
        return trackService.save(tracks);
    }

//    @PutMapping("/{id}")
//    public int update(@PathVariable Long id, @RequestBody Track updatedTrack) {
//        return trackService.update(id, updatedTrack);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trackService.delete(id);
    }
}
