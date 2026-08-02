package com.jhonatan.tarefas.database.model;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    PENDETE ("Pendente"),
    EM_ANDAMENTO ("Em Andamento"),
    CONCLUIDA ("Concluída"),
    CANCELADA ("Cancelada");

    private final String StatusDaTarefa;

    public String getStatusDaTarefa() {
        return StatusDaTarefa;
    }
}
