package maximstarikov.levelup.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "steps")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private Instant targetDate;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

}
