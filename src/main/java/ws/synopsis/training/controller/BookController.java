package ws.synopsis.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.beans.model.Book;
import ws.synopsis.training.beans.model.Client;
import ws.synopsis.training.enumeraciones.TrainingStatusEnum;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.service.BookService;
import ws.synopsis.training.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<?> clientGet(HttpServletRequest request) throws UnknownHostException {
        List<Book> clients = service.list();
        return ResponseEntity.ok().body(new TrainingResponse(TrainingStatusEnum.OK.getStatus(), clients));
    }

    @PostMapping
    public ResponseEntity<?> clientPost(@RequestBody Book client, HttpServletRequest request) throws TrainingException {
        service.add(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> clientPut(@RequestBody Book client) throws TrainingException {
        service.update(client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> clientDelete(@PathVariable("id") Long id) throws TrainingException {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
