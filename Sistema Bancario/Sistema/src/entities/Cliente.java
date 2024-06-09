package entities;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
    private String name;
    private String cpf;
    private LocalDate dataNascimento;

    public Cliente(String name, String cpf, LocalDate dataNascimento){
        this.name = name;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return name;
    }

    public String getCpf(){
        return cpf;
    }

    public int getIdade(){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}
