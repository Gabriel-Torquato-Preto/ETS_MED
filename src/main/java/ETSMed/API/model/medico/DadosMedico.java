package ETSMed.API.model.medico;

import ETSMed.API.model.endereco.Endereco;

public record DadosMedico(int id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco, boolean ativo) {
    public DadosMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco(), medico.isAtivo());

    }
}
