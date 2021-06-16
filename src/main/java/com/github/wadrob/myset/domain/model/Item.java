package com.github.wadrob.myset.domain.model;

import javax.persistence.*;

@Entity
@Table (name = "items")
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String status;
}
