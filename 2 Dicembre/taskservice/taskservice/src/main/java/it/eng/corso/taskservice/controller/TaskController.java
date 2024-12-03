package it.eng.corso.taskservice.controller;
import it.eng.corso.taskservice.model.Task;
import it.eng.corso.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/api/v1/tasks")
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;


    @GetMapping("/")
    public List<Task> listTask(){
        return taskService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Task save(@RequestBody Task task){
        return taskService.save(task);
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task task){
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        taskService.delete(id);
    }


    @GetMapping("/getCompleted")
    public List<Task> getCompleted(@RequestParam Boolean completed){
        return taskService.getCompleted(completed);
    }

}
