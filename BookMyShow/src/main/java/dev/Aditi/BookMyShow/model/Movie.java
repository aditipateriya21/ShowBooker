package dev.Aditi.BookMyShow.model;

import dev.Aditi.BookMyShow.model.constants.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    @ManyToMany
    private List<Actor> actors;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<MovieFeature> movieFeatures;
    public Movie()
    {

    }
    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
