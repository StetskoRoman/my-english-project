package com.rv.english.models.workModels;


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

    @NotBlank
    private String explanation;
    private String example;

    private String transcription;
//    private boolean turnOnWord;



    @ManyToOne(fetch = FetchType.LAZY)
    private Listing listing;

    private LevelUsefulWord levelUsefulWord;
}


//    @ManyToOne
//    private Library library;

//    @Embedded
//    private VisibleWord visibleWord;