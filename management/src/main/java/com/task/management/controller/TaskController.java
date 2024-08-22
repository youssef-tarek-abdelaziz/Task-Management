package com.task.management.controller;

import com.task.management.domain.Task;
import com.task.management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/all")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/{title}")
    public Task getTasks(@PathVariable String title) {
        return taskService.getTaskByTitle(title);
    }
    @PostMapping("")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }
    @PutMapping("")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }
    @DeleteMapping("/{title}")
    public String deleteTask(@PathVariable String title) {
        return taskService.deleteTask(title);
    }
}
