package com.example.task.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.example.task.Model.Task;

public interface ITaskService {

	 List<Task> findAll();
	    Optional<Task> findById(Long id);
	    Task save(Task task);
	    void delete(Long id);
}
