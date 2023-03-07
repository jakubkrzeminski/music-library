package pl.jakub.musiclibrary.track;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Track>> getAll() {
        return new ResponseEntity<>(trackService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<Track>> getSortedPage(@RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam String sort, @RequestParam(defaultValue = "false") Boolean descending) {
        return new ResponseEntity<>(trackService.findSortedPage(pageNumber, pageSize, sort, descending), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Track> getById(@PathVariable Long id) {
        return new ResponseEntity<>(trackService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<Track>> getByName(@RequestParam String name) {
        return new ResponseEntity<>(trackService.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Track> save(@Valid @RequestBody Track track) {
        return new ResponseEntity<>(trackService.save(track), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Track> update(@PathVariable Long id, @Valid @RequestBody Track updatedTrack) {
        return new ResponseEntity<>(trackService.update(id, updatedTrack), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        trackService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
