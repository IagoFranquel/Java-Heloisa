package com.mycompany.atividade2;


// TAREFA 1 — Classe básica


class AlunoT1 {

    String nome;
    String matricula;
    double nota;

    public AlunoT1(String nome, String matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public void exibirDados() {
        System.out.println("Nome.......: " + nome);
        System.out.println("Matrícula..: " + matricula);
        System.out.println("Nota Final.: " + nota);
    }
}


// TAREFA 2 — Encapsulamento: atributos privados + setNota() + getNota()


class AlunoT2 {

    private String nome;
    private String matricula;
    private double nota;

    public AlunoT2(String nome, String matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public double getNota() { return nota; }

    // Aceita apenas notas entre 0 e 10
    public void setNota(double nota) {
        if (nota >= 0 && nota <= 10) this.nota = nota;
    }

    public String getNome()      { return nome; }
    public String getMatricula() { return matricula; }

    public void exibirDados() {
        System.out.println("Nome.......: " + nome);
        System.out.println("Matrícula..: " + matricula);
        System.out.println("Nota Final.: " + nota);
    }
}


// TAREFA 3 — Validação no construtor

class AlunoT3 {

    private String nome;
    private String matricula;
    private double nota;

    public AlunoT3(String nome, String matricula, double nota) {
        this.nome      = (nome == null || nome.trim().isEmpty()) ? "Nome não informado" : nome;
        this.matricula = (matricula == null || matricula.trim().isEmpty()) ? "Matrícula não informada" : matricula;
        this.nota      = (nota >= 0 && nota <= 10) ? nota : 0.0;
    }

    public double getNota()      { return nota; }
    public String getNome()      { return nome; }
    public String getMatricula() { return matricula; }

    public void setNota(double nota) {
        if (nota >= 0 && nota <= 10) this.nota = nota;
    }

    public void exibirDados() {
        System.out.println("Nome.......: " + nome);
        System.out.println("Matrícula..: " + matricula);
        System.out.println("Nota Final.: " + nota);
    }
}


// TAREFA 4 — Herança: AlunoGraduacao e AlunoPosGraduacao


class AlunoT4 {

    private String nome;
    private String matricula;
    private double nota;

    public AlunoT4(String nome, String matricula, double nota) {
        this.nome      = (nome == null || nome.trim().isEmpty()) ? "Nome não informado" : nome;
        this.matricula = (matricula == null || matricula.trim().isEmpty()) ? "Matrícula não informada" : matricula;
        this.nota      = (nota >= 0 && nota <= 10) ? nota : 0.0;
    }

    public double getNota()      { return nota; }
    public String getNome()      { return nome; }
    public String getMatricula() { return matricula; }

    public void setNota(double nota) {
        if (nota >= 0 && nota <= 10) this.nota = nota;
    }

    public void exibirDados() {
        System.out.println("Nome.......: " + nome);
        System.out.println("Matrícula..: " + matricula);
        System.out.println("Nota Final.: " + nota);
    }
}

class AlunoGraduacaoT4 extends AlunoT4 {

    public AlunoGraduacaoT4(String nome, String matricula, double nota) {
        super(nome, matricula, nota);
    }

    public boolean verificarAprovacao() { return getNota() >= 7; }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo.......: Graduação");
        System.out.println("Situação...: " + (verificarAprovacao() ? "Aprovado" : "Reprovado"));
    }
}

class AlunoPosGraduacaoT4 extends AlunoT4 {

    public AlunoPosGraduacaoT4(String nome, String matricula, double nota) {
        super(nome, matricula, nota);
    }

    public boolean verificarAprovacao() { return getNota() >= 6; }

    public void publicarArtigo() {
        System.out.println(getNome() + " publicou um artigo científico.");
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo.......: Pós-graduação");
        System.out.println("Situação...: " + (verificarAprovacao() ? "Aprovado" : "Reprovado"));
    }
}

// ============================================================
// TAREFA 5 — ajustarNota() reutilizando setNota() (versão final)
// ============================================================

class Aluno {

    private String nome;
    private String matricula;
    private double nota;

