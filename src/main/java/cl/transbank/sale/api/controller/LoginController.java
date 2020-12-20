package cl.transbank.sale.api.controller;

import cl.transbank.sale.domain.model.JwtResponse;
import cl.transbank.sale.domain.model.UserDTO;
import cl.transbank.sale.domain.usescase.LoginUseCase;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginUseCase loginUseCase;

    @PostMapping
    @Operation(summary = "Authenticacion API")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody UserDTO user){
        return ResponseEntity.ok(loginUseCase.login(user));
    }
}
