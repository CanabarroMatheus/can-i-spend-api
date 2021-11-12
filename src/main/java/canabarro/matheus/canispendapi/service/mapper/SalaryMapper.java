package canabarro.matheus.canispendapi.service.mapper;

import canabarro.matheus.canispendapi.controller.request.SalaryRequest;
import canabarro.matheus.canispendapi.controller.response.SalaryResponse;
import canabarro.matheus.canispendapi.entity.BalanceEntity;
import canabarro.matheus.canispendapi.entity.SalaryEntity;

public class SalaryMapper {
    private SalaryMapper() {

    }

    public static SalaryResponse mapperEntityToResponse(SalaryEntity entity) {
        return SalaryResponse.builder()
                .id(entity.getId())
                .income(entity.getIncome())
                .payDay(entity.getPayDay())
                .isRegulatedPaid(entity.getIsRegulatedPaid())
                .updatedAt(entity.getUpdatedAt())
                .idBalance(entity.getBalance().getId())
                .build();
    }

    public static SalaryEntity mapperRequestToEntity(SalaryRequest request, BalanceEntity balance) {
        return SalaryEntity.builder()
                .income(request.getIncome())
                .payDay(request.getPayDay())
                .isRegulatedPaid(request.getIsRegulatedPaid())
                .balance(balance)
                .build();
    }
}
