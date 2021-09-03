package ws.synopsis.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.synopsis.training.model.Client;
import ws.synopsis.training.service.ClientService;

import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    private ClientService service;

    @GetMapping({"/client", "", "/"})
    public ResponseEntity<?> index(){
        List<Client> clients = service.list();
        return ResponseEntity.ok().body(clients);
    }

    @PostMapping
    public String index(Client client, Model model){
        model.addAttribute("name", client.getName());
        model.addAttribute("email", client.getEmail());
        return "client/index";
    }

}
