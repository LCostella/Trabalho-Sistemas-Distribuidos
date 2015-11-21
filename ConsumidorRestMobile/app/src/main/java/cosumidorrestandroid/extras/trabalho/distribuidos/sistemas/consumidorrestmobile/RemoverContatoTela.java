package cosumidorrestandroid.extras.trabalho.distribuidos.sistemas.consumidorrestmobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao.BuscarContato;


public class RemoverContatoTela extends ActionBarActivity {
    EditText codigo;
    Button removerBt;
    Button  cancelarBt;
    String getCodigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_contato);
        codigo = (EditText) findViewById(R.id.codigo);
    }
    public void eventoRemover(View v) {
        String URLBuscar = "http://10.0.2.2:8080/ServicoREST/webresources/Rest/buscarContatoMobile/";
        String resultado = " ";
        String URL= "http://10.0.2.2:8080/ServicoREST/webresources/Rest/excluirContatoMobile/";
        getCodigo = codigo.getText().toString();

        distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao.BuscarContato bc = new distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao.BuscarContato();
        String respostaBuscar = bc.chamadaGet(URLBuscar + getCodigo);

        if(respostaBuscar != null) {
            distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao.RemoverContato ar = new distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao.RemoverContato();
            resultado = ar.chamadaDelete(URL + getCodigo);
            exibir(resultado);

        }
        else {
            resultado = "O contato informado não existe";
            exibir(resultado);

        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_remover_contato, menu);
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

    public  void exibir ( String resultado){

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Remover Contato");
        alertDialog.setMessage(resultado);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
                alertDialog.show();
        }
}
