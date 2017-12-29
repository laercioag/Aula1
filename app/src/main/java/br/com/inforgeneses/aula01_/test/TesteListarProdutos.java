package br.com.inforgeneses.aula01_.test;

import android.util.Log;

import java.util.List;

import br.com.inforgeneses.aula01_.modelo.Produto;

/**
 * Created by Desenvolvimento on 17/10/2017.
 */

public class TesteListarProdutos {

    public static void meuMain() {
        List<Produto> lista = Produto.listAll(Produto.class);

        for (Produto item : lista) {
            Log.i("Lista com log.i", item.toString());
        }
    }
}
