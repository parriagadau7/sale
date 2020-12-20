package cl.transbank.sale.domain.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class ClientDTO {

    @NotNull(message = "name must not null")
    @NotEmpty(message = "name is mandatory")
    private String name;
    @NotNull(message = "lastName must not null")
    @NotEmpty(message = "lastName is mandatory")
    private String lastName;
    @Pattern(regexp="\\w+@\\w+\\.\\w+(,\\s*\\w+@\\w+\\.\\w+)*", message = "email invalid format")
    @NotNull(message = "email must not null")
    @NotEmpty(message = "email is mandatory")
    private String email;
    @Pattern(regexp="(^$|[0-9]{9})", message = "phone invalid format")
    @NotNull(message = "phone must not null")
    @NotEmpty(message = "phone is mandatory")
    private String phone;
}
