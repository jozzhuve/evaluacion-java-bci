package pe.bci.com.clients.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class ClientRequest {

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "El apellido es requerido")
    @Email
    private String email;

    @NotBlank(message = "El password es requerido")
    private String password;

    private List<PhoneRequest> phones;
}
