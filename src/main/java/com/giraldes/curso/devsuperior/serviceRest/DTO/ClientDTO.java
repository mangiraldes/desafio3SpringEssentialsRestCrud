package com.giraldes.curso.devsuperior.serviceRest.DTO;

import com.giraldes.curso.devsuperior.serviceRest.entities.Client;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    @Size(min=3,max=80,message="nome precisa ter entre 3 e 80 caracteres")
    @NotEmpty(message="campo requerido")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message="Data de nascimento não pode ser data futura")
    private LocalDate birthDate;
    private Integer children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer chindren) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = chindren;
    }
    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
    }



    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", income=" + income +
                ", birthDate=" + birthDate +
                ", chindren=" + children +
                '}';
    }
}
