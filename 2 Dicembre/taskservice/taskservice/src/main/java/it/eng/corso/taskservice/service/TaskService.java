package it.eng.corso.taskservice.service;

import it.eng.corso.taskservice.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    Task save(Task task);

    List<Task> findAll();

    Task getTaskById(Long id);

    void delete(Long id);

    Task update(Long id, Task task);

    List<Task> getCompleted(Boolean bool);

    
}
