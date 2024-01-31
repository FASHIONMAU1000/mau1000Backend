package com.domain;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.Getter;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Column(name = "username")
    String username;

    @NotNull
    @Column(name = "password")
    String password;

    @NotNull
    @Column(name = "role")
    Role role;


    @OneToMany(mappedBy = "member")
    List<Post> posts = new ArrayList<>();

}
