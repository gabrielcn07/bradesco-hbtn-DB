package com.techcamps.gestao.cursos.demo;

import com.techcamps.gestao.cursos.entities.*;
import com.techcamps.gestao.cursos.models.*;

public class GestaoCursosMain {
    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        // Criando aluno com endereco e telefone
        Aluno aluno = new Aluno("Joao Silva");
        aluno.addEndereco(new Endereco("Rua A, 123", "CidadeX", "00000-000"));
        aluno.addTelefone(new Telefone("+5511999999999"));

        alunoModel.create(aluno);

        // Professor
        Professor prof = new Professor("Prof. Maria");

        // Material do curso
        MaterialCurso mat = new MaterialCurso("Material introdutorio", "http://material.example.com");

        // Curso com professor e aluno
        Curso curso = new Curso("Java Basico");
        curso.setProfessor(prof);
        curso.setMaterial(mat);
        curso.addAluno(aluno);

        cursoModel.create(curso);

        System.out.println("Dados salvos com sucesso. IDs: Aluno=" + aluno.getId() + ", Curso=" + curso.getId());
    }
}
