package br.com.usjt.servicedesk;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChamadoViewHolder extends RecyclerView.ViewHolder {
    public ImageView filaIconImageView;
    public TextView descricaoChamadoNaListView;
    public TextView statusChamadoNaListTextView;
    public TextView dataAberturaTextView;
    public TextView dataFechamentoTextView;

    public ChamadoViewHolder(View raiz){
        super(raiz);

        filaIconImageView = raiz.findViewById(R.id.filaIconImageView);
        descricaoChamadoNaListView = raiz.findViewById(R.id.descricaoChamadoNaListView);
        statusChamadoNaListTextView = raiz.findViewById(R.id.statusChamadoNaListTextView);
        dataAberturaTextView = raiz.findViewById(R.id.dataAberturaTextView);
        dataFechamentoTextView = raiz.findViewById(R.id.dataFechamentoTextView);
    }
}
