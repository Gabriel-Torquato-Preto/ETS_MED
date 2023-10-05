package ETSMed.API.model.service;

import ETSMed.API.model.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidarAgendamentoDeConsultas{
    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){
        var dataConsulta = dadosAgendamentoConsulta.data();
        var agora = LocalDateTime.now();
        var diferençaEmMinutos = Duration.between(dataConsulta,agora).toMinutes();

        if(diferençaEmMinutos <30){
            throw  new RuntimeException("Consulta deve ser agendada no minimo com 30 minutos de antecedencia");
        }
    }
}
