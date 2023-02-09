package com.codestates.board.controller;

import com.codestates.board.dto.TodosDto;
import com.codestates.board.entity.Todos;
import com.codestates.board.mapper.TodosMapper;
import com.codestates.board.service.TodosService;
import com.codestates.board.utils.UriCreator;
import com.codestates.dto.SingleResponseDto;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/v1/todos")
@Slf4j
public class TodosController {
    public final static String TODOS_DEFAULT_URL = "/v1/todos";

    private final TodosService todosService;
    private final TodosMapper todosMapper;

    public TodosController(TodosService todosService, TodosMapper todosMapper) {
        this.todosService = todosService;
        this.todosMapper = todosMapper;
    }

    @PostMapping
    public ResponseEntity postTodos(@Valid @RequestBody TodosDto.Post requestBody) {
        Todos createdTodos = todosService.createTodos(todosMapper.todosPostDtoToTodos(requestBody));
//        URI location = UriCreator.createUri(TODOS_DEFAULT_URL, createdTodos.getTodosId());

        Todos findTodos = todosService.findTodos(createdTodos.getId());

//        return new ResponseEntity<>(
//                new SingleResponseDto<>(todosMapper.todosToTodosResponse(findTodos)), HttpStatus.CREATED);
        return new ResponseEntity(todosMapper.todosToTodosResponse(findTodos), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        List<Todos> findTodos = todosService.findTodos();
        return new ResponseEntity<>(todosMapper.todosToTodosResponses(findTodos),HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodos(@PathVariable("id") @Positive long id) {
        Todos todos = todosService.findTodos(id);
        return new ResponseEntity(todosMapper.todosToTodosResponse(todos),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchTods(@PathVariable("id") @Positive long id,
                                    @Valid @RequestBody TodosDto.Patch requestBody) {
        requestBody.setId(id);
        Todos todos =
                todosService.updateTodos(todosMapper.todosPatchDtoToTodos(requestBody));

        return new ResponseEntity(todosMapper.todosToTodosResponse(todos),HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTods(
            @PathVariable("id") @Positive long id) {
        todosService.deleteTodos(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteTods() {
        todosService.deleteTodos();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
