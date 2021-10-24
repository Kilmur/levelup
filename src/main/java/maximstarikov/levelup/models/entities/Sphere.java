package maximstarikov.levelup.models.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Types;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter // TODO : подумать над lombok аннотациями для разных типов
@Entity
@Table(name = "spheres")
public class Sphere {

    @Id
    @SequenceGenerator(name = "spheres_gen", sequenceName = "spheres_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spheres_gen")
    private Long id;

    // TODO : генерация через аннотацию
    private UUID uuid = UUID.randomUUID();

    private String name;

    // TODO : подумать
    private Instant createdDate = Instant.now();

    private String backgroundColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sphere", fetch = FetchType.LAZY)
    private Set<Goal> goals;
}
