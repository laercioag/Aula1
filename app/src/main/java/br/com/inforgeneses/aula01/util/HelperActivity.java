package br.com.inforgeneses.aula01.util;

import android.content.Context;
import android.widget.Toast;


public class HelperActivity {
    private Context contexto;
    private String mensagem;
    private int cont;

    public void mensagem(){
        Toast.makeText(this.contexto, this.mensagem, this.cont).show();
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
}
