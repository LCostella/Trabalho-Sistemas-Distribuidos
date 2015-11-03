
package distribuidos.sistemas.trabalho.servicosoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de inserirCep complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="inserirCep">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cep" type="{http://servicoSoap.trabalho.sistemas.distribuidos/}cep" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inserirCep", propOrder = {
    "cep"
})
public class InserirCep {

    protected Cep cep;

    /**
     * Obtém o valor da propriedade cep.
     * 
     * @return
     *     possible object is
     *     {@link Cep }
     *     
     */
    public Cep getCep() {
        return cep;
    }

    /**
     * Define o valor da propriedade cep.
     * 
     * @param value
     *     allowed object is
     *     {@link Cep }
     *     
     */
    public void setCep(Cep value) {
        this.cep = value;
    }

}
