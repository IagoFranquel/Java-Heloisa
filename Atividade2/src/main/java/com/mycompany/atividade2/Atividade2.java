package com.mycompany.atividade2;

import java.util.ArrayList;
import java.util.List;

// ============================================================
// TAREFAS 1-5 — Classes base de Aluno (mantidas do código anterior)
// ============================================================

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

class AlunoT2 {
    private String nome;
    private String matricula;
    private double nota;

    public AlunoT2(String nome, String matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
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
// TAREFA 9 — Interface que padroniza verificarAprovacao()
// ============================================================

interface Aprovavel {
    boolean verificarAprovacao();
}

// ============================================================
// TAREFA 5 + 9 — Classe Aluno base (implementa Aprovavel)
// ============================================================

class Aluno implements Aprovavel {

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

    public void ajustarNota(double novaNota) {
        setNota(novaNota);
    }

    // Tarefa 9: regra padrão na classe base (pode ser sobrescrita)
    @Override
    public boolean verificarAprovacao() {
        return nota >= 5;
    }

    public void exibirDados() {
        System.out.println("Nome.......: " + nome);
        System.out.println("Matrícula..: " + matricula);
        System.out.println("Nota Final.: " + nota);
        System.out.println("Situação...: " + (verificarAprovacao() ? "Aprovado" : "Reprovado"));
    }
}

// ============================================================
// TAREFA 4 + 9 — Subclasses com regras próprias de aprovação
// ============================================================

class AlunoGraduacao extends Aluno {

    public AlunoGraduacao(String nome, String matricula, double nota) {
        super(nome, matricula, nota);
    }

    // Tarefa 9: sobrescreve com regra específica (>= 7)
    @Override
    public boolean verificarAprovacao() { return getNota() >= 7; }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo.......: Graduação");
    }
}

class AlunoPosGraduacao extends Aluno {

    public AlunoPosGraduacao(String nome, String matricula, double nota) {
        super(nome, matricula, nota);
    }

    // Tarefa 9: sobrescreve com regra específica (>= 6)
    @Override
    public boolean verificarAprovacao() { return getNota() >= 6; }

    public void publicarArtigo() {
        System.out.println(getNome() + " publicou um artigo científico.");
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo.......: Pós-graduação");
    }
}

// ============================================================
// TAREFA 6 — Classe Professor com encapsulamento e validações
// ============================================================

class Professor {

    private String nome;
    private String matriculaFuncional;
    private double salario;

    public Professor(String nome, String matriculaFuncional, double salario) {
        this.nome               = (nome == null || nome.trim().isEmpty()) ? "Nome não informado" : nome;
        this.matriculaFuncional = (matriculaFuncional == null || matriculaFuncional.trim().isEmpty()) ? "Matrícula não informada" : matriculaFuncional;
        // Salário não pode ser negativo
        this.salario            = (salario >= 0) ? salario : 0.0;
    }

    public String getNome()               { return nome; }
    public String getMatriculaFuncional() { return matriculaFuncional; }
    public double getSalario()            { return salario; }

    // Somente valores positivos aumentam o salário
    public void aumentarSalario(double valor) {
        if (valor > 0) this.salario += valor;
    }

    public void exibirDados() {
        System.out.println("Nome.......: " + nome);
        System.out.println("Matrícula..: " + matriculaFuncional);
        System.out.println("Salário....: R$ " + String.format("%.2f", salario));
    }
}

// ============================================================
// TAREFA 7 — Herança: ProfessorEfetivo e ProfessorTemporario
// ============================================================

class ProfessorEfetivo extends Professor {

    public ProfessorEfetivo(String nome, String matriculaFuncional, double salario) {
        super(nome, matriculaFuncional, salario);
    }

    // Pode receber aumento normalmente (herda aumentarSalario() sem restrição)

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo.......: Efetivo");
    }
}

class ProfessorTemporario extends Professor {

    private int duracaoContrato; // duração original em meses
    private int mesesRestantes;  // meses que ainda restam

    public ProfessorTemporario(String nome, String matriculaFuncional, double salario, int duracaoMeses) {
        super(nome, matriculaFuncional, salario);
        this.duracaoContrato = (duracaoMeses > 0) ? duracaoMeses : 0;
        this.mesesRestantes  = this.duracaoContrato;
    }

    public int getMesesRestantes() { return mesesRestantes; }

    public boolean contratoAtivo() { return mesesRestantes > 0; }

    // Avança o tempo — usado para simular fim de contrato
    public void passarMeses(int meses) {
        mesesRestantes = Math.max(0, mesesRestantes - meses);
    }

