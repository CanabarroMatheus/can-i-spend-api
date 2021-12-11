package canabarro.matheus.canispendapi.service.mapper;

import canabarro.matheus.canispendapi.controller.request.UserRequest;
import canabarro.matheus.canispendapi.entity.UserEntity;

public class UserMapper {
    public static UserEntity mapperRequestToEntity(UserRequest request) {
        return UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
