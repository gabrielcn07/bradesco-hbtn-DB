package com.techcamps.gestao.cursos.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Curso> cursos = new HashSet<>();

    public Professor() {}
    public Professor(String nome) { this.nome = nome; }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Set<Curso> getCursos() { return cursos; }
    public void addCurso(Curso c) {
        c.setProfessor(this);
        cursos.add(c);
    }
}
