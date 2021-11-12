package canabarro.matheus.canispendapi.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BALANCE")
public class BalanceEntity {
    @Id
    @SequenceGenerator(name = "BALANCE_SEQ", sequenceName = "BALANCE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "BALANCE_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_BALANCE")
    private Long id;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private UserEntity user;

    @OneToOne(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private SalaryEntity salary;

    @OneToOne(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private PreferencesEntity preferences;

    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillEntity> bills;

    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditEntity> credits;

    @OneToMany(mappedBy = "balance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DebitEntity> debits;
}
