package com.example.task.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.task.Model.Task;

@Repository
public interface ITask extends CrudRepository<Task, Long>{

}