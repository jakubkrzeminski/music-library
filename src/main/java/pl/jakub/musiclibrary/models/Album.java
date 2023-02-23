package pl.jakub.musiclibrary.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private long id;
    private Artist artist;
    private String name;
    private int numberOfSongs;
}
