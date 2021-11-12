package canabarro.matheus.canispendapi.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BillRequest {
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @PositiveOrZero
    private BigDecimal price;
    @PositiveOrZero
    private Byte dueDay;
    @Length(max = 500)
    private String description;
    @NotNull
    private Boolean isMonthly;
    @NotNull
    @Positive
    private Long idBalance;
}
