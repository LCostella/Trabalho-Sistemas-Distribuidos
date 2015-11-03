
package distribuidos.sistemas.trabalho.servicosoap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de inserirContato complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="inserirContato">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contato" type="{http://servicoSoap.trabalho.sistemas.distribuidos/}contato" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inserirContato", propOrder = {
    "contato"
})
public class InserirContato {

    protected Contato contato;

    /**
     * Obtém o valor da propriedade contato.
     * 
     * @return
     *     possible object is
     *     {@link Contato }
     *     
     */
    public Contato getContato() {
        return contato;
    }

    /**
     * Define o valor da propriedade contato.
     * 
     * @param value
     *     allowed object is
     *     {@link Contato }
     *     
     */
    public void setContato(Contato value) {
        this.contato = value;
    }

}
