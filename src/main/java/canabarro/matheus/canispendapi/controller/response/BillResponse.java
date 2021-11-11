package canabarro.matheus.canispendapi.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillResponse {
    private Long id;
    private String title;
    private Double price;
    private Byte dueDay;
    private String description;
    private Boolean isFinished;
    private Boolean isMonthly;
    private Long idBalance;
}
