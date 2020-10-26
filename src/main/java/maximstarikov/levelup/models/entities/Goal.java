package maximstarikov.levelup.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "target_date")
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
