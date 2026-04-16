package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.DadosListagemMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    //Metodo 201 Cadastro: Created" é utilizado como resposta de sucesso,
    // indica que a requisição foi bem sucedida e que um novo recurso foi criado.

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody  @Valid  DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
       var medico = new Medico(dados);
        repository.save (medico);

      var uri = uriBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    // Metodo 200 Listagem: "é a resposta de status de sucesso que indica que a requisição foi bem sucedida."
    @GetMapping
    public ResponseEntity <Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
         var page = repository.findAll(paginacao).map(DadosListagemMedico::new);
         return ResponseEntity.ok(page);
    }

    // Metodo 200 Atualizar: "é a resposta de status de sucesso que indica que a requisição foi bem sucedida."
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){

       var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));

    }

    //Metodo 2004 Excluir: No Content indica que a solicitação foi bem sucedida e o cliente
    // não precisa sair da página atual
     @DeleteMapping("/{id}")
     @Transactional
     public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    //Metodo 200 detalhar: Created" "é a resposta de status de sucesso
    // que indica que a requisição foi bem sucedida."
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);


        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}