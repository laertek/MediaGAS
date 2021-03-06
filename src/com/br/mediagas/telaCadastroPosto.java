
package com.br.mediagas;

import com.br.mediagas.model.Posto;
import com.br.mediagas.dao.PostoDAO;
import javax.swing.JOptionPane;
import java.sql.Connection; 
import java.sql.SQLException; 
import com.br.mediagas.factory.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/*
 *
 * @author Laerte
 */
public class telaCadastroPosto extends javax.swing.JFrame {

    /**
     * Creates new form telaCadastroPosto
     */
    public telaCadastroPosto() {
        initComponents();
    }

    
    // inicio
    public void povoarJPosto(String sql)
    {
          // conectar ao banco  
    
            Connection connection = new ConnectionFactory().getConnection();
            try
            {
                PreparedStatement stmt = connection.prepareCall(sql);
            
                ResultSet rs = stmt.executeQuery();
                DefaultTableModel model = (DefaultTableModel) jPosto.getModel();
                model.setNumRows(0); //inicializar do primeiro elemento da tabela
                
                while(rs.next())
                 {
                      model.addRow(new Object[]
                    {
                        rs.getString("idposto"),
                        rs.getString("nome"),
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getInt("numero"),
                        rs.getInt("cep"),
                        rs.getString("tel"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getFloat("longitude"),
                        rs.getFloat("latitude"),
                    });
                }
                
                
               //fechar banco 
               connection.close(); 
               System.out.println("Conexão Fechar");
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível obter dados do banco. Erro:"+ex); 
            }
    
    
    
    
    
            
    }
     
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        bntVoltar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCodPosto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCEP = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTEL = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtLongitude = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtLatitude = new javax.swing.JTextField();
        bntInserir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPosto = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        bntLimpar = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        txtBairro = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(717, 611));
        setMinimumSize(new java.awt.Dimension(717, 611));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("");
        jPanel1.setMaximumSize(new java.awt.Dimension(717, 611));
        jPanel1.setMinimumSize(new java.awt.Dimension(717, 611));
        jPanel1.setPreferredSize(new java.awt.Dimension(717, 611));
        jPanel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("   Cadastro / Alterações Postos");
        jLabel14.setToolTipText("");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bntVoltar.setText("Voltar");
        bntVoltar.setPreferredSize(new java.awt.Dimension(63, 23));
        bntVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntVoltarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Código Posto");

        txtCodPosto.setBackground(new java.awt.Color(245, 233, 233));
        txtCodPosto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCodPosto.setToolTipText("");
        txtCodPosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodPostoKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Descrição");

        txtNome.setBackground(new java.awt.Color(245, 233, 233));
        txtNome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtNome.setToolTipText("Digite Nome do Posto");
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nº ");

