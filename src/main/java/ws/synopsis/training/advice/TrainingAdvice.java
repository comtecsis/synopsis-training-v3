package ws.synopsis.training.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ws.synopsis.training.beans.base.TrainingResponse;
import ws.synopsis.training.enumeraciones.TrainingStatusEnum;

import java.util.List;

@ControllerAdvice
public class TrainingAdvice {

    private static final Logger logger = LoggerFactory.getLogger(TrainingAdvice.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception e){
        logger.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().body(TrainingStatusEnum.FAIL.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationHandler(MethodArgumentNotValidException e){
        logger.error(e.getMessage(), e);
        StringBuilder builder = new StringBuilder();
        List<FieldError> errors = e.getFieldErrors();
        errors.forEach(error ->
                builder.append(error.getField()).append(": ").append(error.getDefaultMessage())
        );
        TrainingResponse<MethodArgumentNotValidException> response = new TrainingResponse(TrainingStatusEnum.FAIL.getStatus(), builder.toString());
        return ResponseEntity.internalServerError().body(response);
    }

}
