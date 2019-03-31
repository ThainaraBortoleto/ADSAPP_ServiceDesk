package br.com.usjt.servicedesk;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ChamadoRecycleViewAdapter extends RecyclerView.Adapter <ChamadoViewHolder> {
    private List <Chamado> chamados ;

    public ChamadoRecycleViewAdapter(List<Chamado> chamados){
        this.chamados = chamados;
    }

    @NonNull
    @Override
    public ChamadoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //        o que acontece quando é vinculado - acessa os dados, Inflar a arvore empacotar e devolver.
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View raiz = inflater.inflate(R.layout.item_de_lista, viewGroup, false);
        return new ChamadoViewHolder(raiz);
    }

    @Override
    public void onBindViewHolder(@NonNull ChamadoViewHolder chamadoViewHolder, vh, int i) {
        Chamado chamado = chamados.get(i);
        vh.filaIconImageView.setImageResource(chamado.getFila().getIconId());
        vh.descricaoChamadoNaListTextView.setText(chamado.getDescricao());
        vh.status.setImageResource(chamado.getFila().getIconId());
        vh.filaIconImageView.setImageResource(chamado.getFila().getIconId());
    }
}
