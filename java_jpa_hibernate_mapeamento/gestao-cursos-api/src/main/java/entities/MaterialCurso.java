package com.techcamps.gestao.cursos.entities;

import javax.persistence.*;

@Entity
@Table(name = "material_curso")
public class MaterialCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String url;

    @OneToOne(mappedBy = "material", cascade = CascadeType.ALL)
    private Curso curso;

    public MaterialCurso() {}
    public MaterialCurso(String descricao, String url) { this.descricao = descricao; this.url = url; }

    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}
