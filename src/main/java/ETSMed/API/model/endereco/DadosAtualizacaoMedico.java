package ETSMed.API.model.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull int id, String nome, String telefone, DadosEndereco endereco) {




}
