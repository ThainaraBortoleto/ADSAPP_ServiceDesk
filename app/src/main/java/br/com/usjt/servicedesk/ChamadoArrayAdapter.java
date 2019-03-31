package br.com.usjt.servicedesk;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChamadoArrayAdapter extends ArrayAdapter <Chamado> {

    public ChamadoArrayAdapter(Context context, List<Chamado> chamados){
        super(context, -1, chamados);
    }

    private class ViewHolder{
        public ImageView filaIconImageView;
        public TextView descricaoChamadoNaListaTextView;
        public TextView statusChamadoNaFilaTextView;
        public TextView dataAberturaChamadoNaFilaTextView;
        public TextView dataFechamentoChamadoNaFilaTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if(convertView == null){
            LayoutInflater inflater =
                    LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_de_lista, parent, false);
            vh = new ViewHolder();

            vh.filaIconImageView = convertView.findViewById(R.id.filaIconImageView);
            vh.descricaoChamadoNaListaTextView = convertView.findViewById(R.id.descricaoChamadoNaListaTextView);
            vh.statusChamadoNaFilaTextView = convertView.findViewById(R.id.statusChamadoNaFilaTextView);
            vh.dataAberturaChamadoNaFilaTextView = convertView.findViewById(R.id.dataAberturaChamadoNaFilaTextView);
            vh.dataFechamentoChamadoNaFilaTextView = convertView.findViewById(R.id.dataFechamentoChamadoNaFilaTextView);

            convertView.setTag(vh);
        }
        vh = (ViewHolder) convertView.getTag();

        Chamado chamadoDaVez = getItem(position);
//            inflar a view -> layoutInflator
        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View caixa = inflater.inflate(R.layout.item_de_lista, parent, false);

        vh.filaIconImageView.setImageResource(chamadoDaVez.getFila().getIconId());

        vh.descricaoChamadoNaListaTextView.setText(chamadoDaVez.getDescricao());

        vh.dataAberturaChamadoNaFilaTextView.setText(DateHelper.format(chamadoDaVez.getDataAbertura()));
        if(chamadoDaVez.getDataFechamento() != null){
            vh.dataFechamentoChamadoNaFilaTextView.setText(
                    DateHelper.format(chamadoDaVez.getDataFechamento())
            );
        }

        statusChamadoTextView.setText(chamadoDaVez.getStatus());
        return super.getView(position, convertView, parent);
    }
}
