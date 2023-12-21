package com.rv.english.models;


//import com.rv.english.models.enums.AccountRoles;
import com.rv.english.models.enums.AccountRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "your name can`t be empty")
    private String accountName;
    @NotNull
    @NotBlank(message = "password can`t be empty")
    private String password;


    @NotBlank
    @Email
    private String email;

    private String homeLang;

    private String activationCode;

    private Long countBadWords;

    private Boolean active;

    private Boolean visibleWords;

    @Transient
    public boolean isAdmin() {
        return roles.contains(AccountRoles.ADMIN);
    }

//    вспомогательная таблица
    @ElementCollection(targetClass = AccountRoles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private List<AccountRoles> roles;


//    id в library будет совпадать с id акка, соответственно незачем делать отдельный стобец со связью @MapsId в library добавить, тут зависимость по хожу не нужна
//    @OneToOne(cascade = CascadeType.ALL,  mappedBy = "account")
//    private Library library;


    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "account")
    private List<Photo> photos = new ArrayList<>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getAccountName();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
