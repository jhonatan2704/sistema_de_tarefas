package com.jhonatan.tarefas.service;

import com.jhonatan.tarefas.database.model.TaskEntity;
import com.jhonatan.tarefas.database.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;


    public void criarNovaTarefa(TaskEntity task) {
        taskRepository.save(task);
    }

    public List<TaskEntity> listarTarefas() {
        return taskRepository.findAll();
    }

    public void atualizarTarefa(Integer id, TaskEntity task) {
        List<TaskEntity> tarefas = listarTarefas();
        TaskEntity tarefasAtualizadas = tarefas.stream().filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
        tarefasAtualizadas.setTitulo(task.getTitulo());
        tarefasAtualizadas.setDescricao(task.getDescricao());
        tarefasAtualizadas.setStatus(task.getStatus());
        taskRepository.save(tarefasAtualizadas);
    }

    public void atualizarValorTarefa(Integer id, TaskEntity task) {
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

    public void deletarTarefa(Integer id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encotrada para exclusão!");
        }
        taskRepository.deleteById(id);
    }
}
