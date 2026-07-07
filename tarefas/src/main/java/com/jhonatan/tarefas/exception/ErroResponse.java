package com.jhonatan.tarefas.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ErroResponse {
    private String mensagem;
    private Integer status;
}
