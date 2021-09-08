package ws.synopsis.training.beans.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "PERSON")
@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.DETACH, orphanRemoval = false)
    @JoinColumn(name = "book_id")
    private List<Book> books;

}
