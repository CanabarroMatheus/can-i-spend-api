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
@Table(name = "DEBIT")
public class DebitEntity {
    @Id
    @SequenceGenerator(name = "DEBIT_SEQ", sequenceName = "DEBIT_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "DEBIT_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DEBIT")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "ISSUE_DATE", nullable = false)
    private LocalDate issueDate;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "ID_BALANCE", referencedColumnName = "ID_BALANCE")
    private BalanceEntity balance;
}
