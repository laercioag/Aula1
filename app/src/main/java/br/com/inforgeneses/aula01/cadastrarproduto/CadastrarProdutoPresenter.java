package br.com.inforgeneses.aula01.cadastrarproduto;

import android.util.Log;

import br.com.inforgeneses.aula01.data.Produto;

public class CadastrarProdutoPresenter implements CadastrarProdutoContract.Presenter {

    private CadastrarProdutoContract.View view;

    public CadastrarProdutoPresenter() {
        this.view = null;
    }

    @Override
    public void salvar(String descricao, String nome, Double preco) {
        try{
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setPreco(preco);

            produto.save();
            view.mostrarMensagem("Salvo com sucesso.");
        } catch (Exception e) {
            view.mostrarMensagem("Erro ao salvar.");
            Log.e(CadastrarProdutoPresenter.class.getSimpleName(), e.getMessage());
        }


    }

    @Override
    public void attach(CadastrarProdutoContract.View view) {
        this.view = view;
    }

    @Override
    public void detach() {
        view = null;
    }
}
