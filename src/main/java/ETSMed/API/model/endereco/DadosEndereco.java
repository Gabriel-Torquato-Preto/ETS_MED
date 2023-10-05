package ETSMed.API.model.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(String logradouro,
                            String bairro,
                             @Pattern(regexp = "\\d{8}") String cep,
                              String cidade,
                             @Pattern(regexp = "^[a-zA-Z]{2}$") String uf,
                            String complemento,
                            String numero) {
}
