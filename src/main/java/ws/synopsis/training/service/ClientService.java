package ws.synopsis.training.service;

import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.beans.model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> list();
    public void delete(Integer id);
    public void update(Client client) throws TrainingException;
    public void add(Client client) throws TrainingException;
}
