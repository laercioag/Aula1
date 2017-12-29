package br.com.inforgeneses.aula01_.test;

import br.com.inforgeneses.aula01_.modelo.Produto;

/**
 * Created by Desenvolvimento on 10/10/2017.
 */

public class TesteCadastroProduto {

    public static void meuMain() {
        Produto produto = new Produto();
        produto.setNome("hd Kingston");
        produto.setDescricao("ssd");
        produto.setPreco(500.00);

        produto.save();

        System.out.println("toString" + produto);
    }
}
