package ws.synopsis.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ws.synopsis.training.model.Client;

@Controller
public class TrainingController {

    @GetMapping({"/index","/"})
    public String index(Model model) {
        model.addAttribute("client", new Client());
        return "index";
    }

    @PostMapping("/client")
    public String client(@ModelAttribute Client client, Model model) {

        model.addAttribute("client", client);

        return "client";
    }

}
