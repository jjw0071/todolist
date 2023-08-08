import React, { useState, useEffect } from "react";
import TodoList from './components/TodoList/TodoList';
import TodoDetail from './components/TodoDetail/TodoDetail';
import "./App.css";

function App() {
  const [todos, setTodos] = useState([]);
  const [newTodo, setNewTodo] = useState("");
  const [selectedTodo, setSelectedTodo] = useState(null);

  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/todos");
      const data = await response.json();
      setTodos(data);
    } catch (error) {
      console.error("Error fetching todos:", error);
    }
  };

  const addTodo = async (event) => {
    event.preventDefault();
    if (newTodo.trim() === "") return;

    try {
      await fetch("http://localhost:8080/api/todos", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ title: newTodo }),
      });
      setNewTodo("");
      fetchTodos();
    } catch (error) {
      console.error("Error adding todo:", error);
    }
  };

  const deleteTodo = async (id) => {
    try {
      await fetch(`http://localhost:8080/api/todos/${id}`, {
        method: "DELETE",
      });
      fetchTodos();
    } catch (error) {
      console.error("Error deleting todo:", error);
    }
  };

  const selectTodo = (id) => {
    setSelectedTodo(todos.find(todo => todo.id === id));
  };

  const toggleComplete = async (id) => {
      const todo = todos.find(todo => todo.id === id);
      if (!todo) return;

      try {
        await fetch(`http://localhost:8080/api/todos/${id}`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ ...todo, completed: !todo.completed }),
        });
        fetchTodos();
      } catch (error) {
        console.error("Error toggling todo complete:", error);
      }
  };

  return (
    <div className="container mt-5">
      <h1 className="mb-4">To-Do List</h1>
      <form onSubmit={addTodo}>
        <div className="input-group mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="할 일 추가"
            value={newTodo}
            onChange={(e) => setNewTodo(e.target.value)}
          />
          <div className="input-group-append">
            <button type="submit" className="btn btn-primary">
              추가
            </button>
          </div>
        </div>
      </form>
      <TodoList todos={todos} onTodoClick={selectTodo} onDeleteTodo={deleteTodo} onToggleComplete={toggleComplete} />
      {selectedTodo && <TodoDetail todo={selectedTodo} />}
    </div>
  );
}

export default App;
