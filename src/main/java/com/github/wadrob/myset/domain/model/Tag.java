package com.github.wadrob.myset.domain.model;

import javax.persistence.*;

@Entity
@Table (name = "tags")
public class Tag {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
