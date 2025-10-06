-- SQL schema for database_admin_jpa.db (example)
CREATE TABLE alunos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT
);
CREATE TABLE enderecos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    rua TEXT,
    cidade TEXT,
    cep TEXT,
    aluno_id INTEGER
);
CREATE TABLE telefones (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    numero TEXT,
    aluno_id INTEGER
);
CREATE TABLE professores (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT
);
CREATE TABLE material_curso (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    descricao TEXT,
    url TEXT
);
CREATE TABLE cursos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT,
    professor_id INTEGER,
    material_id INTEGER
);
CREATE TABLE curso_aluno (
    curso_id INTEGER,
    aluno_id INTEGER
);
