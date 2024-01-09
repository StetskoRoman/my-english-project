package com.rv.english.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String listingName;

    private Long totalAmountWords;
//(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "listing")
//     @JoinColumn(name = "word_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Word> words = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Library library;


}
