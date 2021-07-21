package maximstarikov.levelup.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "success_journal")
public class SuccessGoal { // TODO : подумать как назвать более нормально

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
