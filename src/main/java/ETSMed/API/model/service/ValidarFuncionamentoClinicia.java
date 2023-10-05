package ETSMed.API.model.service;

import ETSMed.API.model.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarFuncionamentoClinicia implements ValidarAgendamentoDeConsultas{
    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){
        var dataConsulta = dadosAgendamentoConsulta.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDeAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDeAberturaDaClinica || depoisDoEncerramentoDaClinica){
            throw new RuntimeException("Consulta fora do horario de funcionamento da clinica");
        }
    }
}
