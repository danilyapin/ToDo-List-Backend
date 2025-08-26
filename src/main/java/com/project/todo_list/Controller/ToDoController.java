package com.project.todo_list.Controller;

import com.project.todo_list.Model.ToDo;
import com.project.todo_list.Repository.ToDoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {

    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todos")
    List<ToDo> allTodos(){
        return toDoRepository.findAll();
    }

    @PostMapping("/todos")
    ToDo newToDo(@RequestBody ToDo newToDo){
        return toDoRepository.save(newToDo);
    }

    @GetMapping("/erledigte-todos")
        List<ToDo> erledigteTodos(){
        return toDoRepository.findByCompletedTrue();
    }

    @DeleteMapping("/todos/{id}")
    void deleteToDo(@PathVariable Long id){
        toDoRepository.deleteById(id);
    }
}
