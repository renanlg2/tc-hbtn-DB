package demo;

import entities.*;
import jdk.swing.interop.SwingInterOpUtils;
import models.AlunoModel;
import models.CursoModel;
import java.time.LocalDate;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {


        System.out.println("::::::..... CRIANDO ALUNOS");
        AlunoModel am = new AlunoModel();

        Aluno a1 = new Aluno();
        a1.setNomeCompleto("Renan Lima");
        a1.setNascimento(LocalDate.of(1994, 05, 21));
        a1.setEmail("renanlg@ciandt.com");
        a1.setMatricula("9494");

        Endereco e1 = new Endereco();
        e1.setLogradouro("Rua");
        e1.setEndereco("Jose da Silva");
        e1.setNumero("1");
        e1.setBairro("Centro");
        e1.setCidade("Amparo");
        e1.setEstado("SP");
        e1.setCep(137987);
        e1.setAluno(a1);


        Endereco e2 = new Endereco();
        e2.setLogradouro("Rua");
        e2.setEndereco("Maria Lima");
        e2.setNumero("2");
        e2.setBairro("São João");
        e2.setCidade("Amparo");
        e2.setEstado("SP");
        e2.setCep(1390001);
        e2.setAluno(a1);

        Telefone t1 = new Telefone();
        t1.setDdd("19");
        t1.setNumero("999998888");
        t1.setAluno(a1);

        Telefone t2 = new Telefone();
        t2.setDdd("19");
        t2.setNumero("998855221");
        t2.setAluno(a1);

        a1.addEndereco(e1);
        a1.addEndereco(e2);
        a1.addTelefone(t1);
        a1.addTelefone(t2);

        am.create(a1);

        Aluno a2 = new Aluno();
        a2.setNomeCompleto("Juliana Cristina");
        a2.setMatricula("456");
        a2.setNascimento(LocalDate.of(1996, 8, 12));
        a2.setEmail("juliana@ciandt.com");
        a2.setMatricula("1313");

        Endereco e3 = new Endereco();
        e3.setLogradouro("Rua");
        e3.setEndereco("Carlos Campos");
        e3.setNumero("654");
        e3.setBairro("Figueira");
        e3.setCidade("Amparo");
        e3.setEstado("SP");
        e3.setCep(1390789);
        e3.setAluno(a2);

        Endereco e4 = new Endereco();
        e4.setLogradouro("Rua");
        e4.setEndereco("13 de Mario");
        e4.setNumero("462");
        e4.setBairro("São Pedro");
        e4.setCidade("Amparo");
        e4.setEstado("SP");
        e4.setCep(1390321);
        e4.setAluno(a2);

        Telefone t3 = new Telefone();
        t3.setDdd("19");
        t3.setNumero("999897897");
        t3.setAluno(a2);

        Telefone t4 = new Telefone();
        t4.setDdd("19");
        t4.setNumero("994685885");
        t4.setAluno(a2);

        a2.addEndereco(e3);
        a2.addEndereco(e4);
        a2.addTelefone(t3);
        a2.addTelefone(t4);

        am.create(a2);

        System.out.println("::::::..... LISTANDO TODOS ALUNOS 1");
        List<Aluno> listaAlunos = am.findAll();
        System.out.println(listaAlunos);
        System.out.println("Quantidade de alunos: " + listaAlunos.size());
        /***************************************************************************************************************/

        System.out.println("::::::..... CRIANDO PROFESSOR");

        CursoModel cm = new CursoModel();

        System.out.println("::::::..... LISTANDO TODOS ALUNOS 2");
        listaAlunos = am.findAll();
        System.out.println(listaAlunos);
        System.out.println("Quantidade de alunos: " + listaAlunos.size());



        Professor p1 = new Professor();
        p1.setNomeCompleto("Antonio Zechinato");
        p1.setMatricula("333222");
        p1.setEmail("tunim@ciandt.com");

        Professor p2 = new Professor();
        p2.setNomeCompleto("Theo Borges");
        p2.setMatricula("788");
        p2.setEmail("theo@betfair.com");



        System.out.println("::::::..... CRIANDO CURSO");
        Curso c1 = new Curso();
        c1.setNome("Introdução JPA");
        c1.setSigla("IJ");
        c1.setProfessor(p1);

        Curso c2 = new Curso();
        c2.setNome("Trade Esportivo");
        c2.setSigla("TE");
        c2.setProfessor(p2);


        System.out.println("::::::..... CRIANDO MATERIAL");
        MaterialCurso mc1 = new MaterialCurso();
        mc1.setUrl("https://stackabuse.com/a-guide-to-jpa-with-hibernate-relationship-mapping/");
        mc1.setCurso(c1);

        MaterialCurso mc2 = new MaterialCurso();
        mc2.setUrl("https://theoborges.com");
        mc2.setCurso(c2);

        c1.setMaterialCurso(mc1);
        c2.setMaterialCurso(mc2);

        c1.addAluno(a1);
        c1.addAluno(a2);

        c2.addAluno(a1);

        cm.create(c1);
        cm.create(c2);

        Curso cursoTemp = null;

        System.out.println("::::::..... LISTANDO CURSOS");
        List<Curso> listaCursos = cm.findAll();
        System.out.println(listaCursos);

        System.out.println("::::::..... ATUALIZANDO CURSO");
        cursoTemp = new Curso();
        cursoTemp.setId(2L);
        Curso c3 = cm.findCursoById(cursoTemp);
        c3.setNome("Curso alterado");
        cm.update(c3);

        System.out.println("::::::..... LISTANDO CURSOS APOS ATUALIZAR");
        listaCursos = cm.findAll();
        System.out.println(listaCursos);

        System.out.println("::::::..... APAGANDO CURSO");
        cm.delete(cursoTemp);
        listaCursos = cm.findAll();

        System.out.println("::::::..... LISTA CURSO APOS DELETE");
        System.out.println(listaCursos);



    }
}