    // Tarefa 7: bloqueia aumento se contrato encerrado
    @Override
    public void aumentarSalario(double valor) {
        if (!contratoAtivo()) {
            System.out.println("Aumento negado: contrato encerrado para " + getNome());
            return;
        }
        super.aumentarSalario(valor);
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo.......: Temporário");
        System.out.println("Contrato...: " + (contratoAtivo() ? mesesRestantes + " mes(es) restantes" : "Encerrado"));
    }
}

// ============================================================
// TAREFA 8 — Classe Disciplina com lista encapsulada de alunos
// ============================================================

class Disciplina {

    private String nome;
    private Professor professor;
    private List<Aluno> alunos;

    // Professor é obrigatório no construtor
    public Disciplina(String nome, Professor professor) {
        this.nome      = (nome == null || nome.trim().isEmpty()) ? "Disciplina sem nome" : nome;
        this.professor = professor;
        this.alunos    = new ArrayList<>();
    }

    public String getNome()         { return nome; }
    public Professor getProfessor() { return professor; }

    // Tarefa 8: impede duplicatas na lista
    public void adicionarAluno(Aluno aluno) {
        if (aluno == null) return;
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                System.out.println("Aluno " + aluno.getNome() + " já está cadastrado nesta disciplina.");
                return;
            }
        }
        alunos.add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " adicionado com sucesso.");
    }

    // Tarefa 8: lista protegida — exibe sem expor a coleção interna
    public void listarAlunos() {
        System.out.println("Disciplina.: " + nome);
        System.out.println("Professor..: " + professor.getNome());
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("Alunos....:");
        for (Aluno a : alunos) {
            System.out.println("  - " + a.getNome() + " | " + a.getMatricula()
                    + " | Nota: " + a.getNota()
                    + " | " + (a.verificarAprovacao() ? "Aprovado" : "Reprovado"));
        }
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
        a1.ajustarNota(9.0);
        a1.ajustarNota(-1.0); // inválida → ignorada
        System.out.println("Nota após ajustes: " + a1.getNota()); // 9.0

        // ---- TAREFA 6 ----
        separador("Tarefa 6 — Professor");
        Professor prof = new Professor("Dr. Roberto", "PROF001", 5000.0);
        prof.exibirDados();
        prof.aumentarSalario(500.0);
        prof.aumentarSalario(-100.0); // inválido → ignorado
        System.out.println("Salário após aumento: R$ " + String.format("%.2f", prof.getSalario()));

        // ---- TAREFA 7 ----
        separador("Tarefa 7 — Professor Efetivo");
        ProfessorEfetivo pe = new ProfessorEfetivo("Dra. Carla", "PROF002", 7000.0);
        pe.aumentarSalario(1000.0);
        pe.exibirDados();

        separador("Tarefa 7 — Professor Temporário (contrato ativo)");
        ProfessorTemporario pt = new ProfessorTemporario("Prof. Lucas", "PROF003", 3000.0, 6);
        pt.aumentarSalario(300.0); // contrato ativo → aceita
        pt.exibirDados();

        separador("Tarefa 7 — Professor Temporário (contrato encerrado)");
        pt.passarMeses(6); // esgota o contrato
        pt.aumentarSalario(300.0); // contrato encerrado → bloqueado
        pt.exibirDados();

        // ---- TAREFA 8 ----
        separador("Tarefa 8 — Disciplina");
        AlunoGraduacao ag = new AlunoGraduacao("João Souza", "2024003", 6.5);
        AlunoPosGraduacao ap = new AlunoPosGraduacao("Ana Lima", "2024004", 8.0);
        Aluno a2 = new Aluno("Pedro Costa", "2024005", 4.5);

        Disciplina disc = new Disciplina("Programação Orientada a Objetos", pe);
        disc.adicionarAluno(ag);
        disc.adicionarAluno(ap);
        disc.adicionarAluno(a2);
        disc.adicionarAluno(ag); // duplicata → bloqueada
        System.out.println();
        disc.listarAlunos();

        // ---- TAREFA 9 ----
        separador("Tarefa 9 — Polimorfismo com verificarAprovacao()");
        Aprovavel[] alunos = {
            new Aluno("Genérico", "2024020", 4.9),
            new AlunoGraduacao("Grad. Reprovado", "2024021", 6.9),
            new AlunoGraduacao("Grad. Aprovado", "2024022", 7.0),
            new AlunoPosGraduacao("Pós Reprovado", "2024023", 5.9),
            new AlunoPosGraduacao("Pós Aprovado", "2024024", 6.0)
        };

        for (Aprovavel a : alunos) {
            Aluno al = (Aluno) a;
            System.out.println(al.getNome() + " (nota " + al.getNota() + "): "
                    + (a.verificarAprovacao() ? "Aprovado" : "Reprovado"));
        }
    }
}