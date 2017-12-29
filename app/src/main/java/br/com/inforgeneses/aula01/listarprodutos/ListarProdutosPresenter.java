package br.com.inforgeneses.aula01.listarprodutos;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.inforgeneses.aula01.data.Produto;
import br.com.inforgeneses.aula01.data.source.remote.ProdutoRemoteDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarProdutosPresenter implements ListarProdutosContract.Presenter {

    private List<Produto> produtos;

    private ListarProdutosContract.View view;

    ListarProdutosPresenter() {
        produtos = new ArrayList<>();
        view = null;
    }

    @Override
    public void attach(ListarProdutosContract.View view) {
        this.view = view;
        carregarProdutos();
    }

    @Override
    public void detach() {
        view = null;
    }

    @Override
    public void carregarProdutos() {
        ProdutoRemoteDataSource.ProdutosService service = ProdutoRemoteDataSource.getInstance();

        Call<List<Produto>> call = service.listaProdutos();
        call.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(@NonNull Call<List<Produto>> call, @NonNull Response<List<Produto>> response) {
                produtos = response.body();
                view.listarProdutos(produtos);
                Log.d(ListarProdutosActivity.class.getSimpleName(), "Número de produtos recebidos: " + produtos.size());
            }

            @Override
            public void onFailure(@NonNull Call<List<Produto>> call, @NonNull Throwable t) {
                Log.e(ListarProdutosActivity.class.getSimpleName(), t.toString());
            }
        });
    }
}
