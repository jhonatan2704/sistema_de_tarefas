package com.jhonatan.tarefas.service;

import com.jhonatan.tarefas.database.model.Status;
import com.jhonatan.tarefas.database.model.TaskEntity;
import com.jhonatan.tarefas.database.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private List<TaskEntity> listaDeTarefas = new ArrayList<>();


    public void criarNovaTarefa(TaskEntity task) {
        taskRepository.save(task);
    }

    public List<TaskEntity> listarTarefas() {
        return taskRepository.findAll();
    }

    public List<TaskEntity> listarTarefasPorStatus(Status status) {
        return taskRepository.findAll().stream()
                .filter(t -> t.getStatus() == status)
                .toList();
    }

    public void atualizarTarefa(Long id, TaskEntity task) {
        TaskEntity tarefaExistente = taskRepository.findById((id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada com o ID: " + id));

        tarefaExistente.setTitulo(task.getTitulo());
        tarefaExistente.setDescricao(task.getDescricao());
        tarefaExistente.setStatus(task.getStatus());
        taskRepository.save(tarefaExistente);
    }

    public void atualizarValorTarefa(Long id, TaskEntity task) {
        List<TaskEntity> tarefas = listarTarefas();
        TaskEntity tarefasAtualizadas = tarefas.stream().filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
        if (task.getTitulo() != null) {
            tarefasAtualizadas.setTitulo(task.getTitulo());
        } else if (task.getDescricao() != null) {
            tarefasAtualizadas.setDescricao(task.getDescricao());
        } else if (task.getStatus() != null) {
            tarefasAtualizadas.setStatus(task.getStatus());
        } else {
            System.out.println("Nenhum valor foi registrado!");
        }

        taskRepository.save(tarefasAtualizadas);
    }

    public void deletarTarefa(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encotrada para exclusão!");
        }
        taskRepository.deleteById(id);
    }
}
