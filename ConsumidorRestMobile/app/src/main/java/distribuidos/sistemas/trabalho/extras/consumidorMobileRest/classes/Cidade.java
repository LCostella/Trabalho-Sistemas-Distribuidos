package distribuidos.sistemas.trabalho.extras.consumidorMobileRest.classes;

import java.util.List;

/**
 * Created by Leonardo on 13/11/2015.
 */
public class Cidade {
    private int codigo;
    private String nome;
    private String estado;
    private List<Cep> ceps;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Cep> getCeps() {
        return ceps;
    }

    public void setCeps(List<Cep> ceps) {
        this.ceps = ceps;
    }
}
