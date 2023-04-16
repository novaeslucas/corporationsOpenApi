package com.novaeslucas.corporationsOpenApi.service;

import com.novaeslucas.corporationsOpenApi.entity.Pessoa;
import com.novaeslucas.corporationsOpenApi.mapper.PessoaMapper;
import com.novaeslucas.corporationsOpenApi.model.PessoaDTO;
import com.novaeslucas.corporationsOpenApi.model.PessoaDTOResponse;
import com.novaeslucas.corporationsOpenApi.repository.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaDTOResponse getAll(Pageable pageable){
        Page<Pessoa> pessoas = pessoaRepository.getAllAtivos(pageable);
        PessoaDTOResponse pessoaDTOResponse = new PessoaDTOResponse();
        if(pessoas != null && !pessoas.getContent().isEmpty()){
            List<PessoaDTO> pessoasDTO = PessoaMapper.INSTANCE.mapTo(pessoas.getContent());
            pessoaDTOResponse.setItems(pessoasDTO);
            pessoaDTOResponse.setItensPaginaAtual(pessoasDTO.size());
            pessoaDTOResponse.setPaginaAtual(pessoas.getNumber());
            pessoaDTOResponse.setTotalItens(Long.valueOf(pessoas.getTotalElements()).intValue());
            pessoaDTOResponse.setTotalPaginas(Long.valueOf(pessoas.getTotalPages()).intValue());
        }
        return pessoaDTOResponse;
    }

    public PessoaDTO inserir(PessoaDTO pessoaDTO){
        Pessoa pessoa = PessoaMapper.INSTANCE.mapTo(pessoaDTO);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return PessoaMapper.INSTANCE.mapTo(pessoaSalva);
    }
}
