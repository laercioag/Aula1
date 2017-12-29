package br.com.inforgeneses.aula01_.listar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.inforgeneses.aula01_.R;
import br.com.inforgeneses.aula01_.custom.ProdutoCustom;
import br.com.inforgeneses.aula01_.form.ProdutoCreate;
import br.com.inforgeneses.aula01_.helper.CustomDeserializer;
import br.com.inforgeneses.aula01_.modelo.InforgenesesEliService;
import br.com.inforgeneses.aula01_.modelo.Produto;
import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private Button btnNovo;
    private InforgenesesEliService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregaForm();

        btnNovo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProdutoCreate.class));
            }
        });

        String jsonString = "{\"status\":1,\"itens\":[{\"nome\":\"martelo\",\"descricao\":\"descricao\",\"preco\":\"50.00\"},{\"nome\":\"teco teco\",\"descricao\":\"brinquedo\",\"preco\":\"10.00\"}]}";


        Gson gson = new GsonBuilder()
                        .registerTypeAdapter(Produto.class, new CustomDeserializer<Produto>())
                        .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo2731446.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(InforgenesesEliService.class);

        populaLista();
    }

    private void populaLista() {
        executaProdutos();
    }

    private void carregaForm() {
        lista = findViewById(R.id.Lista);
        btnNovo = findViewById(R.id.BtnNovo);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void executaProdutos() {
        Call<List<Produto>> call = service.listaProdutos();
        call.enqueue(new Callback<List<Produto>>() {
            @Override
            public void onResponse(@NonNull Call<List<Produto>> call, @NonNull Response<List<Produto>> response) {
                List<Produto> produtos = response.body();
                ArrayAdapter arrayAdapter = new ProdutoCustom(
                        MainActivity.this,
                        R.layout.adapter_lista_produto,
                        produtos);
                lista.setAdapter(arrayAdapter);

                Log.e(MainActivity.class.getSimpleName(), "Número de produtos recebidos: " + produtos.size());
            }

            @Override
            public void onFailure(@NonNull Call<List<Produto>> call, @NonNull Throwable t) {
                Log.e(MainActivity.class.getSimpleName(), t.toString());
            }
        });
    }


//    public void executaProdutos() {
//        RequestParams params = new RequestParams();
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.post("http://eli.inforgeneses.inf.br/retornoItens.php", params, new AsyncHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
//                //Log.i("debug", new String(response));
//                // called when response HTTP status is "200 OK"
//
//                try {
//                    JSONObject dadosRetorno = new JSONObject(new String(response));
//
//                    if (dadosRetorno.get("status").equals(1)) {
//                        //JSONArray itens = (JSONArray) dadosRetorno.get("itens");
//                        JSONArray itens = dadosRetorno.getJSONArray("itens");
//                        ArrayList<Produto> listaBanco = new ArrayList<>();
//
//                        for (int i = 0; i < itens.length(); i++) {
//                            //listaBanco.add(new Produto((JSONObject) itens.get(i)));
//                            listaBanco.add(new Produto(itens.getJSONObject(i)));
//                            ArrayAdapter arrayAdapter = new ProdutoCustom(MainActivity.this, R.layout.adapter_lista_produto, listaBanco);
//                            lista.setAdapter(arrayAdapter);
//                        }
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
//                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
//                Log.i("debug", String.valueOf(e));
//            }
//
//        });
//    }
}
