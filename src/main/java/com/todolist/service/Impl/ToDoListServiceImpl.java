package com.todolist.service.Impl;

import com.todolist.dto.ToDoListDto;
import com.todolist.entity.ToDoList;
import com.todolist.repository.ToDoListRepository;
import com.todolist.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    @Autowired
    private ToDoListRepository toDoListRepository;

    @Override
    public List<ToDoListDto> fetchAllTasks() {
        List<ToDoListDto> toDoListDtoList = new ArrayList<>();
        List<ToDoList> allTasksFromEntity = toDoListRepository.findAll();
        ToDoList toDoLists = new ToDoList();
        for(ToDoList toDoList:allTasksFromEntity){
            toDoListDtoList.add(toDoLists.convertEntityToDto(toDoList));
        }
        return toDoListDtoList;
    }

    @Override
    public String addTask(ToDoListDto toDoListDto) {
        try {
            ToDoList toDoLists = toDoListDto.convertDtoToEntity(toDoListDto);
            toDoListRepository.save(toDoLists);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Task added successfully";
    }

    @Override
    public ToDoListDto modifyTask(ToDoListDto updatedToDoList) {
        ToDoList updatedToDoListResult = toDoListRepository.save(ToDoListDto.convertDtoToEntity(updatedToDoList));
        ToDoListDto toDoListDtoResult =  ToDoList.convertEntityToDto(updatedToDoListResult);
        return toDoListDtoResult;
    }

    @Override
    public String deleteTask(Integer id) {
        toDoListRepository.deleteById(id);
        return "Task Deleted Successfully";
    }
}
