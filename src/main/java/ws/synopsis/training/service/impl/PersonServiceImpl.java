package ws.synopsis.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.training.beans.model.Book;
import ws.synopsis.training.beans.model.Person;
import ws.synopsis.training.repository.BookRepository;
import ws.synopsis.training.repository.PersonRepository;
import ws.synopsis.training.service.BookService;
import ws.synopsis.training.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository bookRepository;

    public List<Person> list() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Person client) {
        bookRepository.save(client);
    }

    @Override
    public void add(Person client) {
        bookRepository.save(client);
    }
}
