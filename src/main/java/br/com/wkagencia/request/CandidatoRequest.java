package br.com.wkagencia.request;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoRequest {
    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String cpf;
    @NotEmpty
    private String rg;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotEmpty
    private LocalDate dataNasc;
    @NotEmpty
    private String sexo;
    @NotEmpty
    private String mae;
    @NotEmpty
    private String pai;
    @NotEmpty
    private String email;
    @NotEmpty
    private String cep;
    @NotEmpty
    private String endereco;
    @NotEmpty
    private Long numero;
    @NotEmpty
    private String bairro;
    @NotEmpty
    private String cidade;
    @NotEmpty
    private String estado;
    @NotEmpty
    private String telefoneFixo;
    @NotEmpty
    private String celular;
    @NotEmpty
    private Double altura;
    @NotEmpty
    private Double peso;
    @NotEmpty
    private String tipoSanguineo;
}
