/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidos.sistemas.trabalho.clienteSoap;

import distribuidos.sistemas.trabalho.servicosoap.Cidade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class BuscarCidade {
    public Cidade buscar(String nome, String estado){
        return buscarCidade(nome, estado);
    }

    private static Cidade buscarCidade(java.lang.String nome, java.lang.String estado) {
        distribuidos.sistemas.trabalho.servicosoap.CalculatorWS service = new distribuidos.sistemas.trabalho.servicosoap.CalculatorWS();
        distribuidos.sistemas.trabalho.servicosoap.ServidorSoapSD port = service.getServidorSoapSDPort();
        return port.buscarCidade(nome, estado);
    }

    private List<Cidade> listarCidade() {
        distribuidos.sistemas.trabalho.servicosoap.CalculatorWS service = new distribuidos.sistemas.trabalho.servicosoap.CalculatorWS();
        distribuidos.sistemas.trabalho.servicosoap.ServidorSoapSD port = service.getServidorSoapSDPort();        
        return port.listarCidade();
    }
    
    public List<CidadeSOAP> listar(){
        List<CidadeSOAP> list = new ArrayList<>();
        for(Cidade c: listarCidade()){
            CidadeSOAP cidade = new CidadeSOAP();
            cidade.setCodigo(c.getCodigo());
            cidade.setNome(c.getNome());
            cidade.setEstado(c.getEstado());
            
            list.add(cidade);
        }
        return list;
    }
    
}
