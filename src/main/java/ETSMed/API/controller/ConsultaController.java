package ETSMed.API.controller;

import ETSMed.API.model.consulta.DadosAgendamentoConsulta;
import ETSMed.API.model.consulta.DadosDetalhamentoConsulta;
import ETSMed.API.model.service.AgendaDeConsulta;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private AgendaDeConsulta agendaDeConsulta;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dadosAgendamentoConsulta){
        var detalhamentoConsultas = agendaDeConsulta.agendar(dadosAgendamentoConsulta);
        return ResponseEntity.ok(detalhamentoConsultas);
    }
}
