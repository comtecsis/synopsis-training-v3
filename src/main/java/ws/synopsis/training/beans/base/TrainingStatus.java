package ws.synopsis.training.beans.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TrainingStatus {
    private String code;
    private String message;
}
