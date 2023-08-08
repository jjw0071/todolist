package com.jwjung.todolist.service;

import com.jwjung.todolist.model.Todo;
import com.jwjung.todolist.repository.TodoRepository;
import com.jwjung.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        return optionalTodo.orElse(null);
    }

    @Override
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        if (todoRepository.existsById(id)) {
            todo.setId(id);
            return todoRepository.save(todo);
        }
        return null;
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
