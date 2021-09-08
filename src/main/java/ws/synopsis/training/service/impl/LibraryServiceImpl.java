package ws.synopsis.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.training.beans.model.Book;
import ws.synopsis.training.beans.model.Person;
import ws.synopsis.training.beans.request.LibraryAsign;
import ws.synopsis.training.repository.BookRepository;
import ws.synopsis.training.repository.PersonRepository;
import ws.synopsis.training.service.LibraryService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public void assing(LibraryAsign assing) {
        Optional<Person> person = repository.findById(assing.getPersonId());
        Optional<Book> book = bookRepository.findById(assing.getBookId());
        if(person.isPresent() && book.isPresent())
        {
            person.get().getBooks().add(book.get());
            repository.save(person.get());
        }
    }

    @Override
    @Transactional
    public void unassing(LibraryAsign assing) {
        Optional<Person> person = repository.findById(assing.getPersonId());
        Optional<Book> book = bookRepository.findById(assing.getBookId());
        if(person.isPresent() && book.isPresent())
        {
            person.get().getBooks().remove(book.get());
            repository.save(person.get());
        }
    }
}
