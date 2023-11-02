package com.todolist.service;

import com.todolist.dto.ToDoListDto;
import com.todolist.entity.ToDoList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ToDoListService {
    List<ToDoListDto> fetchAllTasks();
    ToDoListDto addTask(ToDoListDto toDoListDto);
    ToDoListDto modifyTask(ToDoListDto updatedToDoList);
    String deleteTask(Integer id);
}
