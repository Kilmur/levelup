package maximstarikov.levelup.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "goals")
@Setter
@Getter
@NoArgsConstructor
public class Goal {

    @Id
    @SequenceGenerator(name = "goals_seq_gen", sequenceName = "goals_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goals_seq_gen")
    private Long id;

    private UUID uuid;

    private Instant createdDate;

    private Instant targetDate;

    @NotBlank
    private String name;
    private String description;
    private boolean finished;

    @NotBlank
    private String backgroundColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sphere_id")
    private Sphere sphere;

    @OneToMany(mappedBy = "goal", fetch = FetchType.LAZY)
    private Set<Step> steps;

    // TODO : сделать заполнение по другому, как и для create Sphere
    public Goal(String name, String description, String backgroundColor, Sphere sphere, Instant targetDate) {
        this.name = name;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.sphere = sphere;
        this.targetDate = targetDate;
        this.uuid = UUID.randomUUID();
        this.createdDate = Instant.now();
    }
}
