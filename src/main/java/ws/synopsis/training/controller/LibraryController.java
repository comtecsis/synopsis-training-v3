package ws.synopsis.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.beans.model.Person;
import ws.synopsis.training.beans.request.LibraryAsign;
import ws.synopsis.training.enumeraciones.TrainingStatusEnum;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.service.LibraryService;
import ws.synopsis.training.service.PersonService;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private static Logger logger = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    private LibraryService service;

    @PostMapping("/assign")
    public ResponseEntity<?> asign(@RequestBody LibraryAsign bean, HttpServletRequest request) throws UnknownHostException {
        service.assing(bean);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unassign")
    public ResponseEntity<?> clientPost(@RequestBody LibraryAsign bean, HttpServletRequest request) throws TrainingException {
        service.unassing(bean);
        return ResponseEntity.ok().build();
    }

}
