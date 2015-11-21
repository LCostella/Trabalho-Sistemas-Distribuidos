package cosumidorrestandroid.extras.trabalho.distribuidos.sistemas.consumidorrestmobile;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button inserirBt;
    Button excluirBt;
    Button consultarBt;
    Button alterarBt;
    Button listarBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inserirBt  = (Button) findViewById(R.id.inserir);
        excluirBt  = (Button) findViewById(R.id.excluir);
        alterarBt  = (Button) findViewById(R.id.alterar);
        consultarBt  = (Button) findViewById(R.id.consultar);
        listarBt = (Button) findViewById(R.id.listar);

        inserirBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {     // Evento para o botão inserir
                Intent intent = new Intent();
                    intent.setClass(MainActivity.this,InserirContatoTela.class);
                startActivity(intent);
        }
        });



        excluirBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Evento para o botão excluir
                startActivity(new Intent(getBaseContext(), RemoverContatoTela.class));
                }
            });



       consultarBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Evento para o botão consultar

                startActivity(new Intent(getBaseContext(), ConsultarContatoTela.class));
            }
        });

    }



            @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
