package br.com.inforgeneses.aula01_.modelo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InforgenesesEliService {

    @GET("produtos")
    Call<List<Produto>> listaProdutos();
}
