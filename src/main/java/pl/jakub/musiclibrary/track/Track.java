package pl.jakub.musiclibrary.track;

import jakarta.persistence.*;
import lombok.*;
import pl.jakub.musiclibrary.album.Album;
import pl.jakub.musiclibrary.artist.Artist;

@Entity
@Table(name = "track")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;

    @Column(name = "length")
    private Integer length;

}
