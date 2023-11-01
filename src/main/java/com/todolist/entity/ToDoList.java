package com.todolist.entity;

import com.todolist.dto.ToDoListDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ToDoList {
    @Id
    private Integer id;
    private String task;
    private String description;

    public static ToDoListDto convertEntityToDto(ToDoList toDoList) {
        ToDoListDto toDoListDto = new ToDoListDto();
        toDoListDto.setId(toDoList.getId());
        toDoListDto.setTask(toDoList.getTask());
        toDoListDto.setDescription(toDoList.getDescription());
        return toDoListDto;
    }
}
