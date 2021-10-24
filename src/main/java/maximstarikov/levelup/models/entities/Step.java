package maximstarikov.levelup.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "steps")
public class Step {

    @Id
    @SequenceGenerator(name = "steps_gen", sequenceName = "steps_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "steps_gen")
    private Long id;

    private UUID uuid;

    private String name;
    private String description;
    private Instant createdDate;
    private Instant targetDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    private Goal goal;

}
