package canabarro.matheus.canispendapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BILL")
public class BillEntity {
    @Id
    @SequenceGenerator(name = "BILL_SEQ", sequenceName = "BILL_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "BILL_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_BILL")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "DUE_DAY")
    private Byte dueDay;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "IS_FINISHED", nullable = false)
    private Boolean isFinished;

    @Column(name = "IS_MONTHLY", nullable = false)
    private Boolean isMonthly;

    @ManyToOne
    @JoinColumn(name = "ID_BALANCE", referencedColumnName = "ID_BALANCE")
    private BalanceEntity balance;
}
