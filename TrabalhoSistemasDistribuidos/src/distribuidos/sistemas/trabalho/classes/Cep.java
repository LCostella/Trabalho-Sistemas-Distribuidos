package distribuidos.sistemas.trabalho.classes;

import java.util.Objects;

/**
 * 
 * @author Felipe
 */
public class Cep {
    private int cep;
    private Cidade cidade;
    
    public Cep() {
    }

    @Override
    public String toString() {
        return  cep + " | " + cidade.getNome() + " | " + cidade.getEstado();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.cep);
        hash = 53 * hash + Objects.hashCode(this.cidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cep other = (Cep) obj;
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        
        return true;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
