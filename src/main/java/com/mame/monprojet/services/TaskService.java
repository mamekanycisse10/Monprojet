package com.mame.monprojet.services;

import com.mame.monprojet.dtos.TaskDTO;
import java.util.List;

public interface TaskService {

    TaskDTO createTask(TaskDTO taskDTO);

    TaskDTO updateTask(Long id, TaskDTO taskDTO);

    void deleteTask(Long id);

    List<TaskDTO> getAllTasks();

    TaskDTO getTaskById(Long id);      // nécessaire pour edit

    TaskDTO markAsCompleted(Long id);
}