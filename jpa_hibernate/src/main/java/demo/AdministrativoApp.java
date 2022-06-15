package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {

        System.out.println("========= TESTANDO PRODUTOS =========");
        ProdutoModel produtoModel = new ProdutoModel();
        List<Produto> produtos = produtoModel.findAll();


        // 1) Criando um produto
        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);
        produtoModel.create(p1);

        p1 = new Produto();
        p1.setNome("Smartphone");
        p1.setPreco(2500.0);
        p1.setQuantidade(15);
        p1.setStatus(false);
        produtoModel.create(p1);

        produtos = produtoModel.findAll();
        System.out.println("List after create:");
        System.out.println(produtos);

        //2) Buscando todos os produtos na base de dados
        System.out.println("Quantity of products found : " + produtos.size());

        //3) Atualizando produto
        Produto p2 = new Produto();
        p2.setId(1);
        p2.setNome("TV Samsung 60\"");
        p2.setQuantidade(5);
        p2.setPreco(1900.00);
        p2.setStatus(false);
        produtoModel.update(p2);
        System.out.println("List after update:");
        produtos = produtoModel.findAll();
        System.out.println(produtos);

        //4) Delete
        Produto p3 = new Produto();
        p3.setId(1);
        produtoModel.delete(p3);

        System.out.println("List after delete:");
        produtos = produtoModel.findAll();
        System.out.println(produtos);

        //5) Find by Id
        Produto p4 = new Produto();
        p4.setId(1);

        Produto p5 = produtoModel.findById(p4);
        System.out.println("List after find By Id 1:");
        System.out.println(p5);

        p4.setId(2);

        p5 = produtoModel.findById(p4);
        System.out.println("List after find By Id 2:");
        System.out.println(p5);


        System.out.println("========= TESTANDO PESSOAS =========");
        PessoaModel pessoaModel = new PessoaModel();
        List<Pessoa> pessoas = pessoaModel.findAll();


        // 1) Criando uma pessoa
        Pessoa pe1 = new Pessoa();
        pe1.setNome("João");
        pe1.setCpf("12345");
        pe1.setDataNascimento(LocalDate.of(1994, 05, 21));
        pe1.setEmail("joao@teste.com");
        pessoaModel.create(pe1);

        pe1 = new Pessoa();
        pe1.setNome("Maria");
        pe1.setCpf("789456");
        pe1.setDataNascimento(LocalDate.of(1990, 07, 9));
        pe1.setEmail("maria@teste.com");
        pessoaModel.create(pe1);

        pessoas = pessoaModel.findAll();
        System.out.println("List after create:");
        System.out.println(pessoas);

        //2) Buscando todas as pessoas na base de dados
        System.out.println("Quantity of people found : " + pessoas.size());

        //3) Atualizando pessoa
        Pessoa pe2 = new Pessoa();
        pe2.setNome("Pedro");
        pe2.setCpf("00003");
        pe2.setDataNascimento(LocalDate.of(1999, 02, 14));
        pe2.setEmail("pedro@teste.com");

        pessoaModel.update(pe2);
        System.out.println("List after update:");
        pessoas = pessoaModel.findAll();
        System.out.println(pessoas);

        //4) Delete
        Pessoa pe3 = new Pessoa();
        pe3.setId(1);
        pessoaModel.delete(pe3);

        System.out.println("List after delete:");
        pessoas = pessoaModel.findAll();
        System.out.println(pessoas);

        //5) Find by Id
        Pessoa pe4 = new Pessoa();
        pe4.setId(1);

        Pessoa pe5 = pessoaModel.findById(pe4);
        System.out.println("List after find By Id 1:");
        System.out.println(pe5);

        pe4.setId(2);

        pe5 = pessoaModel.findById(pe4);
        System.out.println("List after find By Id 2:");
        System.out.println(pe5);

    }
}
