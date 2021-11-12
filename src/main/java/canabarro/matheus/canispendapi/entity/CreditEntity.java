package canabarro.matheus.canispendapi.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CREDIT")
public class CreditEntity {
    @Id
    @SequenceGenerator(name = "CREDIT_SEQ", sequenceName = "CREDIT_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CREDIT_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CREDIT")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "ISSUE_DATE", nullable = false)
    private LocalDate issueDate;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "ID_BALANCE", referencedColumnName = "ID_BALANCE")
    private BalanceEntity balance;
}
