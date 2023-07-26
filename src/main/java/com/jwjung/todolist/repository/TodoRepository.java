package com.jwjung.todolist.repository;

import com.jwjung.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Todo: 구현해야 할 추가 메소드 (검색, 필터링 등)
}
