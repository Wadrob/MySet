package com.github.wadrob.myset.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "collections")
@Getter @Setter @ToString (exclude = "items")
@NoArgsConstructor
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Item> items;

    public Collection(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }
}
