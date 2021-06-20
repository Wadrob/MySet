package com.github.wadrob.myset.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "collections")
@Getter @Setter @ToString (exclude = "items")
@NoArgsConstructor
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Size(min = 3, max = 60)
    private String name;
    @Size(max = 500)
    private String description;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "collection")
    private List<Item> items = new ArrayList<>();

    public Collection(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }
}
