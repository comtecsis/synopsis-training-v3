package ws.synopsis.training.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ws.synopsis.training.enumeraciones.TrainingStatusEnum;

@ControllerAdvice
public class TrainingAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TrainingAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception e){
        logger.error(e.getMessage(), e);
        return ResponseEntity.ok().body(TrainingStatusEnum.FAIL.getStatus());
    }

}
