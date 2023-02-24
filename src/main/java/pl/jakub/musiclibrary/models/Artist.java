package pl.jakub.musiclibrary.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    private long id;
    private String name;
    private String placeOfBirth;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
}
