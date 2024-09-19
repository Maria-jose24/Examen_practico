package com.example.task.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailService {
	  @Autowired
	    private JavaMailSender emailSender;

	    public void sendTaskAssignmentNotification(String to, String taskTitle) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Nueva tarea asignada");
	        message.setText("Se le ha asignado una nueva tarea: " + taskTitle);
	        emailSender.send(message);
	    }

	    public void sendTaskDeadlineNotification(String to, String taskTitle) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Próxima fecha de vencimiento");
	        message.setText("La tarea '" + taskTitle + "' está próxima a vencer.");
	        emailSender.send(message);
	    }

	    public void sendTaskOverdueNotification(String to, String taskTitle) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("Tarea vencida");
	        message.setText("La tarea '" + taskTitle + "' ha vencido.");
	        emailSender.send(message);
	    }
}