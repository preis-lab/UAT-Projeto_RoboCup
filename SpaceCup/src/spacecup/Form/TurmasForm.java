package spacecup.Form;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import spacecup.DAO.CompeticaoDAO;
import spacecup.DAO.EquipeDAO;
import spacecup.DAO.TipoCompeticaoDAO;
import spacecup.DAO.TurmaDAO;
import spacecup.Model.Competicao;
import spacecup.Model.Equipe;
import spacecup.Model.Turma;

public class TurmasForm extends javax.swing.JInternalFrame {

    private int id;
    private List<Turma> turmas;

    public TurmasForm() {
        initComponents();
        populaLista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbCompeticao = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbAnoCompeticao = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jLabel1.setText("Nome");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel2.setText("Competição");

        cbCompeticao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCompeticaoItemStateChanged(evt);
            }
        });

        jLabel3.setText("Ano");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAnoCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cbAnoCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnSalvar))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Competição", "Ano"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int index = jTable.getSelectedRow();
        TableModel model = jTable.getModel();

        if (index != -1) {
            id = (int) model.getValueAt(index, 0);
            txtNome.setText(String.valueOf(model.getValueAt(index, 1)));
            cbCompeticao.setSelectedItem(String.valueOf(model.getValueAt(index, 2)));
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Equipe c = new Equipe();
        c.setId(id);
        c.setNome(txtNome.getText());
        c.setTurma(new TurmaDAO().getByNome((String) cbCompeticao.getSelectedItem()));
        new EquipeDAO().alterar(c);
        JOptionPane.showMessageDialog(this, "Equipe " + c.getNome() + " Alterada!");
        populaLista();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Turma t = new Turma();
        t.setNome(txtNome.getText());
        t.setCompeticao(new CompeticaoDAO().getByNomeYear((String) cbCompeticao.getSelectedItem(),(String)cbAnoCompeticao.getSelectedItem()));
        new TurmaDAO().insere(t);
        JOptionPane.showMessageDialog(this, "Turma " + t.getNome() + " Adicionada!");

        populaLista();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbCompeticaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCompeticaoItemStateChanged
        cbAnoCompeticao.removeAllItems();

        List<String> anos = new CompeticaoDAO().getDatas((String) cbCompeticao.getSelectedItem());
        for (String a : anos) {
            cbAnoCompeticao.addItem(a);
        }    }//GEN-LAST:event_cbCompeticaoItemStateChanged

    private void populaLista() {
        turmas = new TurmaDAO().getTurma();
        listar();
    }

    private void listar() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        clearList();

        for (Turma t : turmas) {
            model.addRow((Object[]) addLinha(t));
        }

        List<String> competicoes = new TipoCompeticaoDAO().getNomes();
        for (String c : competicoes) {
            cbCompeticao.addItem(c);
        }

        cbAnoCompeticao.removeAllItems();
        List<String> anos = new CompeticaoDAO().getDatas((String) cbCompeticao.getSelectedItem());
        for (String a : anos) {
            cbAnoCompeticao.addItem(a);
        }

    }

    private void clearList() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private Object addLinha(Turma t) {
        return new Object[]{
            t.getId(),
            t.getNome(),
            t.getCompeticao().getTipoCompeticao().getNome(),
            t.getCompeticao().getData()
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbAnoCompeticao;
    private javax.swing.JComboBox<String> cbCompeticao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
