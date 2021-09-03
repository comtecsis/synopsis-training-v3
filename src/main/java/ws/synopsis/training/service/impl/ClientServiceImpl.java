package ws.synopsis.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.beans.model.Client;
import ws.synopsis.training.repository.ClientRepository;
import ws.synopsis.training.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> list() {
        return repository.list();
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public void update(Client client) throws TrainingException {
        repository.update(client);
    }

    @Override
    public void add(Client client) throws TrainingException {
        repository.add(client);
    }
}
