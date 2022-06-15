package entities;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private Integer idade;
    private String cpf;
    private LocalDate dataNascimento;

    public Pessoa(Integer id, String nome, String email, Integer idade, String cpf, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        this.idade = Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}' + "\n";
    }
}
