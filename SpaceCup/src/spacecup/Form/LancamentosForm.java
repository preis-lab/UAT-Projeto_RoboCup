
package spacecup.Form;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import spacecup.DAO.LancamentoDAO;
import spacecup.Model.Lancamento;


public class LancamentosForm extends javax.swing.JInternalFrame {


    public LancamentosForm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbAnoCompeticao = new javax.swing.JComboBox<>();
        cbCompeticoes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        cbCompeticoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCompeticoesActionPerformed(evt);
            }
        });

        jLabel1.setText("Ano");

        jLabel2.setText("Competicao");

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Distancia", "Angulo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCompeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAnoCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltrar)
                .addContainerGap(165, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCompeticoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbAnoCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbCompeticoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCompeticoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCompeticoesActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String nome = (String)cbCompeticoes.getSelectedItem();
        String ano = (String)cbAnoCompeticao.getSelectedItem();

        List<Lancamento> lancamentos = new LancamentoDAO().getLancamentosByYear(nome, ano);
        listar(lancamentos);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    /**
     * Método para listar os Lancamentos e exibi-los na tabela. Gera um
     * <code>Array</code> de <code>Lancamento</code> e exibe cada um na tabela
     */
    private void listar(List<Lancamento> lancamentos) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        clearList();
        
        for (Lancamento l : lancamentos) {   
            model.addRow((Object[]) addLinha(l));
        }
    }
    
    /**
     * Método para limpar a lista de Lancamentos.
     */
    private void clearList() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /**
     * Método para adcionar um objeto <code>Lancamento</code> na linha da tabela.
     *
     * @param objeto <code>Lancamento</code>
     * @return Um objeto tipo <code>Vector</code> já formatado para ser colocado
     * na linha da tabela
     */
    private Object addLinha(Lancamento l) {
        return new Object[]{
            l.getId(),
            l.getDistanciaDoAlvo(),
            l.getAnguloLancamento()
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cbAnoCompeticao;
    private javax.swing.JComboBox<String> cbCompeticoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables

}
