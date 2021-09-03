package ws.synopsis.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.beans.model.Client;
import ws.synopsis.training.service.ClientService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    private ClientService service;

    @GetMapping({"/client", "", "/"})
    public ResponseEntity<?> clientGet(){
        List<Client> clients = service.list();
        return ResponseEntity.ok().body(clients);
    }

    @PostMapping({"/client"})
    public ResponseEntity<?> clientPost(@RequestBody Client client) throws TrainingException {
        service.add(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping({"/client"})
    public ResponseEntity<?> clientPut(@RequestBody Client client) throws TrainingException {
        service.update(client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/client/{id}"})
    public ResponseEntity<?> clientDelete(@PathVariable("id") Integer id) throws TrainingException {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
