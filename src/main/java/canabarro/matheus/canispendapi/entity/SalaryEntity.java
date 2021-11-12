package canabarro.matheus.canispendapi.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SALARY")
public class SalaryEntity {
    @Id
    @SequenceGenerator(name = "SALARY_SEQ", sequenceName = "SALARY_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "SALARY_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_SALARY")
    private Long id;

    @Column(name = "INCOME", nullable = false)
    private BigDecimal income;

    @Column(name = "PAY_DAY")
    private Byte payDay;

    @Column(name = "IS_REGULATED_PAID", nullable = false)
    private Boolean isRegulatedPaid;

    @Column(name = "UPDATED_AT", nullable = false)
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "ID_BALANCE", referencedColumnName = "ID_BALANCE")
    private BalanceEntity balance;
}
