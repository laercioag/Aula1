package br.com.inforgeneses.aula01;

public interface BasePresenter<V> {

    void attach(V view);

    void detach();
}
