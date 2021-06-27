package maximstarikov.levelup.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
}
