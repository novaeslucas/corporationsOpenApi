package com.novaeslucas.corporationsOpenApi.mapper;

import com.novaeslucas.corporationsOpenApi.entity.Pessoa;
import com.novaeslucas.corporationsOpenApi.model.PessoaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PessoaMapper {

    public static PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nome", source = "nome"),
            @Mapping(target = "cpf", source = "cpf"),
            @Mapping(target = "estadoCivil", source = "estadoCivil"),
            @Mapping(target = "ativo", source = "ativo"),
    })
    Pessoa mapTo(PessoaDTO pessoaDTO);

    List<PessoaDTO> mapTo(List<Pessoa> pessoas);

    @InheritInverseConfiguration
    PessoaDTO mapTo(Pessoa pessoa);

}