        txtRua.setBackground(new java.awt.Color(245, 233, 233));
        txtRua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtRua.setToolTipText("Digite o endereço.");
        txtRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRuaActionPerformed(evt);
            }
        });
        txtRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRuaKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Logradouro");

        txtNumero.setBackground(new java.awt.Color(245, 233, 233));
        txtNumero.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtNumero.setToolTipText("Digite Número.");
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumeroKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("CEP");

        txtCEP.setBackground(new java.awt.Color(245, 233, 233));
        txtCEP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCEP.setToolTipText("Digite CEP.");
        txtCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCEPKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Cidade");

        txtTEL.setBackground(new java.awt.Color(245, 233, 233));
        txtTEL.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTEL.setToolTipText("Digite Telefone.");
        txtTEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTELActionPerformed(evt);
            }
        });
        txtTEL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTELKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("TEL");

        txtCidade.setBackground(new java.awt.Color(245, 233, 233));
        txtCidade.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCidade.setToolTipText("Digite Cidade.");
        txtCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCidadeKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Latitude");

        txtLongitude.setBackground(new java.awt.Color(245, 233, 233));
        txtLongitude.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtLongitude.setToolTipText("Digite Longitude");
        txtLongitude.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLongitudeKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Longitude");

        txtLatitude.setBackground(new java.awt.Color(245, 233, 233));
        txtLatitude.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtLatitude.setToolTipText("Digite Latitude");
        txtLatitude.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLatitudeKeyPressed(evt);
            }
        });

        bntInserir.setText("Inserir");
        bntInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntInserirActionPerformed(evt);
            }
        });

        jPosto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Rua", "Bairro", "Numero", "CEP", "Telefone", "Cidade", "Estado", "Longitude", "Latitude"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jPosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPostoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jPosto);
        if (jPosto.getColumnModel().getColumnCount() > 0) {
            jPosto.getColumnModel().getColumn(0).setMinWidth(40);
            jPosto.getColumnModel().getColumn(0).setMaxWidth(40);
            jPosto.getColumnModel().getColumn(4).setMinWidth(50);
            jPosto.getColumnModel().getColumn(4).setMaxWidth(50);
            jPosto.getColumnModel().getColumn(5).setMinWidth(60);
            jPosto.getColumnModel().getColumn(5).setMaxWidth(60);
            jPosto.getColumnModel().getColumn(9).setMinWidth(60);
            jPosto.getColumnModel().getColumn(9).setMaxWidth(60);
            jPosto.getColumnModel().getColumn(10).setMinWidth(60);
            jPosto.getColumnModel().getColumn(10).setMaxWidth(60);
        }

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Estado");

        txtEstado.setBackground(new java.awt.Color(245, 233, 233));
        txtEstado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtEstado.setToolTipText("Digite Estado");
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });
        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEstadoKeyPressed(evt);
            }
        });

        bntLimpar.setText("Limpar");
        bntLimpar.setToolTipText("");
        bntLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLimparActionPerformed(evt);
            }
        });

        btnUpdate.setText("Alterar");
        btnUpdate.setToolTipText("");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.setToolTipText("");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        txtBairro.setBackground(new java.awt.Color(245, 233, 233));
        txtBairro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtBairro.setToolTipText("Digite Número.");
        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBairroKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Bairro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCodPosto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTEL, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(453, 453, 453)
                                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bntVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(bntInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(bntLimpar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnUpdate)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnDeletar))))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodPosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(txtLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntInserir)
                            .addComponent(bntLimpar)
                            .addComponent(btnUpdate)
                            .addComponent(btnDeletar)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //carregas os dados na jPosto quando abrir o formulario
        //criar sql
        String sql = "SELECT * FROM tb_posto ORDER BY idposto DESC";
        
        // chamando o metodo para povoar a jPosto
        povoarJPosto(sql);
        limparcampo();
        
    }//GEN-LAST:event_formWindowActivated

    private void jPanel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel1AncestorAdded
        txtCodPosto.setEnabled(false);
    }//GEN-LAST:event_jPanel1AncestorAdded

    private void txtEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoKeyPressed

    private void bntInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntInserirActionPerformed
        // instanciando a classe Posto do pacote modelo e criando seu objeto posto
        Posto posto1 = new Posto();

        posto1.setNome(txtNome.getText());
        posto1.setRua(txtRua.getText());
        posto1.setBairro(txtBairro.getText());
        //teste para verificar null
        if(!txtNumero.getText().equals(""))
          {
            posto1.setNumero(Integer.parseInt(txtNumero.getText()));
          }else
           posto1.setNumero(Integer.parseInt("0"));
        
        if (!txtCEP.getText().equals(""))
            posto1.setCep(Integer.parseInt(txtCEP.getText()));
          else
            posto1.setCep(Integer.parseInt("0"));
              
        posto1.setTel(txtTEL.getText());
        posto1.setCidade(txtCidade.getText());
        posto1.setEstado(txtEstado.getText());
        
        if (!txtLongitude.getText().equals(""))
            posto1.setLongitude(Float.parseFloat(txtLongitude.getText()));
          else
            posto1.setLongitude(Float.parseFloat("0"));
         
        if (!txtLatitude.getText().equals(""))
            posto1.setLatitude(Float.parseFloat(txtLatitude.getText()));
          else
            posto1.setLatitude(Float.parseFloat("0"));
              
        if ((txtNome.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Campo Descrição é necessário!");
        }
        else {

            // instanciando a classe GasDAO do pacote dao e criando seu objeto dao
            PostoDAO dao = new PostoDAO();
            dao.adiciona(posto1);
            JOptionPane.showMessageDialog(null, "Posto "+ txtNome.getText()+" inserido com sucesso! ");
            limparcampo();
        }

    }//GEN-LAST:event_bntInserirActionPerformed

    private void txtLatitudeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLatitudeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLatitudeKeyPressed

    private void txtLongitudeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLongitudeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLongitudeKeyPressed

    private void txtCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCidadeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeKeyPressed

    private void txtTELKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTELKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTELKeyPressed

    private void txtTELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTELActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTELActionPerformed

    private void txtCEPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCEPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCEPKeyPressed

    private void txtNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroKeyPressed

    private void txtRuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRuaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuaKeyPressed

    private void txtRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuaActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtCodPostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodPostoKeyPressed

    }//GEN-LAST:event_txtCodPostoKeyPressed

    private void bntVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntVoltarActionPerformed

        //telaPrincipal tela = new telaPrincipal();
       // tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_bntVoltarActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void bntLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLimparActionPerformed
        limparcampo();
    }//GEN-LAST:event_bntLimparActionPerformed

    private void jPostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPostoMouseClicked
        // passar os valor para os campos tfields
         limparcampo();
        int linha = jPosto.getSelectedRow();// selecionar a linha na jPosto
         txtCodPosto.setText(jPosto.getValueAt(linha,0).toString());
         txtNome.setText(jPosto.getValueAt(linha,1).toString());
         txtRua.setText(jPosto.getValueAt(linha,2).toString());
         txtBairro.setText(jPosto.getValueAt(linha,3).toString());
         txtNumero.setText(jPosto.getValueAt(linha,4).toString());
         txtCEP.setText(jPosto.getValueAt(linha,5).toString());
         txtTEL.setText(jPosto.getValueAt(linha,6).toString());
         txtCidade.setText(jPosto.getValueAt(linha,7).toString());
         txtEstado.setText(jPosto.getValueAt(linha,8).toString());
         txtLongitude.setText(jPosto.getValueAt(linha,9).toString());
         txtLatitude.setText(jPosto.getValueAt(linha,10).toString());
         btnUpdate.setVisible(true);
         btnDeletar.setVisible(true);
         bntInserir.setVisible(false);
         
    }//GEN-LAST:event_jPostoMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //alterando banco tabela posto
        // instanciando a classe Posto do pacote modelo e criando seu objeto posto
        Posto posto1 = new Posto();
        posto1.setIdposto(Integer.parseInt(txtCodPosto.getText()));
        posto1.setNome(txtNome.getText());
        posto1.setRua(txtRua.getText());
         posto1.setBairro(txtBairro.getText());
        //teste para verificar null
        if(!txtNumero.getText().equals(""))
          {
            posto1.setNumero(Integer.parseInt(txtNumero.getText()));
          }else
           posto1.setNumero(Integer.parseInt("0"));
        
        if (!txtCEP.getText().equals(""))
            posto1.setCep(Integer.parseInt(txtCEP.getText()));
          else
            posto1.setCep(Integer.parseInt("0"));
              
        posto1.setTel(txtTEL.getText());
        posto1.setCidade(txtCidade.getText());
        posto1.setEstado(txtEstado.getText());
        
        if (!txtLongitude.getText().equals(""))
            posto1.setLongitude(Float.parseFloat(txtLongitude.getText()));
          else
            posto1.setLongitude(Float.parseFloat("0"));
         
        if (!txtLatitude.getText().equals(""))
            posto1.setLatitude(Float.parseFloat(txtLatitude.getText()));
          else
            posto1.setLatitude(Float.parseFloat("0"));
              
        if ((txtNome.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Campo Descrição é necessário!");
        }
        else {

            // instanciando a classe GasDAO do pacote dao e criando seu objeto dao
            PostoDAO dao = new PostoDAO();
            dao.alterar(posto1);
            JOptionPane.showMessageDialog(null, "Posto "+ txtNome.getText()+" alterado com sucesso! ");
            limparcampo();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
       //deletando banco tabela posto
        // instanciando a classe Posto do pacote modelo e criando seu objeto posto
        Posto posto1 = new Posto();
        posto1.setIdposto(Integer.parseInt(txtCodPosto.getText()));
        // instanciando a classe GasDAO do pacote dao e criando seu objeto dao
            PostoDAO dao = new PostoDAO();
            dao.deletar(posto1);
            JOptionPane.showMessageDialog(null, "POSTO DELETADO!");
            limparcampo();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroKeyPressed

    /**
     * @param args the command line arguments
     */
    public void limparcampo()
    {
        // limpar campos
        txtCodPosto.setText("");
        txtNome.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtCEP.setText("");
        txtTEL.setText(""); 
        txtBairro.setText("");
        txtLongitude.setText("");
        txtLatitude.setText("");
        btnUpdate.setVisible(false);
        bntInserir.setVisible(true);
        btnDeletar.setVisible(false);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaCadastroPosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCadastroPosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCadastroPosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCadastroPosto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCadastroPosto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntInserir;
    private javax.swing.JButton bntLimpar;
    private javax.swing.JButton bntVoltar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jPosto;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodPosto;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLatitude;
    private javax.swing.JTextField txtLongitude;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTEL;
    // End of variables declaration//GEN-END:variables
}
