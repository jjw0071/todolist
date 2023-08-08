package com.jwjung.todolist.service;

import com.jwjung.todolist.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id);
    Todo addTodo(Todo todo);
    Todo updateTodo(Long id, Todo todo);
    void deleteTodo(Long id);
}