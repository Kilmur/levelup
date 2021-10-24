package maximstarikov.levelup.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "success_journal")
public class SuccessGoal { // TODO : подумать как назвать более нормально

    @Id
    @SequenceGenerator(name = "success_journal_gen", sequenceName = "success_journal_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "success_journal_gen")
    private Long id;
}
