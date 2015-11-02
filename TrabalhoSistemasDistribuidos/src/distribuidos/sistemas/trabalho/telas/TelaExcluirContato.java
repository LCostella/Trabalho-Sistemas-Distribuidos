package distribuidos.sistemas.trabalho.telas;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import distribuidos.sistemas.trabalho.dao.RemoverContato;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class TelaExcluirContato extends javax.swing.JFrame {
    private Contato contato;
    /**
     * Creates new form TelaExcluirCliente
     */
    
     public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    public TelaExcluirContato() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigoText = new javax.swing.JTextField();
        TextCod = new javax.swing.JLabel();
        ExcluirButton = new javax.swing.JButton();
        CancelarButton = new javax.swing.JButton();
        Remov = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TextCod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextCod.setText("Código: ");

        ExcluirButton.setText("Excluir");
        ExcluirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirButtonActionPerformed(evt);
            }
        });

        CancelarButton.setText("Cancelar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        Remov.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Remov.setText("Remover Contato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextCod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ExcluirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelarButton)
                        .addGap(9, 9, 9))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(Remov)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Remov, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(TextCod, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExcluirButton)
                    .addComponent(CancelarButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExcluirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirButtonActionPerformed
        // TODO add your handling code here:
        if(codigoText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Campo Código é obrigatório!");
                return;
        }  
        Integer codigo = verificarDigitos(codigoText.getText());
        if(codigo == null){
            codigoText.setText("");
            return;
        }
        contato = new Contato();
        contato.setCodigo(codigo);
       
        BuscarContato lc = new BuscarContato();
        try {
            contato = lc.buscarContato(codigo);
            
            if(contato!=null)
            {
                Object[] options = {"Sim", "Não"};
                int i = JOptionPane.showOptionDialog(null,
                        "Tem certeza que deseja excluir " + contato.getNome() + "\n"+contato.getEmail() +" ?", "Saída",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        options, options[0]);
                if (i == JOptionPane.YES_OPTION) {
                    RemoverContato ic = new RemoverContato();
                    if(ic.remover(contato)){
                        JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
                        return;
                    }else{
                        JOptionPane.showMessageDialog(this, "Erro ao excluir");
                        return;
                    }
                }
            }else
            {
                JOptionPane.showMessageDialog(this, "Contato não encontrado no Banco!");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaExcluirContato.class.getName()).log(Level.SEVERE, null, ex);           
        }       
    }//GEN-LAST:event_ExcluirButtonActionPerformed
    
    private Integer verificarDigitos(String texto){
        Integer c = null ;
        try {
            c = Integer.parseInt(texto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Digite apenas números!");
            return null;
        }
        return c;
    }
    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelarButton;
    private javax.swing.JButton ExcluirButton;
    private javax.swing.JLabel Remov;
    private javax.swing.JLabel TextCod;
    private javax.swing.JTextField codigoText;
    // End of variables declaration//GEN-END:variables
}
