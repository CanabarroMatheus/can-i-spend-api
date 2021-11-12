package canabarro.matheus.canispendapi.controller.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class PreferencesRequest {
    @NotNull
    @PositiveOrZero
    private BigDecimal savingPercentage;
    @NotNull
    @Positive
    private Long idBalance;
}
