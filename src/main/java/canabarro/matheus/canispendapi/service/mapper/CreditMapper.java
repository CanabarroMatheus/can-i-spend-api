package canabarro.matheus.canispendapi.service.mapper;

import canabarro.matheus.canispendapi.controller.request.CreditRequest;
import canabarro.matheus.canispendapi.controller.response.CreditResponse;
import canabarro.matheus.canispendapi.entity.BalanceEntity;
import canabarro.matheus.canispendapi.entity.CreditEntity;

public class CreditMapper {
    private CreditMapper() {

    }

    public static CreditResponse mapperEntityToResponse(CreditEntity entity) {
        return CreditResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .amount(entity.getAmount())
                .issueDate(entity.getIssueDate())
                .description(entity.getDescription())
                .idBalance(entity.getBalance().getId())
                .build();
    }

    public static CreditEntity mapperRequestToEntity(CreditRequest request, BalanceEntity balance) {
        return CreditEntity.builder()
                .title(request.getTitle())
                .amount(request.getAmount())
                .issueDate(request.getIssueDate())
                .description(request.getDescription())
                .balance(balance)
                .build();
    }
}
