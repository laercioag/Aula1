package br.com.inforgeneses.aula01.listarprodutos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.inforgeneses.aula01.R;
import br.com.inforgeneses.aula01.data.Produto;

public class ListarProdutosAdapter extends ArrayAdapter{

    private final int layout;
    private LayoutInflater inflater;

    public ListarProdutosAdapter(Context contexto, int layout, List<Produto> lista) {
        super(contexto, layout, lista);
        this.inflater = LayoutInflater.from(contexto);
        this.layout = layout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = this.inflater.inflate(layout, parent, false);

        TextView nome = (TextView) convertView.findViewById(R.id.TxtNome);
        TextView descricao= (TextView) convertView.findViewById(R.id.TxtDescricao);
        TextView preco = (TextView) convertView.findViewById(R.id.TxtPreco);

        Produto produto = (Produto) getItem(position);

        nome.setText(produto.getNome());
        descricao.setText(produto.getDescricao());
        preco.setText(String.valueOf(produto.getPreco()));

        return convertView;

    }
}
