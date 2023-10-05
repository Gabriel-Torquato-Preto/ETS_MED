package ETSMed.API.controller;

import ETSMed.API.model.medico.DadosCadastroMedico;
import ETSMed.API.model.medico.MedicoRepository;
import ETSMed.API.model.paciente.DadosCadastroPaciente;
import ETSMed.API.model.paciente.DadosListagemPaciente;
import ETSMed.API.model.paciente.Paciente;
import ETSMed.API.model.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public ResponseEntity<Paciente> cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente, UriComponentsBuilder uriComponentsBuilder) {

        var paciente = new Paciente(dadosCadastroPaciente);
        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        repository.save(paciente);
        return ResponseEntity.created(uri).body(paciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageble) {
        var listaPaciente = repository.findAll();
        return ResponseEntity.ok(listaPaciente);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Paciente> deletar(@PathVariable int id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}