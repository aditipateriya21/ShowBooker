package dev.Aditi.BookMyShow.repository;

import dev.Aditi.BookMyShow.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
