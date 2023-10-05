package ETSMed.API.model.paciente;


import ETSMed.API.model.endereco.DadosEndereco;
import ETSMed.API.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome, cpf, email, telefone;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente){

        this.nome = dadosCadastroPaciente.nome();
        this.cpf = dadosCadastroPaciente.cpf();
        this.email= dadosCadastroPaciente.email();
        this.telefone = dadosCadastroPaciente.telefone();
        this.endereco = new Endereco(dadosCadastroPaciente.endereco());

    }


}
