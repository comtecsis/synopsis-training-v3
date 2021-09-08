package ws.synopsis.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.training.beans.model.Book;
import ws.synopsis.training.beans.model.Client;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.repository.BookRepository;

import java.util.List;

public interface BookService {

    public List<Book> list();
    public void delete(Long id);
    public void update(Book client);
    public void add(Book client);

}
