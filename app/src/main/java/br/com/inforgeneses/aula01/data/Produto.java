package br.com.inforgeneses.aula01.data;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Produto extends SugarRecord implements Serializable, Parcelable {

    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("Descricao")
    @Expose
    private String descricao;
    @SerializedName("preco")
    @Expose
    private Double preco;
    public final static Parcelable.Creator<Produto> CREATOR = new Creator<Produto>() {

        @SuppressWarnings({"unchecked"})
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        public Produto[] newArray(int size) {
            return (new Produto[size]);
        }

    };
    private final static long serialVersionUID = -7666771969215594768L;

    private Produto(Parcel in) {
        this.nome = ((String) in.readValue((String.class.getClassLoader())));
        this.descricao = ((String) in.readValue((String.class.getClassLoader())));
        this.preco = ((Double) in.readValue((String.class.getClassLoader())));
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nome", nome).append("descricao", descricao).append("preco", preco).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(nome);
        dest.writeValue(descricao);
        dest.writeValue(preco);
    }

    public int describeContents() {
        return 0;
    }

}