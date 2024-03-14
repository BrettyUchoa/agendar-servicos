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

public class ProfissionalModel {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profissional_sequence")
    @SequenceGenerator(name = "profissional_sequence", sequenceName = "S_ACCOUNT", allocationSize = 1)
    @NonNull
    @Min(value = 1, message = "Number deve ser um valor positivo.")
    private Long profissionalId;
    private String nome;
    private String email;
    private boolean status;

}






