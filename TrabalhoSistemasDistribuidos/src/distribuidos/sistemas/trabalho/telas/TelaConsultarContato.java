package distribuidos.sistemas.trabalho.telas;

import distribuidos.sistemas.trabalho.classes.Contato;
import distribuidos.sistemas.trabalho.dao.BuscarContato;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo
 */
public class TelaConsultarContato extends javax.swing.JFrame {
    private Contato contato;
    private DefaultTableModel dtm;
    /**
     * Creates new form TelaListarCliente
     */
    public TelaConsultarContato() {
        initComponents();
        dtm = (DefaultTableModel) tabelaContato.getModel();
        dtm.setNumRows(0);
    }
     private void inserirItemTabela(Contato c) {
        dtm.addRow(new Object[]{
            c.getCodigo(),
            c.getNome(),
            c.getEndereco(),
            c.getComplemento(),
            c.getEmail(),
            c.getEmailAlternativo(),
            c.getCep(),
            c.getCep().getCidade().getNome(),
            c.getCep().getCidade().getEstado()
        
        });
    }
     private void attTabela(){
         dtm.setNumRows(0);
     }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campocodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContato = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        campocodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campocodigoActionPerformed(evt);
            }
        });

        jLabel1.setText("Digite o codigo:");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tabelaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Endereço", "Complemento", "Email", "Email Alt.", "Cep", "Cidade", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tabelaContato);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Consultar Contato");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnbuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(443, 443, 443)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnbuscar))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campocodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campocodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campocodigoActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        attTabela();
        BuscarContato bc = new BuscarContato();
        contato = null;
        try {
            contato = bc.buscarContato(campocodigo.getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro: "+
                ex.getLocalizedMessage());
            // para nao mostrar os erros  no final é so tirar esse getlocalizedmessage....
        }

        //jogando tudo em uma tabela
        if (contato != null) {
            inserirItemTabela(contato);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Código Não encontrado");
        }
        // retornando uma janela com os dados no jOptionpane
        /*
        if (contato != null) {
            JOptionPane.showMessageDialog(this, " Nome: " + contato.getNome() + "\n Cep: " + contato.getCep().getCep() + "" + "\n Complemento: " +
                contato.getComplemento() + "\n Email: " + contato.getEmail() + "\n Email alt.: " + contato.getEmailAlternativo() +
                "\n Endereco: " + contato.getEndereco() + "\n Cidade: " + contato.getCep().getCidade().getNome() +
                "\n Estado: " + contato.getCep().getCidade().getEstado());

        } else {
            JOptionPane.showMessageDialog(rootPane, "Código Não encontrado");
        }
        */

    }//GEN-LAST:event_btnbuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JTextField campocodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaContato;
    // End of variables declaration//GEN-END:variables
}
