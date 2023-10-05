package ETSMed.API.model.service;

import ETSMed.API.model.consulta.Consulta;
import ETSMed.API.model.consulta.ConsultaRepository;
import ETSMed.API.model.consulta.DadosAgendamentoConsulta;
import ETSMed.API.model.consulta.DadosDetalhamentoConsulta;
import ETSMed.API.model.medico.Medico;
import ETSMed.API.model.medico.MedicoRepository;
import ETSMed.API.model.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AgendaDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidarAgendamentoDeConsultas> validadores;
    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dadosAgendamentoConsulta){
        if(!pacienteRepository.existsById(dadosAgendamentoConsulta.idPaciente())){
            throw new RuntimeException("ID do paciente não existe");

        }

        if(dadosAgendamentoConsulta.idMedico()!=0 && !medicoRepository.existsById(dadosAgendamentoConsulta.idMedico())){
            throw new RuntimeException("Id do médico informado não existe");
        }
        validadores.forEach(v->v.validar(dadosAgendamentoConsulta));

        var paciente = pacienteRepository.findById(dadosAgendamentoConsulta.idPaciente()).get();
        var medico = escolharMedico(dadosAgendamentoConsulta);
        var consulta = new Consulta(0, medico, paciente, dadosAgendamentoConsulta.data());
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolharMedico(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        if(dadosAgendamentoConsulta.idMedico() != 0){
            return medicoRepository.getReferenceById(dadosAgendamentoConsulta.idMedico());
        }
        if(dadosAgendamentoConsulta.especialidade()==null){
            throw new RuntimeException("Especialidade é obrigatória quando não selciona médico");
        }
        return medicoRepository.escolherMedicoAleatorioLivreData(dadosAgendamentoConsulta.especialidade(), dadosAgendamentoConsulta.data());
    }



}
