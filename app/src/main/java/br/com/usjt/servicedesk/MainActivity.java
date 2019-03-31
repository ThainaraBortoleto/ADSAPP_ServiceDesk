package br.com.usjt.servicedesk;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends Activity {
    private EditText txtNome;
    public static final String NOME = "br.usjt.deswebmob.servicedesk.nome";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);
        chamadosListView = findViewById(R.id.chamadosListView);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        final List <Chamado> chamados = busca(nomeFila);
        ChamadoArrayAdapter adapter =
                new ChamadoArrayAdapter(this, chamados);
        chamadosListView.setAdapter(adapter);
        chamadosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long
                    id) {
                Chamado chamadoSelecionado = chamados.get(position);
                //Toast.makeText(ListaChamadosActivity.this, chamadoSelecionado,
                Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (ListaChamadosActivity.this,
                        DetalhesChamadoActivity.class);
                intent.putExtra("chamado_selecionado", chamadoSelecionado);
                startActivity(intent);
            }
        });
    }

    public void buscarChamados(View view){
        Intent intent = new Intent(this, ListarChamadosActivity.class);
        String nome = txtNome.getText().toString();
        intent.putExtra(NOME, nome);
        startActivity(intent);
    }
}
