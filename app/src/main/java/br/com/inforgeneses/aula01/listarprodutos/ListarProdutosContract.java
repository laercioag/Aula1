package br.com.inforgeneses.aula01.listarprodutos;

import java.util.List;

import br.com.inforgeneses.aula01.BasePresenter;
import br.com.inforgeneses.aula01.BaseView;
import br.com.inforgeneses.aula01.data.Produto;

public interface ListarProdutosContract {

    interface View extends BaseView {

       void listarProdutos(List<Produto> produtos);

       void navegarParaCadastro();

    }

    interface Presenter extends BasePresenter<View> {

        void carregarProdutos();

        void cadastrar();

    }
}
