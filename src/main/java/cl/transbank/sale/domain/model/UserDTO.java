package cl.transbank.sale.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserDTO {

    @NotNull(message = "username must not null")
    @NotEmpty(message = "username is mandatory")
    private String username;
    @NotNull(message = "password must not null")
    @NotEmpty(message = "password is mandatory")
    private String password;
}
