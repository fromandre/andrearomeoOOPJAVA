package it.eng.corso.taskservice.repository;

import it.eng.corso.taskservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCompletedTrue();

    List<Task> findByCompletedFalse();

}

