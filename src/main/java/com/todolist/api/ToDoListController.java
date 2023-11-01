package com.todolist.api;

import com.todolist.dto.ToDoListDto;
import com.todolist.service.ToDoListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/fetch")
    public List<ToDoListDto> fetchAllTasks() {
        return toDoListService.fetchAllTasks();
    }

    @PostMapping("/add")
    public String addTask(@Valid @RequestBody ToDoListDto toDoListDto) {
        return toDoListService.addTask(toDoListDto);
    }

    @PutMapping("/update")
    public ToDoListDto updateTasks(@Valid @RequestBody ToDoListDto toDoListDto) {
        return toDoListService.modifyTask(toDoListDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Integer id) {
        return toDoListService.deleteTask(id);
    }
}
