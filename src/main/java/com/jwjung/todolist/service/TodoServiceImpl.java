package com.jwjung.todolist.service;

import com.jwjung.todolist.model.Todo;
import com.jwjung.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void updateTodoById(Long id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        if (existingTodo != null) {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setCompleted(todo.isCompleted());
            todoRepository.save(existingTodo);
        }
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
