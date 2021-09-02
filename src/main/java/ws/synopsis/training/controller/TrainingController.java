package ws.synopsis.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ws.synopsis.training.model.Client;

@Controller
public class TrainingController {

    @GetMapping
    public String index(){
        return "index";
    }

    @PostMapping
    public String index(Client client){

        return "client";
    }

}
