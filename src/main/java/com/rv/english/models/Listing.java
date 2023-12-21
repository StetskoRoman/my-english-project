package com.rv.english.models;


import jakarta.persistence.*;
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
    private Long id;

    private String listingName;

    private Long totalAmountWords;
//(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "listing")
//     @JoinColumn(name = "word_id")
    @OneToMany(cascade = CascadeType.ALL)
    List<Word> words = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Library library;


}
