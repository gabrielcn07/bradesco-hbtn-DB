package com.techcamps.gestao.cursos.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    private MaterialCurso material;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "curso_aluno",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private Set<Aluno> alunos = new HashSet<>();

    public Curso() {}
    public Curso(String nome) { this.nome = nome; }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public MaterialCurso getMaterial() { return material; }
    public void setMaterial(MaterialCurso material) {
        this.material = material;
        if (material != null) {
            material.setCurso(this);
        }
    }

    public Set<Aluno> getAlunos() { return alunos; }
    public void addAluno(Aluno a) {
        alunos.add(a);
        a.getCursos().add(this);
    }
}
