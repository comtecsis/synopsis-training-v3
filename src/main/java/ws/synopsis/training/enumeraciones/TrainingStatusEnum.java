package ws.synopsis.training.enumeraciones;

import lombok.Getter;
import ws.synopsis.training.beans.base.TrainingStatus;

@Getter
public enum TrainingStatusEnum {

    OK("0000", "Proceso exitoso.")
    , FAIL("9000", "Proceso con errores.");

    private TrainingStatus status;

    TrainingStatusEnum(String code, String message){
        status = new TrainingStatus(code, message);
    }

}
