package it.eng.corso.taskservice.service;

import it.eng.corso.taskservice.exception.NoDataFoundException;
import it.eng.corso.taskservice.model.Task;
import it.eng.corso.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task save(Task task){
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(NoDataFoundException::new);
    }

    @Override
    public void delete(Long id){
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Long id, Task task){
        Task taskToUpdate = taskRepository.findById(id).get();
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setCompleted(task.getCompleted());
        taskToUpdate.setTitle(task.getTitle());
        return taskRepository.save(taskToUpdate);
    }

    @Override
    public List<Task> getCompleted(Boolean bool){
        if (bool){
            return taskRepository.findByCompletedTrue();
        } else{
            return taskRepository.findByCompletedFalse();
        }
    }

}
