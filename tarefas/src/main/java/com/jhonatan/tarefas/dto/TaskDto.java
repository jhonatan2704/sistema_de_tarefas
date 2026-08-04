package com.jhonatan.tarefas.dto;

import com.jhonatan.tarefas.database.model.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto {
    @NotBlank(message = "O titulo da tarefa não pode estar vazio")
    private String titulo;
    private String descricao;
    private Status status;
}
