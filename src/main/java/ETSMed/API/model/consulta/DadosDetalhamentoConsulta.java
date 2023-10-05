package ETSMed.API.model.consulta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(int id, int idMedico, int idPaciente, LocalDateTime data) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(),consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
