package com.codestates.board.repository;

import com.codestates.board.entity.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosRepository extends JpaRepository<Todos, Long> {
}
