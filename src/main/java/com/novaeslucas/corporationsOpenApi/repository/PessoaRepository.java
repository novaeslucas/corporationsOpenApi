package com.novaeslucas.corporationsOpenApi.repository;

import com.novaeslucas.corporationsOpenApi.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {

//    @Query("select p from pessoa")
//    Page<Pessoa> getAll(Pageable pageable);

}
