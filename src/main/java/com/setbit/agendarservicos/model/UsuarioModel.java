package com.setbit.agendarservicos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioModel {


    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "S_ACCOUNT", allocationSize = 1)
    @NonNull
    @Min(value = 1, message = "Number deve ser um valor positivo.")
    @Id
    @Column(name = "use_id")
    private Long id;
    private String nome;
    private String senha;
    private String email;
    private boolean status;


}
