package com.domain;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder @Setter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull @Column(name = "author")
    String author;
    @NotNull @Column(name = "title")
    String title;
    @NotNull @Column(name = "content")
    String content;

    @ManyToOne
    Member member;

}
