package com.rv.english.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Library {


    @Id
    private Long id;

    @OneToOne()
    private Account account;

    @OneToMany
    private List<Listing> listingSet = new ArrayList<>();
}
