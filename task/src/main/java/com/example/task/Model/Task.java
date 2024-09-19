package com.example.task.Model;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name="task")
public class Task {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @NotBlank(message = "El correo asignado es obligatorio")
    @Email(message = "Debe ser un correo electrónico válido")
    @Column(name = "assigned_to", nullable = false, length = 100, unique = true)
    private String assignedTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 50)
    private TaskStatus status;
    
	public Task() {
		super();
	}

	public Task(Long id, @NotBlank(message = "El título es obligatorio") String title,
			@NotNull(message = "La fecha de vencimiento es obligatoria") LocalDate dueDate,
			@NotBlank(message = "El correo asignado es obligatorio") @Email(message = "Debe ser un correo electrónico válido") String assignedTo,
			TaskStatus status) {
		super();
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.assignedTo = assignedTo;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
}
