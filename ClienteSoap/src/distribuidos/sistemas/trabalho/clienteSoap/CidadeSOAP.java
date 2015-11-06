/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package distribuidos.sistemas.trabalho.clienteSoap;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Eliardo Marini
 */
public class CidadeSOAP {

    private int codigo;
    private String nome;
    private String estado;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo;
        hash = 89 * hash + Objects.hashCode(this.nome);
        return hash;
    }


    @Override
    public String toString() {
        return  nome + " | " + estado;
    }

    public CidadeSOAP() {
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
