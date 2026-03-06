package com.mame.monprojet.controllers;

import com.mame.monprojet.dtos.TaskDTO;
import com.mame.monprojet.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // Afficher la liste des tâches
    @GetMapping
    public String index(Model model) {
        List<TaskDTO> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    // Ajouter une tâche
    @PostMapping("/add")
    public String add(@ModelAttribute TaskDTO taskDTO) {
        taskDTO.setStatus("En cours"); // statut par défaut
        taskService.createTask(taskDTO);
        return "redirect:/api/tasks";
    }

    // Marquer comme terminée
    @PostMapping("/complete/{id}")
    public String complete(@PathVariable Long id) {
        taskService.markAsCompleted(id);
        return "redirect:/api/tasks";
    }

    // Supprimer une tâche
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/api/tasks";
    }

    // Afficher le formulaire Edit
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        TaskDTO task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "edit"; // edit.html
    }

    // Mettre à jour la tâche
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, @ModelAttribute TaskDTO taskDTO) {
        taskService.updateTask(id, taskDTO);
        return "redirect:/api/tasks";
    }
}