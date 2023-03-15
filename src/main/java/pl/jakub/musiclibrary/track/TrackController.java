package pl.jakub.musiclibrary.track;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    final TrackServiceImpl trackService;

    public TrackController(TrackServiceImpl trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<List<Track>> getAll() {
        List<Track> tracks = trackService.findAll();
        if (tracks == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (tracks.isEmpty())
            return new ResponseEntity<>(tracks, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<Track>> getSortedPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam String sort, @RequestParam(defaultValue = "false") Boolean descending) {
        List<Track> page = trackService.findSortedPage(pageNumber, pageSize, sort, descending);
        if (page == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (page.isEmpty())
            return new ResponseEntity<>(page, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Track> getById(@PathVariable Long id) {
        return trackService.findById(id)
                .map(track -> new ResponseEntity(track, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<Track>> getByName(@RequestParam String name) {
        List<Track> tracks = trackService.findByName(name);
        if (tracks == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (tracks.isEmpty())
            return new ResponseEntity<>(tracks, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Track> save(@Valid @RequestBody Track track) {
        return new ResponseEntity<>(trackService.save(track), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Track> update(@PathVariable Long id, @Valid @RequestBody Track updatedTrack) {
        Optional<Track> track = trackService.findById(id);
        if (track.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(trackService.update(id, updatedTrack), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        Optional<Track> track = trackService.findById(id);
        if (track.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            trackService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
