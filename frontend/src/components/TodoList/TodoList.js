import React from "react";

function TodoList({ todos, onDeleteTodo, onToggleComplete }) {
  return (
    <ul className="list-group">
      {todos.map((todo) => (
        <li key={todo.id} className="list-group-item">
          <input
            type="checkbox"
            checked={todo.completed}
            onChange={() => onToggleComplete(todo.id)}
          />
          <span className={todo.completed ? "completed" : ""}>{todo.title}</span>
          <button
            className="btn btn-sm btn-outline-danger ml-2"
            onClick={() => onDeleteTodo(todo.id)}
          >
            삭제
          </button>
        </li>
      ))}
    </ul>
  );
}

export default TodoList;
