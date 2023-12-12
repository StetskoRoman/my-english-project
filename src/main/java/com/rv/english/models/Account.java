package com.rv.english.models;


import com.rv.english.models.enums.AccountRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickName;

    private String password;

    private String email;

    private String homeLang;

    private String activationCode;

    private Long countBadWords;

//    вспомогательная таблица
    @ElementCollection(targetClass = AccountRoles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private List<AccountRoles> roles;


    @OneToOne
    private Library library;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
    private List<Photo> photos = new ArrayList<>();



}
