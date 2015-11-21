package distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao;

import android.graphics.Paint;
import android.os.StrictMode;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import distribuidos.sistemas.trabalho.extras.consumidorMobileRest.classes.Contato;

/**
 * Created by Leonardo on 13/11/2015.
 */
public class BuscarContato {
    private int TIMEOUT_MILLISEC = 3000;

    public String chamadaGet(String url){

        HttpClient cliente = new DefaultHttpClient();

        HttpGet chamada = new HttpGet(url);
        String retorno = "";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = null;
        try {
            responseBody = cliente.execute(chamada,responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        retorno = responseBody;
        return retorno;

    }


}
