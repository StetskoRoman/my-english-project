package com.rv.english.models;


import jakarta.persistence.*;
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

    private String wordName;
    private String explanation;
    private String example;
    private boolean isSaved;

    private Long countShow;
    private Long countAdds;
    private Long countComplains;
    private boolean isBadWord;

    @OneToOne
    private Account wordAuthor;



}
