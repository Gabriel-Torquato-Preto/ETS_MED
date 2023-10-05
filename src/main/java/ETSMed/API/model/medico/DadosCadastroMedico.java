package ETSMed.API.model.medico;

import ETSMed.API.model.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record DadosCadastroMedico(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Pattern(regexp = "\\d{4,6}") String crm, @NotNull Especialidade especialidade, @NotNull @Valid Endereco endereco, @NotBlank @Pattern(regexp = "\\d{11}") String telefone) {
}
