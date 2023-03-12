package pl.jakub.musiclibrary.dataLoader;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.jakub.musiclibrary.album.Album;
import pl.jakub.musiclibrary.album.AlbumService;
import pl.jakub.musiclibrary.artist.Artist;
import pl.jakub.musiclibrary.artist.ArtistService;
import pl.jakub.musiclibrary.track.Track;
import pl.jakub.musiclibrary.track.TrackService;

import java.time.LocalDate;

@Component
public class ArtistsAlbumsTracksLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ArtistService artistService;
    private AlbumService albumService;
    private TrackService trackService;

    public ArtistsAlbumsTracksLoader(ArtistService artistService, AlbumService albumService, TrackService trackService) {
        this.artistService = artistService;
        this.albumService = albumService;
        this.trackService = trackService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // creating artists
        Artist artist1 = createArtist("Kendrick Lamar", "United States", LocalDate.of(1987, 6, 17), null);
        Artist artist2 = createArtist("Tame Impala", "Australia", LocalDate.of(1986, 1, 20), null);

        // creating albums
        Album album1 = createAlbum("good kid, m.A.A.d city", artist1, 14);
        Album album2 = createAlbum("To Pimp a Butterfly", artist1, 16);
        Album album3 = createAlbum("Currents", artist2, 13);

        // creating tracks
        createTrack("Money Trees", artist1, album1, 386);
        createTrack("Backseat Freestyle", artist1, album1, 212);
        createTrack("Alright", artist1, album2, 219);
        createTrack("Let It Happen", artist2, album3, 467);
    }

    Artist createArtist(String name, String placeOfBirth, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Artist artist = new Artist();
        artist.setName(name);
        artist.setPlaceOfBirth(placeOfBirth);
        artist.setDateOfBirth(dateOfBirth);
        artist.setDateOfDeath(dateOfDeath);
        artistService.save(artist);
        return artist;
    }

    Album createAlbum(String name, Artist artist, Integer numberOfSongs) {
        Album album = new Album();
        album.setName(name);
        album.setArtist(artist);
        album.setNumberOfSongs(numberOfSongs);
        albumService.save(album);
        return album;
    }

    void createTrack(String name, Artist artist, Album album, Integer length) {
        Track track = new Track();
        track.setName(name);
        track.setArtist(artist);
        track.setAlbum(album);
        track.setLength(length);
        trackService.save(track);
    }
}
