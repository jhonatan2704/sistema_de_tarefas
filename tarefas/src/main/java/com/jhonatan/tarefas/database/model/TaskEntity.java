package com.jhonatan.tarefas.database.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tarefas")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    @Column(length = 100, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Boolean status;
}
