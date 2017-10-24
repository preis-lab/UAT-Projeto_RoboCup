package spacecup.Form;

import java.util.List;
import javax.swing.JOptionPane;
import spacecup.DAO.EquipeDAO;
import spacecup.DAO.FogueteDAO;
import spacecup.DAO.LancamentoDAO;
import spacecup.DAO.TurmaDAO;
import spacecup.DAO.UsuarioDAO;
import spacecup.Model.Aluno;
import spacecup.Model.Foguete;
import spacecup.Model.Lancamento;
import spacecup.Model.Usuario;

public class detalheLancamento extends javax.swing.JFrame {

    Usuario usuario;
    List<String> listaEquipes;
    List<String> listaTurmas;
    List<Foguete> foguetes;

    detalheLancamento(Usuario usuario) {
        initComponents();
        btnSalvar.setEnabled(true);
        btnAlterar.setEnabled(false);
        this.usuario = usuario;

        populaDados();

        if (usuario.getNivelAcesso() == 0) {
            Aluno aluno = new UsuarioDAO().getAlunoById(usuario.getId());
            cbEquipe.setEnabled(false);
            cbTurma.setEnabled(false);
            cbEquipe.setSelectedItem(aluno.getEquipe().getNome());
            cbEquipe.setSelectedItem(aluno.getEquipe().getTurma().getNome());

        }

    }
    
    detalheLancamento(int id) {
        initComponents();
        
        Lancamento l = new LancamentoDAO().getLancamento(id);
        
        this.setEnabled(false);
        
        lblId.setText(String.valueOf(l.getId()));
        txtDistanciaAlvo.setText(String.valueOf(l.getDistanciaDoAlvo()));
        txtAnguloLancamento.setText(String.valueOf(l.getAnguloLancamento()));
        txtVelocidadeVento.setText(String.valueOf(l.getVelocidadeVento()));
        txtAltitudeMaxima.setText(String.valueOf(l.getAltitudeMaxima()));
        txtAltitudeEjecao.setText(String.valueOf(l.getAltitudeEjecao()));
        txtDistanciaQuedaAlvo.setText(String.valueOf(l.getAltitudeMaxima()));
        txtTaxaDescida.setText(String.valueOf(l.getTaxaDescida()));
        txtDuracaoVoo.setText(String.valueOf(l.getDuracaoVoo()));
        txtTempoPropulsao.setText(String.valueOf(l.getTempoPropulsao()));
        txtTempoApogeu.setText(String.valueOf(l.getTempoPropulsao()));
        txtPicoAcelerecao.setText(String.valueOf(l.getPicoAceleracao()));
        txtAceleracaoMedia.setText(String.valueOf(l.getAceleracaoMedia()));
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(true);
        cbEquipe.setSelectedItem(l.getEquipe().getNome());
        cbEquipe.setSelectedItem(l.getEquipe().getTurma().getNome());

        foguetes = new FogueteDAO().getFoguetes();

        populaDados();
    }

    detalheLancamento(int id, Usuario usuario) {
        this.usuario = usuario;

        initComponents();

        Lancamento l = new LancamentoDAO().getLancamento(id);

        lblId.setText(String.valueOf(l.getId()));
        txtDistanciaAlvo.setText(String.valueOf(l.getDistanciaDoAlvo()));
        txtAnguloLancamento.setText(String.valueOf(l.getAnguloLancamento()));
        txtVelocidadeVento.setText(String.valueOf(l.getVelocidadeVento()));
        txtAltitudeMaxima.setText(String.valueOf(l.getAltitudeMaxima()));
        txtAltitudeEjecao.setText(String.valueOf(l.getAltitudeEjecao()));
        txtDistanciaQuedaAlvo.setText(String.valueOf(l.getAltitudeMaxima()));
        txtTaxaDescida.setText(String.valueOf(l.getTaxaDescida()));
        txtDuracaoVoo.setText(String.valueOf(l.getDuracaoVoo()));
        txtTempoPropulsao.setText(String.valueOf(l.getTempoPropulsao()));
        txtTempoApogeu.setText(String.valueOf(l.getTempoPropulsao()));
        txtPicoAcelerecao.setText(String.valueOf(l.getPicoAceleracao()));
        txtAceleracaoMedia.setText(String.valueOf(l.getAceleracaoMedia()));
        btnSalvar.setEnabled(false);
        btnAlterar.setEnabled(true);
        cbEquipe.setSelectedItem(l.getEquipe().getNome());
        cbEquipe.setSelectedItem(l.getEquipe().getTurma().getNome());

        foguetes = new FogueteDAO().getFoguetes();

        populaDados();
    }

