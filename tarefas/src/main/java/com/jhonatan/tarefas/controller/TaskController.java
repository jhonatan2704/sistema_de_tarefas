package com.jhonatan.tarefas.controller;

import com.jhonatan.tarefas.database.model.Status;
import com.jhonatan.tarefas.database.model.TaskEntity;
import com.jhonatan.tarefas.dto.TaskDto;
import com.jhonatan.tarefas.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Lista todas as tarefas")
    public List<TaskEntity> findAll() {
        return taskService.listarTarefas();
    }

    @GetMapping("/busca/{status}")
    @Operation(summary = "Lista tarefas por status")
    public List<TaskEntity> findByStatus(@PathVariable Status status) {
        return taskService.listarTarefasPorStatus(status);
    }

    @PostMapping("/adicionar")
    @Operation(summary = "Adiciona nova tarefa")
    public ResponseEntity<TaskDto> novaTarefa(@RequestBody TaskDto task) {
        taskService.criarNovaTarefa(task);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/atualizarLista/{id}")
    @Operation(summary = "Atualiza tarefa")
    public ResponseEntity<TaskDto> atualizarTarefa(@PathVariable Long id,
                                                   @RequestBody TaskDto task) {
        taskService.atualizarTarefa(id, task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PatchMapping("/atualizarValor/{id}")
    @Operation(summary = "Atualiza um campo da tarefa")
    public ResponseEntity<TaskDto> atualizarValor(@PathVariable Long id,
            @RequestBody TaskDto task) {
        taskService.atualizarValorTarefa(id, task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletarTarefa/{id}")
    @Operation(summary = "Deleta tarefa")
    public ResponseEntity<TaskEntity> deletarTarefa(@PathVariable Long id) {
        taskService.deletarTarefa(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
