
package spacecup.Form;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class MainForm extends javax.swing.JFrame {
    
    private final Color inativoColor = new Color(4,47,107);
    private final Color ativoColor = new Color(0,40,95);

    public MainForm() {
        initComponents();
        addJanela(new FormGerenciarLancamento());
        mudaBG(lancamentos, ativoColor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sideBar = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lancamentos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        alunos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        equipes = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        competicoes = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        foguetes = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jdPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sideBar.setBackground(new java.awt.Color(4, 47, 107));

        logo.setBackground(new java.awt.Color(50, 230, 200));
        logo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(50, 230, 200));
        logo.setText("Space Cup");

        lancamentos.setBackground(new java.awt.Color(4, 47, 107));
        lancamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lancamentosMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spacecup/icons/rocket.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Lancamentos");

        javax.swing.GroupLayout lancamentosLayout = new javax.swing.GroupLayout(lancamentos);
        lancamentos.setLayout(lancamentosLayout);
        lancamentosLayout.setHorizontalGroup(
            lancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lancamentosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        lancamentosLayout.setVerticalGroup(
            lancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lancamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        alunos.setBackground(new java.awt.Color(4, 47, 107));
        alunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alunosMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spacecup/icons/rocket.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Alunos");

        javax.swing.GroupLayout alunosLayout = new javax.swing.GroupLayout(alunos);
        alunos.setLayout(alunosLayout);
        alunosLayout.setHorizontalGroup(
            alunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alunosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        alunosLayout.setVerticalGroup(
            alunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alunosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        equipes.setBackground(new java.awt.Color(4, 47, 107));
        equipes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipesMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spacecup/icons/rocket.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Equipes");

        javax.swing.GroupLayout equipesLayout = new javax.swing.GroupLayout(equipes);
        equipes.setLayout(equipesLayout);
        equipesLayout.setHorizontalGroup(
            equipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(equipesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        equipesLayout.setVerticalGroup(
            equipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(equipesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(equipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        competicoes.setBackground(new java.awt.Color(4, 47, 107));
        competicoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                competicoesMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spacecup/icons/rocket.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("Competições");

        javax.swing.GroupLayout competicoesLayout = new javax.swing.GroupLayout(competicoes);
        competicoes.setLayout(competicoesLayout);
        competicoesLayout.setHorizontalGroup(
            competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competicoesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        competicoesLayout.setVerticalGroup(
            competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(competicoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(competicoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        foguetes.setBackground(new java.awt.Color(4, 47, 107));
        foguetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foguetesMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spacecup/icons/rocket.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setText("Foguetes");

        javax.swing.GroupLayout foguetesLayout = new javax.swing.GroupLayout(foguetes);
        foguetes.setLayout(foguetesLayout);
        foguetesLayout.setHorizontalGroup(
            foguetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foguetesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        foguetesLayout.setVerticalGroup(
            foguetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foguetesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(foguetesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sideBarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lancamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(equipes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(competicoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(foguetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(logo)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lancamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(equipes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(competicoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foguetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jdPanel.setBackground(new java.awt.Color(50, 230, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jdPanel)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lancamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lancamentosMouseClicked
        mudaBG(lancamentos, ativoColor);
        addJanela(new FormGerenciarLancamento());
    }//GEN-LAST:event_lancamentosMouseClicked

    private void alunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alunosMouseClicked
        mudaBG(alunos, ativoColor);
        addJanela(new AlunoForm());
    }//GEN-LAST:event_alunosMouseClicked

    private void equipesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipesMouseClicked
        mudaBG(equipes, ativoColor);
        addJanela(new EquipesForm());
    }//GEN-LAST:event_equipesMouseClicked

    private void competicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_competicoesMouseClicked
        mudaBG(competicoes, ativoColor);
        addJanela(new CompeticoesForm());
    }//GEN-LAST:event_competicoesMouseClicked

    private void foguetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foguetesMouseClicked
        mudaBG(foguetes, ativoColor);
        addJanela(new ForguetesForm());
    }//GEN-LAST:event_foguetesMouseClicked

    private void addJanela(JInternalFrame janela) {
        jdPanel.removeAll();
        Dimension size = jdPanel.getSize();
        janela.setSize(size);
        jdPanel.add(janela);
        janela.setLocation(0, 0);
        janela.setVisible(true);
    }
    
    private void resetaBG() {
        lancamentos.setBackground(inativoColor);
        alunos.setBackground(inativoColor);
        equipes.setBackground(inativoColor);
        competicoes.setBackground(inativoColor);
        foguetes.setBackground(inativoColor);
    }
    
    private void mudaBG(JPanel painel, Color cor) {
        resetaBG();
        painel.setBackground(cor);
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alunos;
    private javax.swing.JPanel competicoes;
    private javax.swing.JPanel equipes;
    private javax.swing.JPanel foguetes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JDesktopPane jdPanel;
    private javax.swing.JPanel lancamentos;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel sideBar;
    // End of variables declaration//GEN-END:variables
}
