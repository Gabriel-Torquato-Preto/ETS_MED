package ETSMed.API.model.user;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUser(@NotBlank String username, @NotBlank String password) {

}
