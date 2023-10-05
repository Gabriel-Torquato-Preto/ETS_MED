package ETSMed.API.model.paciente;

import ETSMed.API.model.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cache;

public record DadosCadastroPaciente(@NotBlank String nome, @NotBlank String cpf, @NotBlank String email, @NotBlank String telefone, @NotNull @Valid
                                    DadosEndereco endereco) {
}
