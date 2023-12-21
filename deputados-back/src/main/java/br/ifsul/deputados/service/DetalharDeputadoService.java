package br.ifsul.deputados.service;

import br.ifsul.deputados.controller.response.DeputadoResponse;
import br.ifsul.deputados.mapper.DeputadoMapper;
import br.ifsul.deputados.repository.DeputadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.ifsul.deputados.mapper.DeputadoMapper.toResponse;

@Service
public class DetalharDeputadoService {
    @Autowired
    private DeputadoRepository deputadoRepository;

    public DeputadoResponse detalhar(Long id){
        return toResponse(deputadoRepository.findById(id).get());
    }
}
