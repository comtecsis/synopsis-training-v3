package ws.synopsis.training.repository;

import org.springframework.stereotype.Component;
import ws.synopsis.training.model.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface ClientRepository {

    public void delete(Integer id);
    public void update(Integer id, Client client);
    public void add(Client client);
    public List<Client> list();

    //TODO: Implements findByName
    //public void findByName(String name);

}
