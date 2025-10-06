package com.techcamps.gestao.cursos.entities;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String cidade;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Endereco() {}

    public Endereco(String rua, String cidade, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Long getId() { return id; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
}
