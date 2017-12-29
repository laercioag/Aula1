package br.com.inforgeneses.aula01.cadastrarproduto;

import br.com.inforgeneses.aula01.BasePresenter;
import br.com.inforgeneses.aula01.BaseView;

public class CadastrarProdutoContract {

    public interface View extends BaseView {

        void mostrarMensagem(String mensagem);

    }

    public interface Presenter extends BasePresenter<View> {

        void salvar(String descricao, String nome, Double preco);

    }
}
