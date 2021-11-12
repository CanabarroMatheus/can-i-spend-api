package canabarro.matheus.canispendapi.service.mapper;

import canabarro.matheus.canispendapi.controller.response.BalanceResponse;
import canabarro.matheus.canispendapi.entity.BalanceEntity;

import java.util.stream.Collectors;

public class BalanceMapper {
    private BalanceMapper() {

    }

    public static BalanceResponse mapperEntityToResponse(BalanceEntity entity) {
        return BalanceResponse.builder()
                .id(entity.getId())
                .balance(entity.getBalance())
                .username(entity.getUser().getName())
                .salary(SalaryMapper.mapperEntityToResponse(entity.getSalary()))
                .preferences(PreferencesMapper.mapperEntityToResponse(entity.getPreferences()))
                .bills(entity.getBills().stream()
                        .map(BillMapper::mapperEntityToResponse)
                        .collect(Collectors.toList()))
                .credits(entity.getCredits().stream()
                        .map(CreditMapper::mapperEntityToResponse)
                        .collect(Collectors.toList()))
                .debits(entity.getDebits().stream()
                        .map(DebitMapper::mapperEntityToResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}
