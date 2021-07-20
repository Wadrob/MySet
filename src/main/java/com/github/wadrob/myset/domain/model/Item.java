package com.github.wadrob.myset.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "items")
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Size (min = 5, max = 60)
    private String name;
    @Size(max = 500)
    private String description;
    // TODO Enum zamiast String
    //      @Enumarated z JPA
    @NotNull
    private String status;
    @ManyToOne
    private Collection collection;
    @NotNull
    @Size(min = 3)
    private String date;
    @ManyToMany
    private List <Tag> tags = new ArrayList<>();
}
