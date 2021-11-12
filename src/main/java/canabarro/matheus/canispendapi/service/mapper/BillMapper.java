package canabarro.matheus.canispendapi.service.mapper;

import canabarro.matheus.canispendapi.controller.request.BillRequest;
import canabarro.matheus.canispendapi.controller.response.BillResponse;
import canabarro.matheus.canispendapi.entity.BalanceEntity;
import canabarro.matheus.canispendapi.entity.BillEntity;

public class BillMapper {
    private BillMapper() {
    }

    public static BillResponse mapperEntityToResponse(BillEntity entity) {
        return BillResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .dueDay(entity.getDueDay())
                .description(entity.getDescription())
                .isFinished(entity.getIsFinished())
                .isMonthly(entity.getIsMonthly())
                .idBalance(entity.getBalance().getId())
                .build();
    }

    public static BillEntity mapperRequestToEntity(BillRequest request, BalanceEntity balance) {
        return BillEntity.builder()
                .title(request.getTitle())
                .price(request.getPrice())
                .dueDay(request.getDueDay())
                .description(request.getDescription())
                .isMonthly(request.getIsMonthly())
                .balance(balance)
                .build();
    }
}
