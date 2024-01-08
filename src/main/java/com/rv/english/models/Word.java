package com.rv.english.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    private boolean isVisibleWord;

    private Long countShow;
    private Long countAdds;
    private Long countComplains;
    private boolean isBadWord;

    private boolean isGoodWord;

    private String transcription;

    @OneToOne
    private Account wordAccount;



}
