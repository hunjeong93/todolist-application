package com.codestates.board.service;

import com.codestates.board.entity.Todos;
import com.codestates.board.repository.TodosRepository;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TodosService {
    private final TodosRepository todosRepository;

    public TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public Todos createTodos(Todos todos) {
        Todos savedTodos = todosRepository.save(todos);
        return todosRepository.save(todos);
    }

    public Todos findTodos(long id) {
        Optional<Todos> optionalTodos = todosRepository.findById(id);
        Todos findTodos = optionalTodos.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.TODOS_NOT_FOUND));
        return findTodos;
    }

    public List<Todos> findTodos() {
        return todosRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public Todos updateTodos(Todos todos) {
        Todos findTodos = findTodos(todos.getId());

        Optional.ofNullable(todos.getTitle())
                .ifPresent(title -> findTodos.setTitle(title));
        Optional.ofNullable(todos.getTodo_order())
                .ifPresent(todo_order -> findTodos.setTodo_order(todo_order));
        Optional.ofNullable(todos.isCompleted())
                .ifPresent(completed -> findTodos.setCompleted(completed));

        return todosRepository.save(findTodos);
    }

    public void deleteTodos(long id) {
        Todos findTodos = findTodos(id);
        todosRepository.delete(findTodos);
    }
    public void deleteTodos() {
        todosRepository.deleteAll();
    }
}
