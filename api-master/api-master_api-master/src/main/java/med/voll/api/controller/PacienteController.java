package med.voll.api.controller;

public class PacienteController {

    /*@RestController
    @RequestMapping("pacientes")
    public class PacienteController {

        @Autowired
        private PacienteRepository repository;

        @PostMapping
        @Transactional
        public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
            repository.save(new Paciente(dados));

        }
        @GetMapping
        public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
            return repository.findAll(paginacao).map(DadosListagemPaciente::new);
        }
        @PutMapping
        @Transactional
        public void atualizar(@RequestBody @Valid DadosListagemPaciente.DadosAtualizacaoPaciente dados) {
            var paciente = repository.getReferenceById(dados.id());
            paciente.atualizarInformacoes(dados);
        }

        @DeleteMapping("/{id}")
        @Transactional
        public void remover(@PathVariable Long id) {
            var paciente = repository.getReferenceById(id);
            paciente.inativar();
        }*/
    }
