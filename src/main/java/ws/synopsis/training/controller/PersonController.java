package ws.synopsis.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.beans.model.Book;
import ws.synopsis.training.beans.model.Person;
import ws.synopsis.training.enumeraciones.TrainingStatusEnum;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.service.BookService;
import ws.synopsis.training.service.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<?> clientGet(HttpServletRequest request) throws UnknownHostException {
        List<Person> clients = service.list();
        return ResponseEntity.ok().body(new TrainingResponse(TrainingStatusEnum.OK.getStatus(), clients));
    }

    @PostMapping
    public ResponseEntity<?> clientPost(@Valid @RequestBody Person client, HttpServletRequest request) throws TrainingException {
        service.add(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> clientPut(@RequestBody Person client) throws TrainingException {
        service.update(client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> clientDelete(@PathVariable("id") Long id) throws TrainingException {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
