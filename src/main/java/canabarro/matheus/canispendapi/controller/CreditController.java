package canabarro.matheus.canispendapi.controller;

import canabarro.matheus.canispendapi.controller.response.CreditResponse;
import canabarro.matheus.canispendapi.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/v1/credit")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @GetMapping
    public ResponseEntity<Page<CreditResponse>> findAll(
            @RequestParam int index,
            @RequestParam int size
    ) {
        return new ResponseEntity<>(creditService.findAllPageable(index, size), HttpStatus.OK);
    }
}
