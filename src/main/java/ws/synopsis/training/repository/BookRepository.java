package ws.synopsis.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ws.synopsis.training.beans.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
