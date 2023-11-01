package com.todolist.repository;

import com.todolist.entity.ToDoList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoListRepository extends MongoRepository<ToDoList,Integer> {
}
