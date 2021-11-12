package canabarro.matheus.canispendapi.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BalanceResponse {
    private Long id;
    private Double balance;
    private SalaryResponse salary;
    private String username;
    private PreferencesResponse preferences;
    private List<BillResponse> bills;
    private List<CreditResponse> credits;
    private List<DebitResponse> debits;
}
