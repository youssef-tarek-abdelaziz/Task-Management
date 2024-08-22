package com.task.management.service;

import com.task.management.domain.Task;
import com.task.management.enums.Status;
import com.task.management.exception.BadRequestException;
import com.task.management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskByTitle(String title) {
        Optional<Task> taskOptional = taskRepository.findByTitle(title);
        if(taskOptional.isEmpty())
            throw new BadRequestException(String.format("No Task with title: %s Found", title));
        return taskOptional.get();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        if(!taskRepository.existsById(task.getTitle()))
            throw new BadRequestException(String.format("Task with title: %s is not exist", task.getTitle()));
        Optional<Task> taskOptional = taskRepository.findByTitle(task.getTitle());
        if(taskOptional.isEmpty())
            throw new BadRequestException("No Task Found with Title : " + task.getTitle());
        if(Status.DONE.equals(taskOptional.get().getStatus()))
            throw new BadRequestException("Cannot update Done Task");

        return taskRepository.save(task);
    }
    public String deleteTask(String title) {
        if(!taskRepository.existsById(title))
            throw new BadRequestException(String.format("Task with title: %s is not exist", title));
        taskRepository.deleteById(title);
        return "Task deleted successfully";
    }
}
