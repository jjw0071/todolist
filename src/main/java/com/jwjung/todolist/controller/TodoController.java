package com.jwjung.todolist.controller;

import com.jwjung.todolist.model.Todo;
import com.jwjung.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/")
    public String getTodoList(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    @GetMapping("/todo/{id}")
    public String getTodoDetail(@PathVariable Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo_detail";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute Todo todo) {
        todoService.updateTodoById(id, todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/";
    }
}
