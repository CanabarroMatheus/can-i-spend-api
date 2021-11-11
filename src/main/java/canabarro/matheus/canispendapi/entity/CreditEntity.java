package canabarro.matheus.canispendapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
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
    private Double amount;

    @Column(name = "ISSUE_DATE", nullable = false)
    private LocalDate issueDate;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @ManyToOne
    @JoinColumn(name = "ID_BALANCE", referencedColumnName = "ID_BALANCE")
    private BalanceEntity balance;
}
