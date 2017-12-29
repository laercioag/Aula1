package br.com.inforgeneses.aula01.listarprodutos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.inforgeneses.aula01.BaseActivity;
import br.com.inforgeneses.aula01.R;
import br.com.inforgeneses.aula01.cadastrarproduto.CadastrarProdutoActivity;
import br.com.inforgeneses.aula01.data.Produto;

public class ListarProdutosActivity extends BaseActivity implements ListarProdutosContract.View{

    private ListView lista;
    private Button btnNovo;

    private ListarProdutosContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.Lista);
        btnNovo = findViewById(R.id.BtnNovo);

        configuraBotaoCadastrar();

        presenter = new ListarProdutosPresenter();
    }

    @Override
    public void listarProdutos(List<Produto> produtos) {
        ArrayAdapter arrayAdapter = new ListarProdutosAdapter(
                ListarProdutosActivity.this,
                R.layout.adapter_lista_produto,
                produtos);
        lista.setAdapter(arrayAdapter);
    }

    public void configuraBotaoCadastrar() {
        btnNovo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(ListarProdutosActivity.this, CadastrarProdutoActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override
    protected void onStop() {
        presenter.detach();
        super.onStop();
    }
}
