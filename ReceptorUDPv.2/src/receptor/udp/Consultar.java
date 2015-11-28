
package receptor.udp;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import distribuidos.sistemas.trabalho.dao.InserirContato;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Johni
 */
public class Consultar {
     private Contato contato;
    public Contato consultar(List<String> dados) throws Exception{
        contato = new Contato();
        int i = 0;
        if(dados.get(i).equals("c")){ // Testa se for consultar
            i++;
            BuscarContato ic = new BuscarContato();
            contato = ic.buscarContato(Integer.parseInt(dados.get(i).trim()));
        }
        return contato;
}
}
