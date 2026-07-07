package com.jhonatan.tarefas.database.model;

public enum Status {
    PENDETE ("Pendente", "A tarefa foi criada, mas ainda não foi iniciada."),
    EM_ANDAMENTO ("Em Andamento", "A tarefa está sendo executada no momento."),
    CONCLUIDA ("Concluída", "A tarefa foi finalizada com sucesso."),
    CANCELA ("Cancelada", "A tarefa foi descartada.");

    private final String descricaoAmigavel;
    private final String detalhe;


    Status(String descricaoAmigavel, String detalhe) {
        this.descricaoAmigavel = descricaoAmigavel;
        this.detalhe = detalhe;
    }

    public String getDescricaoAmigavel() {
        return descricaoAmigavel;
    }

    public String getDetalhe() {
        return detalhe;
    }
}
