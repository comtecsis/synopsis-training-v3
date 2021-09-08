package ws.synopsis.training.beans.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LibraryAsign {
    private Long bookId;
    private Long personId;
}
