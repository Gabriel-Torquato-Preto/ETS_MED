package ETSMed.API.model.medico;

import ETSMed.API.model.endereco.DadosAtualizacaoMedico;
import ETSMed.API.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome, email, crm, telefone;

    private boolean ativo;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dadosCadastroMedico) {
        this.ativo = true;
    this.nome = dadosCadastroMedico.nome();
    this.email = dadosCadastroMedico.email();
    this.crm = dadosCadastroMedico.crm();
    this.especialidade = dadosCadastroMedico.especialidade();
    this.endereco = new Endereco(dadosCadastroMedico.endereco());
    this.telefone = dadosCadastroMedico.telefone();

    }


    public void atualizarInformacoes(DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        if (dadosAtualizacaoMedico.nome() != null) {
            this.nome = dadosAtualizacaoMedico.nome();
        }
        if (dadosAtualizacaoMedico.telefone() != null) {
            this.telefone = dadosAtualizacaoMedico.telefone();
        }

        if (dadosAtualizacaoMedico.endereco() != null){
            endereco.atualizarInformacoes(dadosAtualizacaoMedico.endereco());
        }
    }

    public void excluir(){
        this.ativo = false;
    }
}
