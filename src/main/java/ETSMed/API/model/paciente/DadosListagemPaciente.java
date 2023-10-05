package ETSMed.API.model.paciente;

import ETSMed.API.model.endereco.Endereco;
import ETSMed.API.model.medico.DadosListagemMedico;

public record DadosListagemPaciente(int id, String nome, String cpf, String email, String telefone) {
    DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone());
    }

}