    private void populaDados() {
        listaEquipes = new EquipeDAO().getNomes();
        listaTurmas = new TurmaDAO().getNomes();

        for (String s : listaEquipes) {
            cbEquipe.addItem(s);
        }

        for (String s : listaTurmas) {
            cbTurma.addItem(s);
        }
        List<Foguete> foguetes = new FogueteDAO().getFoguetes();

        for (Foguete f : foguetes) {
            cbFoguete.addItem(String.valueOf(f.getId()));
        }
    }

    private void verificaDados() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDistanciaAlvo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAnguloLancamento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtVelocidadeVento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAltitudeMaxima = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAltitudeEjecao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPicoAcelerecao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTaxaDescida = new javax.swing.JTextField();
        lblDistanciaQuedaAlvo = new javax.swing.JLabel();
        txtDistanciaQuedaAlvo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDuracaoVoo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTempoPropulsao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTempoApogeu = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtAceleracaoMedia = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        cbFoguete = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        cbEquipe = new javax.swing.JComboBox<>();
        cbTurma = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(4, 47, 107));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(4, 47, 107));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Distância do alvo:");

        txtDistanciaAlvo.setBackground(new java.awt.Color(4, 47, 107));
        txtDistanciaAlvo.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        txtDistanciaAlvo.setForeground(new java.awt.Color(254, 254, 254));
        txtDistanciaAlvo.setBorder(null);
        txtDistanciaAlvo.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Ângulo lançamento:");

        txtAnguloLancamento.setBackground(new java.awt.Color(4, 47, 107));
        txtAnguloLancamento.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        txtAnguloLancamento.setForeground(new java.awt.Color(254, 254, 254));
        txtAnguloLancamento.setBorder(null);
        txtAnguloLancamento.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Velocidade do vento:");

        txtVelocidadeVento.setBackground(new java.awt.Color(4, 47, 107));
        txtVelocidadeVento.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        txtVelocidadeVento.setForeground(new java.awt.Color(254, 254, 254));
        txtVelocidadeVento.setBorder(null);
        txtVelocidadeVento.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Altitude máxima:");

        txtAltitudeMaxima.setBackground(new java.awt.Color(4, 47, 107));
        txtAltitudeMaxima.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        txtAltitudeMaxima.setForeground(new java.awt.Color(254, 254, 254));
        txtAltitudeMaxima.setBorder(null);
        txtAltitudeMaxima.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Altitude ejeção:");

        txtAltitudeEjecao.setBackground(new java.awt.Color(4, 47, 107));
        txtAltitudeEjecao.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        txtAltitudeEjecao.setForeground(new java.awt.Color(254, 254, 254));
        txtAltitudeEjecao.setBorder(null);
        txtAltitudeEjecao.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 250, 250));
        jLabel8.setText("Pico de aceleração:");

        txtPicoAcelerecao.setBackground(new java.awt.Color(4, 47, 107));
        txtPicoAcelerecao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPicoAcelerecao.setForeground(new java.awt.Color(254, 254, 254));
        txtPicoAcelerecao.setBorder(null);
        txtPicoAcelerecao.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 250, 250));
        jLabel9.setText("Taxa descida:");

        txtTaxaDescida.setBackground(new java.awt.Color(4, 47, 107));
        txtTaxaDescida.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTaxaDescida.setForeground(new java.awt.Color(254, 254, 254));
        txtTaxaDescida.setBorder(null);
        txtTaxaDescida.setCaretColor(new java.awt.Color(254, 254, 254));

        lblDistanciaQuedaAlvo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDistanciaQuedaAlvo.setForeground(new java.awt.Color(255, 250, 250));
        lblDistanciaQuedaAlvo.setText("Distancia entre queda e alvo:");

        txtDistanciaQuedaAlvo.setBackground(new java.awt.Color(4, 47, 107));
        txtDistanciaQuedaAlvo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDistanciaQuedaAlvo.setForeground(new java.awt.Color(254, 254, 254));
        txtDistanciaQuedaAlvo.setBorder(null);
        txtDistanciaQuedaAlvo.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 250, 250));
        jLabel12.setText("Duração vôo:");

        txtDuracaoVoo.setBackground(new java.awt.Color(4, 47, 107));
        txtDuracaoVoo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDuracaoVoo.setForeground(new java.awt.Color(254, 254, 254));
        txtDuracaoVoo.setBorder(null);
        txtDuracaoVoo.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 250, 250));
        jLabel13.setText("Tempo propulsão:");

        txtTempoPropulsao.setBackground(new java.awt.Color(4, 47, 107));
        txtTempoPropulsao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTempoPropulsao.setForeground(new java.awt.Color(254, 254, 254));
        txtTempoPropulsao.setBorder(null);
        txtTempoPropulsao.setCaretColor(new java.awt.Color(254, 254, 254));

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 250, 250));
        jLabel11.setText("Tempo apogeu:");

        txtTempoApogeu.setBackground(new java.awt.Color(4, 47, 107));
        txtTempoApogeu.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTempoApogeu.setForeground(new java.awt.Color(254, 254, 254));
        txtTempoApogeu.setBorder(null);
        txtTempoApogeu.setCaretColor(new java.awt.Color(254, 254, 254));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Equipe:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 250, 250));
        jLabel2.setText("Turma:");

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setText("Aceleração média:");

        txtAceleracaoMedia.setBackground(new java.awt.Color(4, 47, 107));
        txtAceleracaoMedia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAceleracaoMedia.setForeground(new java.awt.Color(254, 254, 254));
        txtAceleracaoMedia.setBorder(null);
        txtAceleracaoMedia.setCaretColor(new java.awt.Color(254, 254, 254));

        cbFoguete.setBackground(new java.awt.Color(254, 254, 254));
        cbFoguete.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbFoguete.setForeground(new java.awt.Color(1, 1, 1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("Foguete:");

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 254, 254));
        jLabel15.setText("ID:");

        lblId.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(254, 254, 254));

        cbEquipe.setBackground(new java.awt.Color(254, 254, 254));
        cbEquipe.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbEquipe.setForeground(new java.awt.Color(1, 1, 1));
        cbEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEquipeActionPerformed(evt);
            }
        });

        cbTurma.setBackground(new java.awt.Color(254, 254, 254));
        cbTurma.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cbTurma.setForeground(new java.awt.Color(1, 1, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5)
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFoguete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDistanciaAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPicoAcelerecao, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDistanciaQuedaAlvo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDistanciaQuedaAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTaxaDescida, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnguloLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAceleracaoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAltitudeEjecao, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDuracaoVoo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVelocidadeVento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTempoPropulsao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAltitudeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbEquipe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTempoApogeu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator8)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbFoguete, lblId, txtAceleracaoMedia, txtAltitudeEjecao, txtAltitudeMaxima, txtAnguloLancamento, txtDistanciaAlvo, txtDistanciaQuedaAlvo, txtDuracaoVoo, txtPicoAcelerecao, txtTaxaDescida, txtVelocidadeVento});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel10, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel14, jLabel9});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtTempoApogeu, txtTempoPropulsao});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterar, btnCancelar, btnSalvar});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel15, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDistanciaQuedaAlvo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPicoAcelerecao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDistanciaQuedaAlvo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDistanciaAlvo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTaxaDescida, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAnguloLancamento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAceleracaoMedia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAltitudeEjecao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtDuracaoVoo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVelocidadeVento, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTempoPropulsao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAltitudeMaxima, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtTempoApogeu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbFoguete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnAlterar))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, txtPicoAcelerecao});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel15, lblId});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Lancamento l = new Lancamento();
        l.setDistanciaDoAlvo(Float.parseFloat(txtDistanciaAlvo.getText()));
        l.setAnguloLancamento(Float.parseFloat(txtAnguloLancamento.getText()));
        l.setVelocidadeVento(Float.parseFloat(txtVelocidadeVento.getText()));
        l.setAltitudeMaxima(Float.parseFloat(txtAltitudeMaxima.getText()));
        l.setAltitudeEjecao(Float.parseFloat(txtAltitudeEjecao.getText()));
        l.setPicoAceleracao(Float.parseFloat(txtPicoAcelerecao.getText()));
        l.setDistanciaEntreQuedaAlvo(Float.parseFloat(txtDistanciaQuedaAlvo.getText()));
        l.setTaxaDescida(Float.parseFloat(txtTaxaDescida.getText()));
        l.setAceleracaoMedia(Float.parseFloat(txtAceleracaoMedia.getText()));

        //datas
        l.setDuracaoVoo(Float.parseFloat(txtDuracaoVoo.getText()));
        l.setTempoApogeuDescida(Float.parseFloat(txtTempoApogeu.getText()));
        l.setTempoPropulsao(Float.parseFloat(txtTempoPropulsao.getText()));

        l.setEquipe(new EquipeDAO().getByNome((String) cbEquipe.getSelectedItem()));
        l.setFoguete(new FogueteDAO().getById(Integer.parseInt((String) cbFoguete.getSelectedItem())));

        new LancamentoDAO().insereLancamento(l);
        JOptionPane.showMessageDialog(this, "Lançamento salvo com sucesso!");
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Lancamento l = new Lancamento();

        l.setId(Integer.parseInt(lblId.getText()));
        l.setDistanciaDoAlvo(Float.parseFloat(txtDistanciaAlvo.getText()));
        l.setAnguloLancamento(Float.parseFloat(txtAnguloLancamento.getText()));
        l.setVelocidadeVento(Float.parseFloat(txtVelocidadeVento.getText()));
        l.setAltitudeMaxima(Float.parseFloat(txtAltitudeMaxima.getText()));
        l.setAltitudeEjecao(Float.parseFloat(txtAltitudeEjecao.getText()));
        l.setPicoAceleracao(Float.parseFloat(txtPicoAcelerecao.getText()));
        l.setDistanciaEntreQuedaAlvo(Float.parseFloat(txtDistanciaQuedaAlvo.getText()));
        l.setTaxaDescida(Float.parseFloat(txtTaxaDescida.getText()));
        l.setAceleracaoMedia(Float.parseFloat(txtAceleracaoMedia.getText()));

        //datas
        l.setDuracaoVoo(Float.parseFloat(txtDuracaoVoo.getText()));
        l.setTempoApogeuDescida(Float.parseFloat(txtTempoApogeu.getText()));
        l.setTempoPropulsao(Float.parseFloat(txtTempoPropulsao.getText()));

        l.setEquipe(new EquipeDAO().getByNome((String) cbEquipe.getSelectedItem()));
        l.setFoguete(new FogueteDAO().getById(Integer.parseInt((String) cbFoguete.getSelectedItem())));

        new LancamentoDAO().alteraLancamento(l);
        JOptionPane.showMessageDialog(this, "Lançamento salvo com sucesso!");
        this.dispose();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void cbEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEquipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEquipeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbEquipe;
    private javax.swing.JComboBox<String> cbFoguete;
    private javax.swing.JComboBox<String> cbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblDistanciaQuedaAlvo;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtAceleracaoMedia;
    private javax.swing.JTextField txtAltitudeEjecao;
    private javax.swing.JTextField txtAltitudeMaxima;
    private javax.swing.JTextField txtAnguloLancamento;
    private javax.swing.JTextField txtDistanciaAlvo;
    private javax.swing.JTextField txtDistanciaQuedaAlvo;
    private javax.swing.JTextField txtDuracaoVoo;
    private javax.swing.JTextField txtPicoAcelerecao;
    private javax.swing.JTextField txtTaxaDescida;
    private javax.swing.JTextField txtTempoApogeu;
    private javax.swing.JTextField txtTempoPropulsao;
    private javax.swing.JTextField txtVelocidadeVento;
    // End of variables declaration//GEN-END:variables
}
