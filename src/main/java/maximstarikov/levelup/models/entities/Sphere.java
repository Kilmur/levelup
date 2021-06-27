package maximstarikov.levelup.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter // TODO : подумать над lombok аннотациями для разных типов
@Entity
@Table(name = "spheres")
public class Sphere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // TODO : генерация
    private UUID uuid;

    private String name;

    private Instant createdDate;

    private String backgroundColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sphere", fetch = FetchType.LAZY)
    private Set<Goal> goals;
}
