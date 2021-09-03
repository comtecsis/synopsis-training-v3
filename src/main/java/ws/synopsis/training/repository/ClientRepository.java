package ws.synopsis.training.repository;

import org.springframework.stereotype.Component;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.beans.model.Client;

import java.util.List;

@Component
public interface ClientRepository {

    public void delete(Integer id);
    public void update(Client client) throws TrainingException;
    public void add(Client client) throws TrainingException;
    public List<Client> list();

    //TODO: Implements findByName
    //public void findByName(String name);

}
