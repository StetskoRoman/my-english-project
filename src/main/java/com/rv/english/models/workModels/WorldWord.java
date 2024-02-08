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
public class WorldWord {

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

//    private boolean shownWord;

    @ManyToOne(fetch = FetchType.LAZY)
    private Profile profile;

    @Embedded
    private VisibleWord visibleWord;

    private LevelUsefulWord levelUsefulWord;
//find appropriate method to include language detection
    private String language;


}
