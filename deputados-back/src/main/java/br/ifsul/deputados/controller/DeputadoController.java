package br.ifsul.deputados.controller;

import br.ifsul.deputados.controller.request.EditarEventoRequest;
import br.ifsul.deputados.controller.response.DeputadoResponse;
import br.ifsul.deputados.controller.response.EventoResponse;
import br.ifsul.deputados.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deputados")
public class DeputadoController {
    @Autowired
    private ListarDeputadosService listarDeputadosService;
    @Autowired
    private ListarEventosDeputadoService listarEventosDeputadoService;
    @Autowired
    private PopularBancoDeputadosService popularBancoDeputadosService;
    @Autowired
    private InscreverDeputadoEventoService inscreverDeputadoEventoService;
    @Autowired
    private EditarEventoDeputadoService editarEventoDeputadoService;
    @Autowired
    private RemoverEventoDeputadoService removerEventoDeputadoService;
    @Autowired
    private DetalharDeputadoService detalharDeputadoService;

    @PostMapping("popular")
    public void popular(){
        popularBancoDeputadosService.popular();
    }

    @GetMapping
    public List<DeputadoResponse> listar(){
        return listarDeputadosService.listar();
    }
    @GetMapping("{id}")
    public DeputadoResponse detalhar(@PathVariable Long id){
        return detalharDeputadoService.detalhar(id);
    }
    @GetMapping("{idDeputado}/eventos")
    public List<EventoResponse> listarEventos(@PathVariable Long idDeputado){
        return listarEventosDeputadoService.listarDoDeputado(idDeputado);
    }

    @PutMapping("{idDeputado}/eventos/{idEvento}")
    public void inscrever(@PathVariable Long idDeputado, @PathVariable Long idEvento){
        inscreverDeputadoEventoService.inscrever(idDeputado, idEvento);
    }
    @PutMapping("{idDeputado}/eventos")
    public EventoResponse editar(@PathVariable Long idDeputado, @RequestBody EditarEventoRequest editarEventoRequest){
        return editarEventoDeputadoService.editar(idDeputado, editarEventoRequest);
    }
    @DeleteMapping("{idDeputado}/eventos/{idEvento}")
    public void remover(@PathVariable Long idDeputado, @PathVariable Long idEvento){
        removerEventoDeputadoService.remover(idDeputado, idEvento);
    }
}
