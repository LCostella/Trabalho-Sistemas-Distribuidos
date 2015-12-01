package distribuidos.sistemas.trabalho.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import twitter4j.Status;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterConsumer {

    /**
     * @param args
     * Autores Leonardo e Johni Andrei Reginatto
     */
       

    
    public void twittar(String mensagem) {


        
        String consumerKey = "q4Z4xqrTb9Y1hwY2AHIW8fufw";
        String consumerSecret = "shZuJKkW61w4S4fnb0QMEgiVUfWovHAMiAe2YSasfBSsdwAZSt";
        String twitterToken = "4332795279-mIUSoMIRWBYgivwGso4ydqRSik3Ujb73HdaSNVu";
        String twitterTokenSecret = "H6izhaUHrvpt1g6rPSICaj3y2rsemvKHyUa96aIrJkfz1";
            
        
        twitter4j.Twitter twitter = new TwitterFactory().getInstance();
      
twitter.setOAuthConsumer(consumerKey, consumerSecret);
        AccessToken accessToken = new AccessToken(twitterToken, twitterTokenSecret);
        twitter.setOAuthAccessToken(accessToken);

        try {
            twitter.updateStatus(mensagem);
            System.out.println("Tweet enviado!");
        } catch (TwitterException e) {
            System.out.println("Erro ao enviar o tweet");
        }
    }
}