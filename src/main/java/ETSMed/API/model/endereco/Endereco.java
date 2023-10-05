package ETSMed.API.model.endereco;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String logradouro, bairro, cep, numero, complemento, cidade, uf;

    public Endereco(DadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.complemento();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();
    }

    public Endereco(Endereco endereco) {
        this.logradouro = endereco.logradouro;
        this.bairro = endereco.bairro;
        this.cep = endereco.cep;
        this.numero = endereco.numero;
        this.complemento = endereco.complemento;
        this.cidade = endereco.cidade;
        this.uf = endereco.uf;
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {

        this.logradouro = dadosEndereco.logradouro() != null ? dadosEndereco.logradouro():this.logradouro;
        this.bairro = dadosEndereco.bairro() != null ? dadosEndereco.bairro():this.bairro;
        this.cep = dadosEndereco.cep() != null ? dadosEndereco.cep():this.cep;
        this.numero = dadosEndereco.numero() != null ? dadosEndereco.numero():this.numero;
        this.cidade = dadosEndereco.cidade() != null ? dadosEndereco.cidade():this.cidade;
        this.uf = dadosEndereco.uf() != null ? dadosEndereco.uf():this.uf;
    }
}
