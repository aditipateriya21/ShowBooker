package dev.Aditi.BookMyShow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="ACTOR")
public class Actor extends  BaseModel{
@Column(name = "ACTOR_NAME")
private  String name;
@ManyToMany
private List<Movie> movies;
}
