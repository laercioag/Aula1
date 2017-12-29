package br.com.inforgeneses.aula01.cadastrarproduto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.inforgeneses.aula01.R;
import br.com.inforgeneses.aula01.util.HelperActivity;
import br.com.inforgeneses.aula01.data.Produto;

public class CadastrarProdutoActivity extends AppCompatActivity {

    private EditText nome, descricao, preco;
    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_create);

        carregaForm();

        salvar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                salvar();
            }
        });
    }

    private void salvar(){

        HelperActivity v = new HelperActivity();

        try{

            Produto produto = new Produto();

            produto.setNome(nome.getText().toString());
            produto.setDescricao(descricao.getText().toString());
            produto.setPreco(Double.valueOf(preco.getText().toString()));

            produto.save();

            v.setMensagem("Salvo com sucesso");
            v.setCont(Toast.LENGTH_SHORT);
            v.setContexto(CadastrarProdutoActivity.this);
            v.mensagem();
            //Toast.makeText(CadastrarProdutoActivity.this, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
            finish();

        }catch (Exception e){
            Toast.makeText(CadastrarProdutoActivity.this, "Ocorreu um problema ao salvar", Toast.LENGTH_SHORT).show();
        }
    }

    private void carregaForm() {
        nome = (EditText) findViewById(R.id.Nome);
        descricao = (EditText) findViewById(R.id.Descricao);
        preco = (EditText) findViewById(R.id.Preco);
        salvar = (Button) findViewById(R.id.Salvar);
    }
}