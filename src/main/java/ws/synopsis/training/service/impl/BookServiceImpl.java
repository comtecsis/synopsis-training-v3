package ws.synopsis.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.training.beans.model.Book;
import ws.synopsis.training.repository.BookRepository;
import ws.synopsis.training.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book client) {
        bookRepository.save(client);
    }

    @Override
    public void add(Book client) {
        bookRepository.save(client);
    }
}
