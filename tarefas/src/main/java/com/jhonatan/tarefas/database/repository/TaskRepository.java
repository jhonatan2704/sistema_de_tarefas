package com.jhonatan.tarefas.database.repository;

import com.jhonatan.tarefas.database.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
