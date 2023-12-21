package br.ifsul.deputados.controller;

import br.ifsul.deputados.controller.response.EventoResponse;
import br.ifsul.deputados.service.ListarEventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("eventos")
public class EventoController {
    @Autowired
    private ListarEventosService listarEventosService;

    @GetMapping
    public List<EventoResponse> listar(){
        return listarEventosService.listar();
    }
}
