package com.techcamps.gestao.cursos.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate nascimento; // novo campo

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Endereco> enderecos = new HashSet<>();

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Telefone> telefones = new HashSet<>();

    @ManyToMany(mappedBy = "alunos")
    private Set<Curso> cursos = new HashSet<>();

    public Aluno() {}

    public Aluno(String nome, LocalDate nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getNascimento() { return nascimento; }
    public void setNascimento(LocalDate nascimento) { this.nascimento = nascimento; }

    public Set<Endereco> getEnderecos() { return enderecos; }
    public void addEndereco(Endereco e) {
        e.setAluno(this);
        enderecos.add(e);
    }

    public Set<Telefone> getTelefones() { return telefones; }
    public void addTelefone(Telefone t) {
        t.setAluno(this);
        telefones.add(t);
    }

    public Set<Curso> getCursos() { return cursos; }
    public void addCurso(Curso c) { cursos.add(c); }
}
