package com.todolist.dto;

import com.todolist.entity.ToDoList;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ToDoListDto {
    private Integer id;
    @NotNull(message = "task column is mandatory")
    @NotBlank(message = "task column should not be blank")
    private String task;
    @NotNull(message = "description column is mandatory")
    @NotBlank(message = "description column should not be blank")
    private String description;

    public static ToDoList convertDtoToEntity(ToDoListDto toDoListDto) {
        ToDoList toDoList = new ToDoList();
        toDoList.setId(toDoListDto.getId());
        toDoList.setTask(toDoListDto.getTask());
        toDoList.setDescription(toDoListDto.getDescription());
        return toDoList;
    }
}
