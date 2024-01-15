package com.rv.english.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Profile {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private Account account;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "profile")
    private List<Photo> photos = new ArrayList<>();

    private String homeLang;

    private Integer countBadWords;

    private Integer countGoodWords;

    private Integer countAllWordsAdded;

    private Boolean visibleWords;

    private Integer rating;
}
