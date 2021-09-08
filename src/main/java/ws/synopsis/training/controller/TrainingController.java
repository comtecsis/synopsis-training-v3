package ws.synopsis.training.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.beans.base.TrainingStatus;
import ws.synopsis.training.beans.model.Client;
import ws.synopsis.training.enumeraciones.TrainingStatusEnum;
import ws.synopsis.training.exception.TrainingException;
import ws.synopsis.training.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
public class TrainingController {

    private static Logger logger = LoggerFactory.getLogger(TrainingController.class);

    @Autowired
    private ClientService service;

    @Value("${project.name}")
    private String projectName;

    @GetMapping({"/client", "", "/"})
    public ResponseEntity<?> clientGet(HttpServletRequest request) throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostName();
        logger.debug("METHOD GET: " + host);
        logger.debug("PROJECT NAME: " + projectName);
        List<Client> clients = service.list();
        return ResponseEntity.ok().body(new TrainingResponse(TrainingStatusEnum.OK.getStatus(), clients));
    }

    @GetMapping({"/client2"})
    public ResponseEntity<?> client2Get(HttpServletRequest request) throws UnknownHostException, AccessDeniedException {
        String host = InetAddress.getLocalHost().getHostName();
        logger.debug("METHOD GET 2: " + host);
        List<Client> clients = service.list();
        return ResponseEntity.ok().body(new TrainingResponse(TrainingStatusEnum.OK.getStatus(), clients));
    }

    @PostMapping({"/client"})
    public ResponseEntity<?> clientPost(@RequestBody Client client, HttpServletRequest request) throws TrainingException {
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
