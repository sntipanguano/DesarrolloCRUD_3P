package com.proyecto.amandarivera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.amandarivera.model.Task;
import com.proyecto.amandarivera.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task-list";
    }

    @GetMapping("/{id}")
    public String viewTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-details";
    }

    @GetMapping("/create")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "create-task";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/update/{id}")
    public String updateTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "update-task";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        task.setId(id);
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
    
    @GetMapping("/h2-console")
    public String h2Console() {
        return "forward:/h2-console";
    }
}
