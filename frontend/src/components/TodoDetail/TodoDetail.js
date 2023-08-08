import React from "react";

function TodoDetail({ todo }) {
  return (
    <div className="container mt-5">
      <h1 className="mb-4">할 일 상세</h1>
      <form>
        <div className="input-group mb-3">
          <input
            type="text"
            className="form-control"
            name="title"
            value={todo.title}
            readOnly
          />
          <div className="input-group-append">
            <button type="submit" className="btn btn-primary">
              수정
            </button>
          </div>
        </div>
        <div className="form-check mb-3">
          <input
            type="checkbox"
            className="form-check-input"
            name="completed"
            checked={todo.completed}
            readOnly
          />
          <label className="form-check-label">완료</label>
        </div>
      </form>
      <button className="btn btn-danger">삭제</button>
    </div>
  );
}

export default TodoDetail;