    public Aluno(String nome, String matricula, double nota) {
        this.nome      = (nome == null || nome.trim().isEmpty()) ? "Nome não informado" : nome;
        this.matricula = (matricula == null || matricula.trim().isEmpty()) ? "Matrícula não informada" : matricula;
        this.nota      = (nota >= 0 && nota <= 10) ? nota : 0.0;
    }

    public double getNota()      { return nota; }
    public String getNome()      { return nome; }
    public String getMatricula() { return matricula; }

    public void setNota(double nota) {
        if (nota >= 0 && nota <= 10) this.nota = nota;
    }

    // Tarefa 5: reutiliza setNota — validação em um único lugar
    public void ajustarNota(double novaNota) {
        setNota(novaNota);
    }

    public void exibirDados() {
        System.out.println("Nome.......: " + nome);
        System.out.println("Matrícula..: " + matricula);
        System.out.println("Nota Final.: " + nota);
    }
}

class AlunoGraduacao extends Aluno {

    public AlunoGraduacao(String nome, String matricula, double nota) {
        super(nome, matricula, nota);
    }

    public boolean verificarAprovacao() { return getNota() >= 7; }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo.......: Graduação");
        System.out.println("Situação...: " + (verificarAprovacao() ? "Aprovado" : "Reprovado"));
    }
}

class AlunoPosGraduacao extends Aluno {

    public AlunoPosGraduacao(String nome, String matricula, double nota) {
        super(nome, matricula, nota);
    }

    public boolean verificarAprovacao() { return getNota() >= 6; }

    public void publicarArtigo() {
        System.out.println(getNome() + " publicou um artigo científico.");
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo.......: Pós-graduação");
        System.out.println("Situação...: " + (verificarAprovacao() ? "Aprovado" : "Reprovado"));
    }
}

// ========================== MAIN ============================

public class Atividade2 {

    static void separador(String titulo) {
        System.out.println("\n===== " + titulo + " =====");
    }

    public static void main(String[] args) {

        // ---- TAREFA 1 ----
        separador("Tarefa 1 — Classe básica");
        AlunoT1 t1 = new AlunoT1("Carlos", "2024010", 7.0);
        t1.exibirDados();

        // ---- TAREFA 2 ----
        separador("Tarefa 2 — Encapsulamento");
        AlunoT2 t2 = new AlunoT2("Beatriz", "2024011", 5.0);
        t2.setNota(15.0); // inválida → ignorada
        t2.setNota(8.0);  // válida → aceita
        t2.exibirDados();

        // ---- TAREFA 3 ----
        separador("Tarefa 3 — Validação no construtor (dados inválidos)");
        AlunoT3 t3 = new AlunoT3("", "2024012", 11.0);
        t3.exibirDados();

        // ---- TAREFA 4 ----
        separador("Tarefa 4 — Graduação (nota 6.5, reprovado)");
        AlunoGraduacaoT4 ag4 = new AlunoGraduacaoT4("João Souza", "2024013", 6.5);
        ag4.exibirDados();

        separador("Tarefa 4 — Pós-graduação (nota 6.5, aprovado)");
        AlunoPosGraduacaoT4 ap4 = new AlunoPosGraduacaoT4("Ana Lima", "2024014", 6.5);
        ap4.exibirDados();
        ap4.publicarArtigo();

        // ---- TAREFA 5 ----
        separador("Tarefa 5 — Ajuste de nota");
        Aluno a1 = new Aluno("Maria Silva", "2024001", 8.5);
        a1.exibirDados();
        a1.ajustarNota(9.0);   // válida → aceita
        a1.ajustarNota(-1.0);  // inválida → ignorada
        System.out.println("Nota após ajustes: " + a1.getNota()); // 9.0

        separador("Tarefa 5 — Graduação final");
        AlunoGraduacao ag = new AlunoGraduacao("João Souza", "2024003", 6.5);
        ag.exibirDados();

        separador("Tarefa 5 — Pós-graduação final");
        AlunoPosGraduacao ap = new AlunoPosGraduacao("Ana Lima", "2024004", 6.5);
        ap.exibirDados();
        ap.publicarArtigo();
    }
}