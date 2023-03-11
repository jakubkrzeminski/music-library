package pl.jakub.musiclibrary.album;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.jakub.musiclibrary.artist.Artist;

import java.util.Date;

@Entity
@Table(name = "album")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    @NotNull(message = "Artist must not be null.")
    private Artist artist;

    @NotEmpty(message = "Name is a required field.")
    private String name;

    @Column(name = "number_of_songs")
    private Integer numberOfSongs;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
