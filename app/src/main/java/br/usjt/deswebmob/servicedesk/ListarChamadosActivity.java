package br.usjt.deswebmob.servicedesk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListarChamadosActivity extends Activity {
    public static final String DESCRICAO = "br.usjt.deswebmob.servicedesk.descricao";
    ArrayList<String> lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_listar_chamados);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.NOME);
        lista = buscaChamados(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                manda pra tela de detalhe
                Intent intent = new Intent(atividade, DetalheChamadoActivity.class);
                intent.putExtra(DESCRICAO, lista.get(position));

                startActivity(intent);
            }
        });
    }

    public ArrayList<String> buscaChamados(String chave){
        ArrayList<String> lista = geraListaChamados();
        if(chave == null || chave.length() == 0){
            return lista;
        }else{
            ArrayList<String subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

    public ArrayList<String> geraListaChamados(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Desktops: Computador da secretária quebrado");
        lista.add("Telefonia: telefone não funciona");
        lista.add("Rede: Manutenção de proxy");
        lista.add("Servidores: Lentidão generalizada");
        lista.add("Novo Projetos: CRM");
        lista.add("Manutenção Sistema ERP: atualizar versão");
        lista.add("Novos Projetos: ferramenta EMM");
        return lista;
    }
}
