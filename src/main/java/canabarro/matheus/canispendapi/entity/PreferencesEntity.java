package canabarro.matheus.canispendapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PREFERENCES")
public class PreferencesEntity {
    @Id
    @SequenceGenerator(name = "PREFERENCES_SEQ", sequenceName = "PREFERENCES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "PREFERENCES_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PREFERENCES")
    private Long id;

    @Column(name = "SAVING_PERCENTAGE", nullable = false)
    private Double savingPercentage;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "ID_BALANCE", referencedColumnName = "ID_BALANCE")
    private BalanceEntity balance;
}
