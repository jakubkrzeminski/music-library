package pl.jakub.musiclibrary.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    private long id;
    private Artist artist;
    private Album album;
    private int length;

}
