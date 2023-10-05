package ETSMed.API.controller;

import ETSMed.API.model.endereco.DadosAtualizacaoMedico;
import ETSMed.API.model.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico, UriComponentsBuilder uriComponentsBuilder){
        var medico = new Medico(dadosCadastroMedico);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        repository.save(medico);
        return ResponseEntity.created(uri).body(new DadosMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 5, sort ={"nome"})Pageable pageble){
        var page =  repository.findByAtivoTrue(pageble).map(DadosListagemMedico::new);
        return  ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional

    public ResponseEntity autalizar(@RequestBody @Valid DadosAtualizacaoMedico dadosAtualizacaoMedico){
        var medico = repository.getReferenceById(dadosAtualizacaoMedico.id()) ;
        medico.atualizarInformacoes(dadosAtualizacaoMedico);

        return null;

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable int id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable int id){
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosMedico(medico));
    }



}
