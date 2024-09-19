package com.example.task.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.InterfaceService.ITaskService;
import com.example.task.Interfaces.ITask;
import com.example.task.Model.Task;

@Service
public class TaskService implements ITaskService {
	
	@Autowired
    private ITask taskRepository;

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}