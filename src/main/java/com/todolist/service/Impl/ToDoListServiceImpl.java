package com.todolist.service.Impl;

import com.todolist.dto.ToDoListDto;
import com.todolist.entity.ToDoList;
import com.todolist.repository.ToDoListRepository;
import com.todolist.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ToDoListDto addTask(ToDoListDto toDoListDto) {
        try {
            ToDoList toDoLists = toDoListDto.convertDtoToEntity(toDoListDto);
            toDoListRepository.save(toDoLists);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return toDoListDto;
    }

    @Override
    public ToDoListDto modifyTask(ToDoListDto updatedToDoList) {
        Optional<ToDoList> toDoList = toDoListRepository.findById(updatedToDoList.getId());
        ToDoListDto toDoListDtoResult;
        if (toDoList.isEmpty()) {
            throw new RuntimeException("Id not found in tasks");
        } else {
            ToDoList updatedToDoListResult = toDoListRepository.save(ToDoListDto.convertDtoToEntity(updatedToDoList));
            toDoListDtoResult = ToDoList.convertEntityToDto(updatedToDoListResult);
        }
        return toDoListDtoResult;
    }

    @Override
    public String deleteTask(Integer id) {
        Optional<ToDoList> toDoList = toDoListRepository.findById(id);
        if (toDoList.isEmpty()) {
            throw new RuntimeException("Id not found in tasks");
        }
        toDoListRepository.deleteById(id);
        return "Task Deleted Successfully";
    }
}
