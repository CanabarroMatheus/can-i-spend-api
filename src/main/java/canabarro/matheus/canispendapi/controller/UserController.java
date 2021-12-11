package canabarro.matheus.canispendapi.controller;

import canabarro.matheus.canispendapi.controller.request.UserRequest;
import canabarro.matheus.canispendapi.security.service.AuthenticationService;
import canabarro.matheus.canispendapi.service.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRequest request) {

        return new ResponseEntity<>(service.saveUser(UserMapper.mapperRequestToEntity(request)), HttpStatus.CREATED);
    }

    @Operation(description = "Login")
    @PostMapping("/login")
    public void fakeLogin(@RequestBody UserRequest request) {
        throw new IllegalStateException("Esse método não deve ser chamado. É apenas um 'Workaround'");
    }
}
