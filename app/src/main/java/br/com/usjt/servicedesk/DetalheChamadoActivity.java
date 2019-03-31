package br.com.usjt.servicedesk;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class DetalheChamadoActivity extends AppCompatActivity {
    private TextView nomeFilaTextView, descricaoChamadoTextView;
    public class DetalhesChamadoActivity extends AppCompatActivity {
        private TextView nomeFilaTextView, descricaoChamadoTextView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detalhes_chamado);
            Intent origemIntent = getIntent();
            Chamado chamadoSelecionado =
                    (Chamado)
                            origemIntent.getSerializableExtra("chamado_selecionado");
            ImageView filaIconImageView =
                    findViewById(R.id.filaIconImageView);
            TextView descricaoChamadoNaFilaTextView =
                    findViewById(R.id.descricaoChamadoNaFilaTextView);
            TextView statusChamadoNaFilaTextView =
                    findViewById(R.id.statusChamadoNaFilaTextView);
            TextView dataAberturaChamadoNaFilaTextView =

                    findViewById(R.id.dataAberturaChamadoNaFilaTextView);
            TextView dataFechamentoChamadoNaFilaTextView =

                    findViewById(R.id.dataFechamentoChamadoNaFilaTextView);

            filaIconImageView.setImageResource(chamadoSelecionado.getFila().getI
                    conId());

            descricaoChamadoNaFilaTextView.setText(chamadoSelecionado.getDescric
                    ao());

            statusChamadoNaFilaTextView.setText(chamadoSelecionado.getStatus());
            dataAberturaChamadoNaFilaTextView.setText(

                    DateHelper.format(chamadoSelecionado.getDataAbertura()));
            if (chamadoSelecionado.getDataFechamento() != null){
                dataFechamentoChamadoNaFilaTextView.setText(

                        DateHelper.format(chamadoSelecionado.getDataFechamento()));
            }
        }
    }

    @Override
    public View getView(int position,View convertView, ViewGroup
            parent) {
        Chamado chamadoDaVez = getItem(position);
        Fila filaDaVez = chamadoDaVez.getFila();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_item, parent,
                    false);
        }
        ImageView filaIconImageView =
                convertView.findViewById(R.id.filaIconImageView);
        TextView descricaoChamadoNaFilaTextView =

                convertView.findViewById(R.id.descricaoChamadoNaFilaTextView);
        TextView statusChamadoNaFilaTextView =

                convertView.findViewById(R.id.statusChamadoNaFilaTextView);
        TextView dataAberturaChamadoNaFilaTextView =

                convertView.findViewById(R.id.dataAberturaChamadoNaFilaTextView);
        TextView dataFechamentoChamadoNaFilaTextView =

                convertView.findViewById(R.id.dataFechamentoChamadoNaFilaTextView);
        filaIconImageView.setImageResource(filaDaVez.getIconId());

        descricaoChamadoNaFilaTextView.setText(chamadoDaVez.getDescricao());
        statusChamadoNaFilaTextView.setText(chamadoDaVez.getStatus());

        dataAberturaChamadoNaFilaTextView.setText(DateHelper.format(chamadoD
                aVez.getDataAbertura()));
        if (chamadoDaVez.getDataFechamento() != null){

            dataFechamentoChamadoNaFilaTextView.setText(DateHelper.format(chamad
                    oDaVez.getDataFechamento()));
        }
        return convertView;
    }
}
