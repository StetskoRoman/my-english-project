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
//(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "listing")
    @OneToMany
    List<Word> words = new ArrayList<>();


}
