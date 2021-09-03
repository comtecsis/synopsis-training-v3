package ws.synopsis.training.repository.impl;

import org.springframework.stereotype.Repository;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.beans.model.Client;
import ws.synopsis.training.repository.ClientRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private static Map<Integer, Client> clients = new HashMap<>();

    @PostConstruct
    private void addData(){
        int i = 0;
        clients.put(Integer.valueOf(++i), Client.builder().id(i).email("elvisperez.tec@gmail.com").name("Elvis Perez").build());
        clients.put(Integer.valueOf(++i), Client.builder().id(i).email("elvisperez.tec2@gmail.com").build());
        clients.put(Integer.valueOf(++i), Client.builder().id(i).name("Elvis3 Perez").build());
    }

    @Override
    public void delete(Integer id) {
        clients.remove(id);
    }

    @Override
    public void update(Client client) throws TrainingException {
        Client result = clients.get(client.getId());
        if(result == null)
        {
            throw new TrainingException("El cliente no existe.");
        }
        clients.put(client.getId(), client);
    }

    @Override
    public void add(Client client) throws TrainingException {
        Client result = clients.get(client.getId());
        if(result != null)
        {
            throw new TrainingException("El cliente existe.");
        }
        clients.put(client.getId(), client);
    }

    @Override
    public List<Client> list() {
        List<Client> result3 = clients.values().stream()
                .collect(Collectors.toList());
        return result3;
    }
}
