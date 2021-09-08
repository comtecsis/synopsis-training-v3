package ws.synopsis.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.synopsis.training.beans.model.Book;
import ws.synopsis.training.beans.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
