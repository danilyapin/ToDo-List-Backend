package com.project.todo_list.Repository;

import com.project.todo_list.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByCompletedTrue();
}
