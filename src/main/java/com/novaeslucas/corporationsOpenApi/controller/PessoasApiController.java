package com.novaeslucas.corporationsOpenApi.controller;

import com.novaeslucas.corporationsOpenApi.api.PessoasApi;
import com.novaeslucas.corporationsOpenApi.model.PessoaDTO;
import com.novaeslucas.corporationsOpenApi.model.PessoaDTOResponse;
import com.novaeslucas.corporationsOpenApi.service.PessoaService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class PessoasApiController implements PessoasApi {

    private final HttpServletRequest request;

    private final PessoaService pessoaService;

    public PessoasApiController(@Autowired(required = false) HttpServletRequest request, PessoaService pessoaService) {
        this.request = request;
        this.pessoaService = pessoaService;
    }

    @Override
    public ResponseEntity<PessoaDTOResponse> getPessoas(@Min(0)@ApiParam(value = "O número da página a ser retornada.", defaultValue = "0") @Valid @RequestParam(value = "page", required = false, defaultValue="0") Integer page, @Min(1) @Max(100) @ApiParam(value = "O tamanho da página a ser retornada.", defaultValue = "20") @Valid @RequestParam(value = "size", required = false, defaultValue="20") Integer size) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Pageable pageable = PageRequest.of(page, size);
            PessoaDTOResponse response = pessoaService.getAll(pageable);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<PessoaDTO> inserir(PessoaDTO pessoaDTO){
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {

            PessoaDTO response = pessoaService.inserir(pessoaDTO);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
