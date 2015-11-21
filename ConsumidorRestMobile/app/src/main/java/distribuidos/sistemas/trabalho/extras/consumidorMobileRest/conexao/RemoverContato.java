package distribuidos.sistemas.trabalho.extras.consumidorMobileRest.conexao;

import android.os.StrictMode;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by Leonardo on 13/11/2015.
 */
public class RemoverContato {
    private int TIMEOUT_MILLISEC = 3000;

    public String chamadaDelete(String url ){

        HttpClient cliente = new DefaultHttpClient();


        HttpDelete chamada = new HttpDelete(url);
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

