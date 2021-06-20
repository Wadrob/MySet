package com.github.wadrob.myset.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "tags")
@Getter @Setter
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Size (min = 3, max = 25)
    private String name;
    @ManyToOne
    private User user;

}
