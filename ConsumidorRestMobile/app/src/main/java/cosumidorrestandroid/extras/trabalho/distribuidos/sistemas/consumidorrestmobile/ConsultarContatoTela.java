package cosumidorrestandroid.extras.trabalho.distribuidos.sistemas.consumidorrestmobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.classes.Cidade;
import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao.BuscarContato;


public class ConsultarContatoTela extends ActionBarActivity {
    EditText codigo;
    String getCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_contato);
        codigo = (EditText) findViewById(R.id.codigo);

    }


    public void eventoConsultar(View v) {
        String URL = "http://10.0.2.2:8080/ServicoREST/webresources/Rest/buscarContatoMobile/";
        getCodigo = codigo.getText().toString();
        BuscarContato bc = new BuscarContato();
        String resultado = bc.chamadaGet(URL + getCodigo);

        exibir(resultado);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consultar_contato, menu);
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

    public void exibir(String resultado) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Consultar Contato");
        if (resultado == null) {
            alertDialog.setMessage("Erro ao consultar o Contato");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {


                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();

        } else {


            try {
              JSONObject  json = new JSONObject(resultado);
                JSONObject j = new JSONObject(json.getString("cep"));
                JSONObject ja = new JSONObject(j.getString("cidade"));


                alertDialog.setMessage(" Nome: " + json.getString("nome") + "\n " +
                        "E-mail: " + json.getString("email") + "\n " +
                        "Endereço: " + json.getString("endereco") + "\n " +
                        "Complemento: " + json.getString("complemento") + "\n " +
                        "CEP: " + j.getString("cep")+"\n " +
                       "Cidade: " + ja.getString("nome") +"\n " +
                        "Estado: " + ja.getString("estado")+"\n " +
                        "E-mail Alternativo: " + json.getString("emailAlternativo"));

            } catch (JSONException e) {
                alertDialog.setMessage("Erro ao consultar o Contato");
            }



            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {


                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        }
    }
}
