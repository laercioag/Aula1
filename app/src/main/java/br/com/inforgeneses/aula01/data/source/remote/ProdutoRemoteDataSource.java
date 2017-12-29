package br.com.inforgeneses.aula01.data.source.remote;

import java.util.List;

import br.com.inforgeneses.aula01.data.Produto;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class ProdutoRemoteDataSource {

    private static final String BASE_URL = "http://demo2731446.mockable.io/";

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static ProdutosService service = null;

    public static ProdutosService getInstance() {
        if (service == null) {
            service = retrofit.create(ProdutosService.class);
        }

        return service;
    }

    public interface ProdutosService {

        @GET("produtos")
        Call<List<Produto>> listaProdutos();

        @POST("cadastrar")
        Call<Void> cadastrarProduto(@Body Produto produto);

    }
}
