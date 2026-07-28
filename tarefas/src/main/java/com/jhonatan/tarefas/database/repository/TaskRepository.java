package com.jhonatan.tarefas.database.repository;

import com.jhonatan.tarefas.database.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    boolean existsById(Long id);
    List<TaskEntity> findAllById(Long id);
    void deleteById(Long id);
}
