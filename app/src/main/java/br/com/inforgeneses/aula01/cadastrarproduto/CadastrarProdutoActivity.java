package br.com.inforgeneses.aula01.cadastrarproduto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.inforgeneses.aula01.BaseActivity;
import br.com.inforgeneses.aula01.R;
import br.com.inforgeneses.aula01.util.HelperActivity;

public class CadastrarProdutoActivity extends BaseActivity implements CadastrarProdutoContract
        .View {

    private EditText nome, descricao, preco;
    private Button salvar;

    private CadastrarProdutoContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_create);

        presenter = new CadastrarProdutoPresenter();

        nome = findViewById(R.id.Nome);
        descricao = findViewById(R.id.Descricao);
        preco = findViewById(R.id.Preco);
        salvar = findViewById(R.id.Salvar);

        configureBotaoSalvar();
    }

    @Override
    public void mostrarMensagem(String mensagem) {
        HelperActivity v = new HelperActivity();

        v.setMensagem(mensagem);
        v.setCont(Toast.LENGTH_SHORT);
        v.setContexto(CadastrarProdutoActivity.this);
        v.mensagem();
    }

    private void configureBotaoSalvar() {
        salvar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String stringNome = nome.getText().toString();
                String stringDescricao = descricao.getText().toString();
                Double stringPreco = Double.valueOf(preco.getText().toString());

                presenter.salvar(stringDescricao, stringNome, stringPreco);
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