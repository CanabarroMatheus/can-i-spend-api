package canabarro.matheus.canispendapi.controller;

import canabarro.matheus.canispendapi.controller.request.CreditRequest;
import canabarro.matheus.canispendapi.controller.response.CreditResponse;
import canabarro.matheus.canispendapi.controller.response.IdResponse;
import canabarro.matheus.canispendapi.exception.ExpectedException;
import canabarro.matheus.canispendapi.service.CreditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/v1/credit")
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @GetMapping
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Page<CreditResponse>> findAll(
            @RequestParam int index,
            @RequestParam int size
    ) {
        return new ResponseEntity<>(creditService.findAllPageable(index, size), HttpStatus.OK);
    }

    @GetMapping("/{idCredit}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<CreditResponse> findById(@PathVariable Long idCredit) throws ExpectedException {
        return new ResponseEntity<>(creditService.getCredit(idCredit), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<IdResponse> save(@RequestBody CreditRequest request) throws ExpectedException {
        return new ResponseEntity<>(creditService.save(request), HttpStatus.CREATED);
    }

    @PutMapping("/{idCredit}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity update(@PathVariable Long idCredit, @RequestBody CreditRequest creditRequest) throws ExpectedException {
        creditService.update(creditRequest, idCredit);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idCredit}")
    @Operation(summary = "My endpoint", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity delete(@PathVariable Long idCredit) throws ExpectedException {
        creditService.delete(idCredit);
        return ResponseEntity.ok().build();
    }
}
