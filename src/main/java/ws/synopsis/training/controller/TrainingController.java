package ws.synopsis.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String index(Client client, Model model){
        model.addAttribute("name", client.getName());
        model.addAttribute("email", client.getEmail());
        return "client/index";
    }

}
