package canabarro.matheus.canispendapi.service.mapper;

import canabarro.matheus.canispendapi.controller.request.PreferencesRequest;
import canabarro.matheus.canispendapi.controller.response.PreferencesResponse;
import canabarro.matheus.canispendapi.entity.BalanceEntity;
import canabarro.matheus.canispendapi.entity.PreferencesEntity;

public class PreferencesMapper {
    private PreferencesMapper() {

    }

    public static PreferencesResponse mapperEntityToResponse(PreferencesEntity entity) {
        return PreferencesResponse.builder()
                .id(entity.getId())
                .savingPercentage(entity.getSavingPercentage())
                .updatedAt(entity.getUpdatedAt())
                .idBalance(entity.getBalance().getId())
                .build();
    }

    public static PreferencesEntity mapperRequestToEntity(PreferencesRequest request, BalanceEntity balance) {
        return PreferencesEntity.builder()
                .savingPercentage(request.getSavingPercentage())
                .balance(balance)
                .build();
    }
}
