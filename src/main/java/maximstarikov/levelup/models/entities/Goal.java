package maximstarikov.levelup.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Type(type = "uuid-char")
    private UUID uuid;

    private Instant createdDate;

    private Instant targetDate;

    private String name;
    private String description;
    private boolean finished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sphere_id")
    private Sphere sphere;

    @OneToMany(mappedBy = "goal", fetch = FetchType.LAZY)
    private Set<Step> steps;

    // TODO : сделать заполнение по другому, как и для create Sphere
    public Goal(String name, String description, Sphere sphere, Instant targetDate) {
        this.name = name;
        this.description = description;
        this.sphere = sphere;
        this.targetDate = targetDate;
        this.uuid = UUID.randomUUID();
        this.createdDate = Instant.now();
    }
}
