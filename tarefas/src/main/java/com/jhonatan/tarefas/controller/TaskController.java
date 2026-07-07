package com.jhonatan.tarefas.controller;

import com.jhonatan.tarefas.database.model.TaskEntity;
import com.jhonatan.tarefas.database.repository.TaskRepository;
import com.jhonatan.tarefas.service.TaskService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskEntity> findAll() {
        return taskService.listarTarefas();
    }

    @PostMapping("/adicionar")
    public ResponseEntity<TaskEntity> novaTarefa(@RequestBody TaskEntity task) {
        taskService.criarNovaTarefa(task);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/atualizarLista/{id}")
    public ResponseEntity<TaskEntity> atualizarTarefa(@PathVariable Integer id,
            @RequestBody TaskEntity task) {
        taskService.atualizarTarefa(id, task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PatchMapping("/atualizarValor/{id}")
    public ResponseEntity<TaskEntity> atualizarValor(@PathVariable Integer id,
            @RequestBody TaskEntity task) {
        taskService.atualizarValorTarefa(id, task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletarTarefa/{id}")
    public ResponseEntity<TaskEntity> deletarTarefa(@PathVariable Integer id) {
        taskService.deletarTarefa(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
