package dev.Aditi.BookMyShow.repository;

import dev.Aditi.BookMyShow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ShowRepository extends JpaRepository <Show,Integer>
{

}

