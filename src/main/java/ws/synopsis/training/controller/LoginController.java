package ws.synopsis.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.beans.base.TrainingStatus;
import ws.synopsis.training.beans.dto.LoginDTO;
import ws.synopsis.training.beans.request.LoginRequest;
import ws.synopsis.training.beans.request.LogoffRequest;
import ws.synopsis.training.exception.AccessLogicException;
import ws.synopsis.training.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/v1")
public class LoginController
{

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<TrainingResponse<LoginDTO>> login(@Valid @RequestBody LoginRequest login, HttpServletRequest request)
            throws AccessLogicException
    {
        TrainingResponse<LoginDTO> response = loginService.login(login);
        return new ResponseEntity<TrainingResponse<LoginDTO>>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<TrainingResponse> logout(@Valid @RequestBody LogoffRequest logoffReq, HttpServletRequest request)
    {
        TrainingStatus status = loginService.logout(logoffReq);
        return new ResponseEntity<TrainingResponse>(new TrainingResponse(status), HttpStatus.OK);
    }

}