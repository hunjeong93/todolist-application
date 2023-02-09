package com.codestates.board.mapper;

import com.codestates.board.dto.TodosDto;
import com.codestates.board.entity.Todos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TodosMapper {

    Todos todosPostDtoToTodos(TodosDto.Post requestBody);

    Todos todosPatchDtoToTodos(TodosDto.Patch requestBody);
    Todos todosToTodosResponse(Todos todos);
    List<Todos> todosToTodosResponses(List<Todos> todos);
}
