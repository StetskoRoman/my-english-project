package com.rv.english.models;


import com.rv.english.models.enums.LevelUsefulWord;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//there are no translations here because you need to understand what these word mean, finding right translation is a bad practice
    @NotBlank
    private String wordName;
    private String explanation;
    private String example;

    private String transcription;
//    private boolean turnOnWord;

    private boolean shownWord;

    @Embedded
    private VisibleWord visibleWord;

//    @ManyToOne
//    private Library library;

    @ManyToOne(fetch = FetchType.EAGER)
    private Listing listing;

    private LevelUsefulWord levelUsefulWord;

}
