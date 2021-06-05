package maximstarikov.levelup.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data // TODO : подумать над lombok аннотациями для разных типов
@Entity
@Table(name = "spheres")
public class Sphere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID uuid;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sphere", fetch = FetchType.LAZY)
    private Set<Goal> goals;
}
