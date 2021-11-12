package canabarro.matheus.canispendapi.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class SalaryRequest {
    @NotNull
    @PositiveOrZero
    private BigDecimal income;
    @Positive
    @Max(30)
    private Byte payDay;
    @NotNull
    private Boolean isRegulatedPaid;
    @NotNull
    @Positive
    private Long idBalance;
}
