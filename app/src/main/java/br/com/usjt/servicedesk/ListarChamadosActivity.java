package br.com.usjt.servicedesk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListarChamadosActivity extends Activity {
    public static final String DESCRICAO =
            "br.usjt.deswebmob.servicedesk.descricao";
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        ListView chamadosListView = findViewById(R.id.listview);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        final List <Chamado> chamados = buscaChamados(nomeFila);
//        ChamadoArrayAdapter adapter =
//                new ChamadoArrayAdapter(this, simple_list_item_1 chamados);
        chamadosListView.setAdapter(adapter);
        chamadosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long
                    id) {
                Chamado chamadoSelecionado = chamados.get(position);
                Intent intent = new Intent (ListarChamadosActivity.this,
                        DetalheChamadoActivity.class);
                intent.putExtra("chamado_selecionado", chamadoSelecionado);
                startActivity(intent);
            }
        });
    }
    public List<Chamado> buscaChamados(String chave){
        List<Chamado> chamados = geraListaChamados();
        if (chave == null || chave.length() == 0){
            return chamados;
        } else {
            List<Chamado> resultado = new ArrayList<>();
            for(Chamado chamado:chamados){
                if(chamado.getFila().getNome().toUpperCase().contains(chave.toUpperCase())){
                    resultado.add(chamado);
                }
            }
            return resultado;
        }
    }
    public List<Chamado> geraListaChamados(){
        List<Chamado> chamados = new ArrayList<>();
        chamados.add(new Chamado (
                new Fila ("Desktops", R.drawable.ic_computer_black_24dp),
                "Computador da secretária quebrado.",
                new Date(),
                null,
                "Aberto"
        ));
        chamados.add(new Chamado (
                new Fila ("Telefonia",
                        R.drawable.ic_phone_in_talk_black_24dp),
                "Telefone não funciona.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable.ic_network_check_black_24dp),
                "Manutenção no proxy.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Servidores", R.drawable.ic_poll_black_24dp),
                "Lentidão generalizada.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "CRM",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "Gestão de Orçamento",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable.ic_network_check_black_24dp),
                "Internet com lentidão",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (new Fila ("Novos Projetos",
                R.drawable.ic_new_releases_black_24dp),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        return chamados;
    }
}
