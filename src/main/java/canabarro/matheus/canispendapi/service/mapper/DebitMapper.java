package canabarro.matheus.canispendapi.service.mapper;

import canabarro.matheus.canispendapi.controller.request.DebitRequest;
import canabarro.matheus.canispendapi.controller.response.DebitResponse;
import canabarro.matheus.canispendapi.entity.BalanceEntity;
import canabarro.matheus.canispendapi.entity.DebitEntity;

public class DebitMapper {
    private DebitMapper() {

    }

    public static DebitResponse mapperEntityToResponse(DebitEntity entity) {
        return DebitResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .issueDate(entity.getIssueDate())
                .description(entity.getDescription())
                .idBalance(entity.getBalance().getId())
                .build();
    }

    public static DebitEntity mapperRequestToEntity(DebitRequest request, BalanceEntity balance) {
        return DebitEntity.builder()
                .title(request.getTitle())
                .price(request.getPrice())
                .issueDate(request.getIssueDate())
                .description(request.getDescription())
                .balance(balance)
                .build();
    }
}
