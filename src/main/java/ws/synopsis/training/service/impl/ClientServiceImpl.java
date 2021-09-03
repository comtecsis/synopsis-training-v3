package ws.synopsis.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.synopsis.training.model.Client;
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
}
