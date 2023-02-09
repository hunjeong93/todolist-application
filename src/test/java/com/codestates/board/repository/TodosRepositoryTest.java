package com.codestates.board.repository;

import com.codestates.board.entity.Todos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TodosRepositoryTest {
    @Autowired
    private TodosRepository todosRepository;
    @Test
    public void saveTodos() {
        Todos todos = new Todos();
        todos.setTitle("운동하기");
        todos.setTodo_order(1);
        todos.setCompleted(false);

        Todos savedTodos = todosRepository.save(todos);

        assertNotNull(savedTodos);
        assertTrue(todos.getTitle().equals(savedTodos.getTitle()));
        assertTrue(todos.getTodo_order() == 1);

    }
}