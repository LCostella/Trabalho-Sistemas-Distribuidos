package cosumidorrestandroid.extras.trabalho.distribuidos.sistemas.consumidorrestmobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.classes.Cep;
import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.classes.Cidade;
import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.classes.Contato;
import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.classes.Resposta;
import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao.BuscarCep;
import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao.InserirContato;


public class InserirContatoTela extends ActionBarActivity {
    Contato c = new Contato();


    Button btCancelar;
    EditText nome;
    EditText cep;
    EditText complemento;
    EditText endereco;
    EditText email;
    EditText emailComplementar;
    EditText cidade;
    EditText estado;
    String getNome;
    String getEspado;
    String getCidade;
    String getEndereco;
    String getComplemento;
    String getEmail;
    String getEmailComp;
    String getCep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserircontato);
        nome = (EditText) findViewById(R.id.nome);
        cep = (EditText) findViewById(R.id.cep);
        complemento = (EditText) findViewById(R.id.complemento);
        endereco = (EditText) findViewById(R.id.endereco);
        email = (EditText) findViewById(R.id.email);
        emailComplementar = (EditText) findViewById(R.id.emailAlternativo);
        cidade = (EditText) findViewById(R.id.cidade);
        estado = (EditText) findViewById(R.id.estado);

    }

    public void eventoInserir(View v) {
        getNome = nome.getText().toString();
        getComplemento = complemento.getText().toString();
        getEmail = email.getText().toString();
        getEmailComp = emailComplementar.getText().toString();
        getEndereco = endereco.getText().toString();
        getCep = cep.getText().toString();

        if (getNome.trim().isEmpty()) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Inserir Contato");
            alertDialog.setMessage("Campo Nome é Obrigatório");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();

        }


        if (getEmail.trim().isEmpty()) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Inserir Contato");
            alertDialog.setMessage("Campo email é Obrigatório");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        }


        if (getCep.trim().isEmpty()) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Inserir Contato");
            alertDialog.setMessage("Campo cep é obrigatório");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        }

            //SETANDO CONTATO

            c.setNome(getNome);
            c.setComplemento(getComplemento);
            c.setEmail(getEmail);
            c.setEmailAlternativo(getEmailComp);
            c.setEndereco(getEndereco);
        ////  INSERIR E DEPOIS ABAIXO EXIBIR MENSAGEM QUEM FOI INSERIDO COM SUCESSO!

             AlertDialog alertDialog = new AlertDialog.Builder(this).create();
             alertDialog.setTitle("Inserir Contato");
             alertDialog.setMessage(" ");//setar mensagem de inserção com sucesso ou não!
             alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
              @Override
             public void onClick(DialogInterface dialog, int which) {
            }
                  });
             alertDialog.show();


        }

          public  void eventoBuscarCep (View v){
                getCep = cep.getText().toString();
                if(getCep.length() > 7){
                String URL = "http://10.0.2.2:8080/ServicoREST/webresources/Rest/buscarCepMobile/";
                BuscarCep bc = new BuscarCep();
                String resultado = bc.chamadaGet(URL + getCep);


                 JSONObject json = null;
                      try {
                         json = new JSONObject(resultado);

                         } catch (JSONException e) {
                                e.printStackTrace();
                        }
                      try {
                        JSONObject ja = new JSONObject(json.getString("cidade"));


                     // Gson gsoncep = new Gson();
                     //city = gsoncep.fromJson(String.valueOf(ja),Cidade.class);

                     cidade.setText(ja.getString("nome"));
                     estado.setText(ja.getString("estado"));

                     //INSTANCIA A CIDADE
                      Cidade city = new Cidade();
                      city.setCodigo(Integer.parseInt(ja.getString("codigo")));
                      city.setEstado(ja.getString("estado"));
                      city.setNome(ja.getString("nome"));

                      //INSTANCIA O ESTADO
                      Cep recebeCep  = new Cep();
                      recebeCep.setCidade(city);
                      recebeCep.setCep(Integer.parseInt(json.getString("cep")));
                      recebeCep.setCep(Integer.parseInt(getCep));

                      c.setCep(recebeCep);


                     } catch (JSONException e) {
                        e.printStackTrace();
                     }

                        try {
                            json = new JSONObject(resultado);
                        } catch (JSONException e) {
                            e.printStackTrace();
                         }

                          }
          }



        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inserir_contato_tela, menu);
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
