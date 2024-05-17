package dev.Aditi.BookMyShow.repository;

import dev.Aditi.BookMyShow.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium,Integer>{
    Auditorium findAuditoriumByName(String name);
}
