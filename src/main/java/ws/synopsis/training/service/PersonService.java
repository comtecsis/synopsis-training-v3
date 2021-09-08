package ws.synopsis.training.service;

import ws.synopsis.training.beans.model.Book;
import ws.synopsis.training.beans.model.Person;

import java.util.List;

public interface PersonService {

    public List<Person> list();
    public void delete(Long id);
    public void update(Person client);
    public void add(Person client);

}
