package com.example.task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.Model.Respuesta;
import com.example.task.Model.Task;
import com.example.task.Service.TaskService;

import jakarta.validation.Valid;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin
public class TaskController {
	   @Autowired
	    private TaskService taskService;

	    @GetMapping
	    public ResponseEntity<List<Task>> getAllTasks() {
	        List<Task> tasks = taskService.findAll();
	        return ResponseEntity.ok(tasks);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
	        Optional<Task> task = taskService.findById(id);
	        if (task.isPresent()) {
	            return ResponseEntity.ok(task.get());
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Respuesta("Error", "Tarea no encontrada"));
	        }
	    }

	    @PostMapping
	    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
	        Task savedTask = taskService.save(task);
	        return ResponseEntity.ok(savedTask);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskUpdate) {
	        Optional<Task> existingTask = taskService.findById(id);

	        if (existingTask.isPresent()) {
	            Task task = existingTask.get();
	            task.setTitle(taskUpdate.getTitle());
	            task.setDueDate(taskUpdate.getDueDate());
	            task.setAssignedTo(taskUpdate.getAssignedTo());
	            task.setStatus(taskUpdate.getStatus());

	            Task updatedTask = taskService.save(task);
	            return ResponseEntity.ok(updatedTask);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Respuesta("Error", "Tarea no encontrada"));
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Respuesta> deleteTask(@PathVariable Long id) {
	        try {
	            taskService.delete(id);
	            return ResponseEntity.ok(new Respuesta("Success", "Tarea eliminada correctamente"));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Respuesta("Error", "Tarea no encontrada"));
	        }
	    }
}