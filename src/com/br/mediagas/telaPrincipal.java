
package com.br.mediagas;

import com.br.mediagas.dao.CotaDAO;
import com.br.mediagas.dao.GasDAO;
import com.br.mediagas.dao.PostoDAO;
import com.br.mediagas.factory.ConnectionFactory;
import com.br.mediagas.model.Cota;
import com.br.mediagas.model.Gas;
import com.br.mediagas.model.Posto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//importação para os graficos


import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.concurrent.TimeUnit;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author TSVM
 */
public class telaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipal
     */
    
    public telaPrincipal() {
        initComponents();
        // movimentar label 
       new Thread(){
           public void run()
           {
               int x = 400; 
               int y = jCorrer.getLocation().y;
               
               while(true){
                   x --;
                   if( x < - 100)
                   {
                       x=200;
                       //x=getWidth();                       
                   }
                   jCorrer.setLocation(x, y);
                  
                   try {
                       sleep(40);
                   }catch (Exception e){
                   
               }
               }
           }
           
           
       }.start();
       
       
         // movimentar label da cotação do Barril e Dólar
        new Thread(){
           public void run()
           {
               int x = 400; 
               int y = txtBarril.getLocation().y;
                int r = txtDolar.getLocation().y;
               while(true){
                   x --;
                   if( x < - 100)
                   {
                       x=200;
                       //x=getWidth();                       
                   }
                   txtBarril.setLocation(x, y);
                   txtDolar.setLocation(x, r);
                   try {
                       sleep(40);
                   }catch (Exception e){
                   
               }
               }
           }
                     
       }.start();
        
    }
   
    
    ///teste 21/05/2020
     // Preencher tabela jTableCota
    public void povoarjTableCota(String sql)
    {
          // conectar ao banco  
    
            Connection connection = new ConnectionFactory().getConnection();
            //System.out.println("Conexão aberta!");
            try
            {
                PreparedStatement stmt = connection.prepareCall(sql);
            
                ResultSet rs = stmt.executeQuery();
                DefaultTableModel model = (DefaultTableModel) jTableCota.getModel();
                model.setNumRows(0); //inicializar do primeiro elemento da tabela
                
                while(rs.next())
                 {
                     //teste data
                        Date minhaData = rs.getDate("data");
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        String data_formatada = formato.format(minhaData);		
						
                      model.addRow(new Object[]
                    {
                        rs.getInt("id_cota"),
                        //rs.getDate("data"),
                        data_formatada,
                        rs.getFloat("barril"),
                        rs.getFloat("dolar"),
                        rs.getString("custo"),
                        
                    });
                }
                
                
               //fechar banco 
               connection.close(); 
               //System.out.println("Conexão Fechar");
              
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível obter dados do banco. Erro:"+ex); 
            }
            
    }
    
    /// fim teste 21/05/2020
    //Preencher tabela JGas
    public void povoarJGas(String sqlgas)
    {
        // conectar ao banco  
    
            Connection connection = new ConnectionFactory().getConnection();
            //System.out.println("Conexão aberta!");
            try
            {
                PreparedStatement stmt = connection.prepareCall(sqlgas);
            
                ResultSet rs = stmt.executeQuery();
                DefaultTableModel model = (DefaultTableModel) jGas.getModel();
                model.setNumRows(0); // inicializar do primeiro elemento da tabela
                
                while(rs.next())
                 {
//                     //teste data
                       Date minhaData = rs.getDate("data");
                       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                       String data_formatada = formato.format(minhaData);
                       
                      model.addRow(new Object[]
                    {
                        rs.getInt("idgas"),
                        rs.getString("litro"),
                        rs.getString("km"),
                        rs.getString("valor"),
                        data_formatada,
                        rs.getFloat("media"),
                        rs.getFloat("custo"),
                        rs.getInt("idposto"),
                        rs.getString("tb_posto.nome"),
                   
                    });
                }
                
                
               //fechar banco 
               connection.close(); 
               //System.out.println("Conexão Fechar");
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível obter dados do banco. Erro:"+ex); 
            }
            
        
        
    }
    
    // povoar tablea JGas1 da Home
    
    public void povoarJGas1(String sqlgas)
    {
        // conectar ao banco  
    
            Connection connection = new ConnectionFactory().getConnection();
            //System.out.println("Conexão aberta!");
            try
            {
                PreparedStatement stmt = connection.prepareCall(sqlgas);
            
                ResultSet rs = stmt.executeQuery();
                DefaultTableModel model = (DefaultTableModel) jGas1.getModel();
                model.setNumRows(0); //inicializar do primeiro elemento da tabela
                
                while(rs.next())
                 {
//                     //teste data
                       Date minhaData = rs.getDate("data");
                       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                       String data_formatada = formato.format(minhaData);
                       
                      model.addRow(new Object[]
                    {
                        rs.getInt("idgas"),
                        rs.getString("litro"),
                        rs.getString("km"), "R$ " +
                        rs.getString("valor"),
                        data_formatada,
                        rs.getFloat("media"),
                        rs.getFloat("custo"),
                        rs.getString("tb_posto.nome"),
                   
                    });
                }
                
                
               //fechar banco 
               connection.close(); 
              // System.out.println("Conexão Fechar");
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível obter dados do banco. Erro:"+ex); 
            }
            
        
        
    }
    
    
    // fim 
 
    // Preencher tabela JPosto
    public void povoarJPosto(String sql)
    {
          // conectar ao banco  
    
            Connection connection = new ConnectionFactory().getConnection();
            //System.out.println("Conexão aberta!");
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
              // System.out.println("Conexão Fechar");
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível obter dados do banco. Erro:"+ex); 
            }
            
    }
    
    // povoar Jposto da tala Home
        
    // Preencher tabela JPosto
    public void povoarJPosto1(String sql)
    {
          // conectar ao banco  
    
            Connection connection = new ConnectionFactory().getConnection();
            //System.out.println("Conexão aberta!");
            try
            {
                PreparedStatement stmt = connection.prepareCall(sql);
            
                ResultSet rs = stmt.executeQuery();
                DefaultTableModel model = (DefaultTableModel) jPosto1.getModel();
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
               //System.out.println("Conexão Fechar");
              
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível obter dados do banco. Erro:"+ex); 
            }
            
    }
    
    
    // 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnG = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTAbas = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jGas1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPosto1 = new javax.swing.JTable();
        jInternalFrameGrafico = new javax.swing.JInternalFrame();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPosto2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jCorrer = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnDez = new javax.swing.JRadioButton();
        btnTodos = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtLitro = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        txtValor = new javax.swing.JTextField();
        txtKM = new javax.swing.JTextField();
        btnInserir = new javax.swing.JToggleButton();
        btnLimpar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtKMInicial = new javax.swing.JTextField();
        txtKMFinal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMedia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        bntCadastroPosto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPosto = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtPosto = new javax.swing.JTextField();
        txtPostoNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jGas = new javax.swing.JTable();
        txtCodGas = new javax.swing.JLabel();
        txtCodGas1 = new javax.swing.JLabel();
        jAlerta = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jPanelCotar = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtDataCota = new javax.swing.JFormattedTextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCota = new javax.swing.JTable();
        btnCota = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        jHome = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jAlerta3 = new javax.swing.JLabel();
        jAlerta2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtDolar = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtBarril = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1010, 619));
        setResizable(false);
        setSize(new java.awt.Dimension(1010, 619));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(1010, 619));
        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 619));

        jTAbas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAbasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTAbasMouseEntered(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jGas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Litros", "KMs", "Valor R$", "Data", "Média", "Custo", "Posto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jGas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jGas1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jGas1);
        if (jGas1.getColumnModel().getColumnCount() > 0) {
            jGas1.getColumnModel().getColumn(0).setMinWidth(40);
            jGas1.getColumnModel().getColumn(0).setMaxWidth(40);
            jGas1.getColumnModel().getColumn(1).setMinWidth(60);
            jGas1.getColumnModel().getColumn(1).setMaxWidth(60);
            jGas1.getColumnModel().getColumn(2).setMinWidth(80);
            jGas1.getColumnModel().getColumn(2).setMaxWidth(80);
            jGas1.getColumnModel().getColumn(3).setMinWidth(100);
            jGas1.getColumnModel().getColumn(3).setMaxWidth(100);
            jGas1.getColumnModel().getColumn(4).setMinWidth(80);
            jGas1.getColumnModel().getColumn(4).setMaxWidth(80);
            jGas1.getColumnModel().getColumn(5).setMinWidth(80);
            jGas1.getColumnModel().getColumn(5).setMaxWidth(80);
            jGas1.getColumnModel().getColumn(6).setMinWidth(90);
            jGas1.getColumnModel().getColumn(6).setPreferredWidth(90);
            jGas1.getColumnModel().getColumn(6).setMaxWidth(90);
        }

        jPosto1.setModel(new javax.swing.table.DefaultTableModel(
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
        jPosto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPosto1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jPosto1);
        if (jPosto1.getColumnModel().getColumnCount() > 0) {
            jPosto1.getColumnModel().getColumn(0).setMinWidth(35);
            jPosto1.getColumnModel().getColumn(0).setMaxWidth(35);
            jPosto1.getColumnModel().getColumn(1).setMinWidth(180);
            jPosto1.getColumnModel().getColumn(1).setMaxWidth(180);
            jPosto1.getColumnModel().getColumn(2).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(2).setMaxWidth(0);
            jPosto1.getColumnModel().getColumn(3).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(3).setMaxWidth(0);
            jPosto1.getColumnModel().getColumn(4).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(4).setMaxWidth(0);
            jPosto1.getColumnModel().getColumn(5).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(5).setMaxWidth(0);
            jPosto1.getColumnModel().getColumn(6).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(6).setMaxWidth(0);
            jPosto1.getColumnModel().getColumn(7).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(7).setMaxWidth(0);
            jPosto1.getColumnModel().getColumn(8).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(8).setMaxWidth(0);
            jPosto1.getColumnModel().getColumn(9).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(9).setMaxWidth(0);
            jPosto1.getColumnModel().getColumn(10).setMinWidth(0);
            jPosto1.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        jInternalFrameGrafico.setPreferredSize(new java.awt.Dimension(750, 400));
        jInternalFrameGrafico.setVisible(true);

        javax.swing.GroupLayout jInternalFrameGraficoLayout = new javax.swing.GroupLayout(jInternalFrameGrafico.getContentPane());
        jInternalFrameGrafico.getContentPane().setLayout(jInternalFrameGraficoLayout);
        jInternalFrameGraficoLayout.setHorizontalGroup(
            jInternalFrameGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jInternalFrameGraficoLayout.setVerticalGroup(
            jInternalFrameGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        jPosto2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Litros", "KMs", "Data", "Média", "Cod Posto", "Posto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jPosto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPosto2MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jPosto2);
        if (jPosto2.getColumnModel().getColumnCount() > 0) {
            jPosto2.getColumnModel().getColumn(0).setMinWidth(40);
            jPosto2.getColumnModel().getColumn(0).setMaxWidth(40);
            jPosto2.getColumnModel().getColumn(1).setMinWidth(60);
            jPosto2.getColumnModel().getColumn(1).setMaxWidth(60);
            jPosto2.getColumnModel().getColumn(2).setMinWidth(80);
            jPosto2.getColumnModel().getColumn(2).setMaxWidth(80);
            jPosto2.getColumnModel().getColumn(3).setMinWidth(80);
            jPosto2.getColumnModel().getColumn(3).setMaxWidth(80);
            jPosto2.getColumnModel().getColumn(4).setMinWidth(80);
            jPosto2.getColumnModel().getColumn(4).setMaxWidth(80);
            jPosto2.getColumnModel().getColumn(5).setMinWidth(70);
            jPosto2.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("   Posto:");
        jLabel18.setToolTipText("");
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jCorrer.setText(" Selecione o Posto para ver sua média:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCorrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCorrer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel20.setText(" Itens Gráfico:");
        jLabel20.setToolTipText("");
        jLabel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnG.add(btnDez);
        btnDez.setSelected(true);
        btnDez.setText("Mostrar Seis");

        btnG.add(btnTodos);
        btnTodos.setText("Mostrar Todos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jInternalFrameGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTodos)
                                    .addComponent(btnDez))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane7)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jInternalFrameGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDez)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTodos)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTAbas.addTab("Home", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setToolTipText("");
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Inserir Dados: Cronos");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Data");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("R$");
        jLabel4.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Litros");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("KM Total");

        txtLitro.setBackground(new java.awt.Color(245, 233, 233));
        txtLitro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtLitro.setToolTipText("Digite Quantidade Litros");
        txtLitro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLitroFocusGained(evt);
            }
        });

        txtData.setBackground(new java.awt.Color(245, 233, 233));
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtData.setToolTipText("Digite Data");
        txtData.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtValor.setBackground(new java.awt.Color(245, 233, 233));
        txtValor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtValor.setToolTipText("Digite Valor");
        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorFocusGained(evt);
            }
        });
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        txtKM.setBackground(new java.awt.Color(245, 233, 233));
        txtKM.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtKM.setToolTipText("Digite KM Total");
        txtKM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKMKeyPressed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("KM Inicial");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("KM Final");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtKMInicial.setBackground(new java.awt.Color(245, 233, 233));
        txtKMInicial.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtKMInicial.setToolTipText("Digite KM Inicial");
        txtKMInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKMInicialKeyPressed(evt);
            }
        });

        txtKMFinal.setBackground(new java.awt.Color(245, 233, 233));
        txtKMFinal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtKMFinal.setToolTipText("Digite KM Final");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("   Quilometragem:");
        jLabel14.setToolTipText("");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("KM / L");

        txtMedia.setBackground(new java.awt.Color(245, 233, 233));
        txtMedia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtMedia.setToolTipText("");
        txtMedia.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMediaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("    Postos Cadastrados:");
        jLabel16.setToolTipText("");
        jLabel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bntCadastroPosto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bntCadastroPosto.setText("Cadastrar / Alterar - Posto");
        bntCadastroPosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCadastroPostoActionPerformed(evt);
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
            jPosto.getColumnModel().getColumn(0).setMinWidth(35);
            jPosto.getColumnModel().getColumn(0).setMaxWidth(35);
            jPosto.getColumnModel().getColumn(1).setMinWidth(120);
            jPosto.getColumnModel().getColumn(1).setMaxWidth(120);
            jPosto.getColumnModel().getColumn(2).setMinWidth(100);
            jPosto.getColumnModel().getColumn(2).setMaxWidth(100);
            jPosto.getColumnModel().getColumn(3).setMinWidth(65);
            jPosto.getColumnModel().getColumn(3).setMaxWidth(65);
            jPosto.getColumnModel().getColumn(4).setMinWidth(55);
            jPosto.getColumnModel().getColumn(4).setMaxWidth(55);
            jPosto.getColumnModel().getColumn(5).setMinWidth(60);
            jPosto.getColumnModel().getColumn(5).setMaxWidth(60);
            jPosto.getColumnModel().getColumn(6).setMinWidth(100);
            jPosto.getColumnModel().getColumn(6).setMaxWidth(100);
            jPosto.getColumnModel().getColumn(9).setMinWidth(60);
            jPosto.getColumnModel().getColumn(9).setMaxWidth(60);
            jPosto.getColumnModel().getColumn(10).setMinWidth(60);
            jPosto.getColumnModel().getColumn(10).setMaxWidth(60);
        }

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Posto Selecionado");

        txtPosto.setBackground(new java.awt.Color(245, 233, 233));
        txtPosto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtPosto.setToolTipText("");
        txtPosto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPostoFocusGained(evt);
            }
        });

        txtPostoNome.setBackground(new java.awt.Color(245, 233, 233));
        txtPostoNome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtPostoNome.setToolTipText("");
        txtPostoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPostoNomeFocusGained(evt);
            }
        });

        jGas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Litros", "KMs", "Valor R$", "Data", "Média", "Custo", "CodPosto", "Posto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jGas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jGasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jGas);
        if (jGas.getColumnModel().getColumnCount() > 0) {
            jGas.getColumnModel().getColumn(0).setMinWidth(40);
            jGas.getColumnModel().getColumn(0).setMaxWidth(40);
            jGas.getColumnModel().getColumn(1).setMinWidth(50);
            jGas.getColumnModel().getColumn(1).setMaxWidth(50);
            jGas.getColumnModel().getColumn(2).setMinWidth(50);
            jGas.getColumnModel().getColumn(2).setMaxWidth(50);
            jGas.getColumnModel().getColumn(3).setMinWidth(60);
            jGas.getColumnModel().getColumn(3).setMaxWidth(60);
            jGas.getColumnModel().getColumn(7).setMinWidth(0);
            jGas.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        txtCodGas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtCodGas1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCodGas1.setText("Cod GAS");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCodGas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(146, 146, 146))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(520, 520, 520)
                                        .addComponent(jAlerta))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLitro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtKMInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCodGas1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel12)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtKMFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(179, 179, 179)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnInserir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAlterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeletar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLimpar))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPosto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPostoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))))
                        .addGap(4, 4, 4)
                        .addComponent(bntCadastroPosto, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodGas1)))
                            .addComponent(txtCodGas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtKMInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtKMFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtLitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGap(219, 219, 219)
                .addComponent(jAlerta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtPosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPostoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bntCadastroPosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnDeletar)
                    .addComponent(btnLimpar))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(296, 296, 296)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(99, Short.MAX_VALUE)))
        );

        jTAbas.addTab("Cadastro", jPanel3);

        jPanelCotar.setBackground(new java.awt.Color(204, 204, 204));
        jPanelCotar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelCotarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelCotarMouseEntered(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Cotação - Dólar & Barril.");
        jLabel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDataCota.setBackground(new java.awt.Color(204, 204, 255));
        txtDataCota.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataCota.setToolTipText("Digite Data");
        txtDataCota.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        label1.setForeground(new java.awt.Color(51, 51, 255));
        label1.setText("https://br.investing.com/commodities/brent-oil");

        label2.setText("Fonte / Site");

        jTableCota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Barril", "Dólar", "Custo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCota.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableCota);
        if (jTableCota.getColumnModel().getColumnCount() > 0) {
            jTableCota.getColumnModel().getColumn(0).setMinWidth(60);
            jTableCota.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableCota.getColumnModel().getColumn(1).setResizable(false);
            jTableCota.getColumnModel().getColumn(2).setResizable(false);
            jTableCota.getColumnModel().getColumn(3).setResizable(false);
            jTableCota.getColumnModel().getColumn(4).setResizable(false);
        }

        btnCota.setBackground(new java.awt.Color(102, 255, 255));
        btnCota.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCota.setLabel("Cotações");
        btnCota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCotarLayout = new javax.swing.GroupLayout(jPanelCotar);
        jPanelCotar.setLayout(jPanelCotarLayout);
        jPanelCotarLayout.setHorizontalGroup(
            jPanelCotarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCotarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCotarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCotarLayout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCotarLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCotarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCotarLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataCota, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCotarLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnCota, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanelCotarLayout.setVerticalGroup(
            jPanelCotarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCotarLayout.createSequentialGroup()
                .addGroup(jPanelCotarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCotarLayout.createSequentialGroup()
                        .addComponent(txtDataCota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanelCotarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel21.getAccessibleContext().setAccessibleName("Cotação - Dolar & Barril.");

        jTAbas.addTab("Cotação", jPanelCotar);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jHome.setText("Home");
        jHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));
        jPanel9.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 80)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MédiaGas ");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Desenvolvido por LFK Soft.");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Versão 1.2");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("e-mail: lfksoft@gmail.com");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Update - 03/06/2020");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("01/11/2019");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap(312, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addGap(33, 33, 33)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jHome)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jHome)
                .addContainerGap())
        );

        jTAbas.addTab("Sobre ", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 978, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        jTAbas.addTab("Sair", jPanel5);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cotação do Barril");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cotação do Dólar");
        jLabel9.setToolTipText("");
        jLabel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jAlerta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/mediagas/imagens/Alerta peq.gif"))); // NOI18N
        jAlerta3.setToolTipText("");
        jAlerta3.setMaximumSize(new java.awt.Dimension(96, 90));
        jAlerta3.setMinimumSize(new java.awt.Dimension(96, 90));

        jAlerta2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jAlerta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jAlerta2.setText("Selecione Posto!!!");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/mediagas/imagens/teste1.gif"))); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        txtDolar.setBackground(new java.awt.Color(245, 233, 233));
        txtDolar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDolar.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDolar, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(txtDolar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(158, 49));

        txtBarril.setBackground(new java.awt.Color(245, 233, 233));
        txtBarril.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBarril.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtBarril, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(txtBarril, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel8.setText("Versão 1.2");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTAbas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jAlerta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jAlerta2))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jAlerta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jAlerta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
            .addComponent(jTAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1172, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeActionPerformed
        jTAbas.setSelectedIndex(0);
    }//GEN-LAST:event_jHomeActionPerformed

    private void jTAbasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAbasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAbasMouseClicked

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        int op;
        
        op = JOptionPane.showConfirmDialog(null, "Deseja Sair?");
        
        if (op == 0)
        {
            System.exit(0);
        }
        else {
            jTAbas.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jTAbasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAbasMouseEntered
        txtKMFinal.setEnabled(false);
        txtMedia.setEnabled(false);
        txtData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
    }//GEN-LAST:event_jTAbasMouseEntered

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //carregar os dados na jPosto quando abrir o formulario
        //criar sql
        String sql = "SELECT * FROM tb_posto ORDER BY idposto DESC";
        
        // chamando o metodo para povoar a jPosto
        povoarJPosto(sql);
        
        String sqlgas = "SELECT tb_gas.idgas, tb_gas.litro, tb_gas.valor, tb_gas.km, tb_gas.data, tb_gas.media, tb_gas.custo, tb_gas.idposto, tb_posto.nome FROM tb_gas, tb_posto WHERE tb_gas.idposto = tb_posto.idposto ORDER BY tb_gas.data DESC";
        povoarJGas(sqlgas);
        
        //carregar 
        limparCampos();
        
       
    }//GEN-LAST:event_formWindowActivated

    private void jGas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jGas1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jGas1MouseClicked

    private void jPosto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPosto1MouseClicked
        // quando clicar na tabela do posto teremos a lista de posto abastecidas
        
        int linha1 = jPosto1.getSelectedRow(); //selecionar posto
       int codp = Integer.parseInt((String) jPosto1.getValueAt(linha1,0));
       // System.out.println("Codigo do posto "+ codp);
        String sql = "SELECT tb_gas.idgas, tb_gas.litro, tb_gas.km, tb_gas.data, tb_gas.media, tb_gas.idposto, tb_posto.nome FROM tb_gas, tb_posto WHERE tb_gas.idposto = tb_posto.idposto AND tb_gas.idposto='"+codp+"'";
        povoarJPosto2(sql);
        
    }//GEN-LAST:event_jPosto1MouseClicked

    public void povoarJPosto2(String sql)//preenchedo tabela Jposto2
    {
         Connection connection = new ConnectionFactory().getConnection();
            //System.out.println("Conexão aberta!");
            try
            {
                PreparedStatement stmt = connection.prepareCall(sql);
            
                ResultSet rs = stmt.executeQuery();
                DefaultTableModel model = (DefaultTableModel) jPosto2.getModel();
                model.setNumRows(0); // inicializar do primeiro elemento da tabela
                while(rs.next())
                 {
//                     //teste data
                       Date minhaData = rs.getDate("data");
                       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                       String data_formatada = formato.format(minhaData);
                       
                      model.addRow(new Object[]
                    {
                        rs.getInt("idgas"),
                        rs.getString("litro"),
                        rs.getString("km"),
                        data_formatada,
                        rs.getFloat("media"),
                        rs.getInt("idposto"),
                        rs.getString("nome"),
                   
                    });
                }
                
                
               //fechar banco 
               connection.close(); 
               
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível obter dados do banco. Erro:"+ex); 
            }
         
    }
          
            
    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // chamar tela de grafico
       grafico();
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPosto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPosto2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPosto2MouseClicked

    private void btnCotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCotaActionPerformed
        // Acionar contaçoes:
         carregarWeb();
        
    }//GEN-LAST:event_btnCotaActionPerformed

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseEntered

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // deletando na tabela GAS
        Gas gas2 = new Gas();
        gas2.setIdgas(Integer.parseInt(txtCodGas.getText()));

        System.out.println("ID posto " + txtCodGas.getText());
        GasDAO dao = new GasDAO();
        dao.deletar(gas2);

        JOptionPane.showMessageDialog(null, "DELETADO!");
        limparCampos();
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        //alterar dados
        //alterando banco tabela gas
        // instanciando a classe Posto do pacote modelo e criando seu objeto posto
        Gas gas1 = new Gas();
        gas1.setIdgas(Integer.parseInt(txtCodGas.getText()));

        gas1.setLitro(Float.parseFloat(txtLitro.getText()));
        gas1.setKm(Float.parseFloat(txtKM.getText()));
        ///tratamento data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            java.util.Date date = sdf.parse(txtData.getText());
            java.sql.Date dataSql = new java.sql.Date(date.getTime());
            gas1.setData(dataSql);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(gas1.toString()).log(Level.SEVERE, null, ex);

        }

        gas1.setValor(Float.parseFloat(txtValor.getText()));
        gas1.setMedia(Float.parseFloat(txtMedia.getText()));
        //Calcular Custo do Litro de Combustivel
        float t = 0;//adicionado
        if ((!txtValor.getText().trim().equals("")) && (!txtLitro.getText().trim().equals("")))
        {
            float r= Float.parseFloat(txtValor.getText());
            float s = Float.parseFloat(txtLitro.getText());

            t = r / s;

            gas1.setCusto(t);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Verifique os campos!!!");
        }
        gas1.setIdposto(Integer.parseInt(txtPosto.getText()));

        // instanciando a classe GasDAO do pacote dao e criando seu objeto dao
        GasDAO dao = new GasDAO();
        dao.alterar(gas1);
        JOptionPane.showMessageDialog(null, "Dados alterado para cod "+ txtCodGas.getText()+" com sucesso! ");
        limparCampos();

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void jGasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jGasMouseClicked
        // passar os valor para os campos tfields
        txtCodGas1.setVisible(true);
        txtCodGas.setVisible(true);
        int linha = jGas.getSelectedRow();// selecionar a linha na jPosto
        txtCodGas.setText(jGas.getValueAt(linha,0).toString());
        txtLitro.setText(jGas.getValueAt(linha,1).toString());

        txtKM.setText(jGas.getValueAt(linha,2).toString());
        txtValor.setText(jGas.getValueAt(linha,3).toString());
        txtData.setText(jGas.getValueAt(linha,4).toString());
        txtMedia.setText(jGas.getValueAt(linha,5).toString());
        txtPosto.setText(jGas.getValueAt(linha,7).toString());
        txtPostoNome.setText(jGas.getValueAt(linha,8).toString());//teste para pegar nome do posto
        int linha2 = (Integer.parseInt(txtPosto.getText()));

        // *** Campos
        btnInserir.setVisible(false);
        btnAlterar.setVisible(true);
        btnDeletar.setVisible(true);

    }//GEN-LAST:event_jGasMouseClicked

    private void txtPostoNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPostoNomeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPostoNomeFocusGained

    private void txtPostoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPostoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPostoFocusGained

    private void jPostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPostoMouseClicked
        // passar os valor para os campos tfields
        int linha = jPosto.getSelectedRow();// selecionar a linha na jPosto
        txtPosto.setText(jPosto.getValueAt(linha,0).toString());
        txtPostoNome.setText(jPosto.getValueAt(linha,1).toString());
        jAlerta3.setVisible(false);
        jAlerta2.setVisible(false);

    }//GEN-LAST:event_jPostoMouseClicked

    private void bntCadastroPostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCadastroPostoActionPerformed
        
        //new telaCadastroPosto().setVisible(true);
       telaPrincipal tela = new telaPrincipal();
       telaCadastroPosto tela1 = new telaCadastroPosto();
       tela.setVisible(false);
       tela1.setVisible(true);
       tela1.setFocusable(true);

    }//GEN-LAST:event_bntCadastroPostoActionPerformed

    private void txtMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMediaActionPerformed

    private void txtKMInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKMInicialKeyPressed
        txtKMFinal.setVisible(true);
        txtKMFinal.setEnabled(true);
        txtKM.setEnabled(false);
        txtMedia.setEnabled(false);
    }//GEN-LAST:event_txtKMInicialKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // instanciando a classe Gas do pacote modelo e criando seu objeto gas
        Gas gas1 = new Gas();

        gas1.setLitro(Float.parseFloat(txtLitro.getText()));
        gas1.setKm(Float.parseFloat(txtKM.getText()));
        gas1.setValor(Float.parseFloat(txtValor.getText()));
        gas1.setMedia(Float.parseFloat(txtMedia.getText()));

        //Calcular Custo do Litro de Combustivel
        float t = 0;//adicionado
        if ((!txtValor.getText().trim().equals("")) && (!txtLitro.getText().trim().equals("")))
        {
            float r= Float.parseFloat(txtValor.getText());
            float s = Float.parseFloat(txtLitro.getText());

            t = r / s;

            gas1.setCusto(t);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Verifique os campos!!!");
        }
       

        gas1.setIdposto(Integer.parseInt(txtPosto.getText()));
        //teste tratamento data

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try
        {
            java.util.Date date = sdf.parse(txtData.getText());
            java.sql.Date dataSql = new java.sql.Date(date.getTime());
            gas1.setData(dataSql);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(gas1.toString()).log(Level.SEVERE, null, ex);

        }

        if (txtPosto.getText().trim().equals(""))
        {
            System.out.println("Entrou na condição");
            JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
        }
        else {

            // instanciando a classe GasDAO do pacote dao e criando seu objeto dao
            GasDAO dao = new GasDAO();
            dao.adiciona(gas1);
            JOptionPane.showMessageDialog(null, "Media "+ txtMedia.getText()+" inserido com sucesso! " +" R$ "+ t +" Custo do Litro !!");
        }

        //formWindowActivated(java.awt.event.WindowEvent evt);
        limparCampos();
    }//GEN-LAST:event_btnInserirActionPerformed

    private void txtKMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKMKeyPressed
        txtKMFinal.setEnabled(false);
        txtKMInicial.setEnabled(false);
        //Libera alerta para selecionar posto
        jAlerta3.setVisible(true);
        jAlerta2.setVisible(true);
    }//GEN-LAST:event_txtKMKeyPressed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        System.out.println("Verificar se dados estao completo  ");
        /// Verifica se dados foi adionadados para calcular media
        if((!txtKM.getText().trim().equals("")) && (!txtLitro.getText().trim().equals("")))
        {
            System.out.println("Entrou no se  ");
            /// Calcular media
            float k = Float.parseFloat(txtKM.getText());
            float l = Float.parseFloat(txtLitro.getText());

            float r = k  / l;
            txtMedia.setText(String.valueOf(r));

        }
    }//GEN-LAST:event_txtValorFocusGained

    private void txtLitroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLitroFocusGained
        //Libera alerta para selecionar posto
        jAlerta3.setVisible(true);
        jAlerta2.setVisible(true);
        //calcular e verificar se temos valor

        
            if((txtKM.getText().trim().equals("")) && (!txtKMFinal.getText().trim().equals("")))
            {
                float i = Float.parseFloat(txtKMInicial.getText());
                float f = Float.parseFloat(txtKMFinal.getText());

                float x = f - i;
                txtKM.setText(String.valueOf(x));

            }
    }//GEN-LAST:event_txtLitroFocusGained

    private void jPanelCotarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCotarMouseEntered
        // TODO add your handling code here:
        txtDataCota.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
        txtDataCota.setEditable(false);
        
        //carregar os dados na jTableCota quando abrir o formulario
        //criar sql
       // String sql = "SELECT * FROM tb_cota";
        //String sql = "SELECT * FROM tb_cota order by data desc";
        //adicionando um campo custo abastecido
        
         // teste ok 
        String sql = "select c.id_cota, c.data, c.barril, c.dolar, g.custo from tb_cota c left join tb_gas g on g.data = c.data order by data desc";
        // String sql = "select c.id_cota, c.data, c.barril, c.dolar, IFNULL(g.custo,'Não abastecido!') from tb_cota c left join tb_gas g on g.data = c.data order by data desc";
         // chamando o metodo para 
        povoarjTableCota(sql);
        
        //System.out.println("Data do sistema: "+txtDataCota.getText());
        //System.out.println("Pegar dados da tabela: "+ jTableCota.getValueAt(0,1));
        String datasys = txtDataCota.getText();
        //String datatab = (String) jTableCota.getValueAt(0,1);
        //System.out.println("Data do sistema: "+datasys);
        //System.out.println("Data da tabela: "+datatab);
        if (datasys.equals(jTableCota.getValueAt(0,1)))
                {
                    //System.out.println("Data são iguais! ");
                    txtBarril.setText(jTableCota.getValueAt(0,2).toString());
                    txtDolar.setText(jTableCota.getValueAt(0,3).toString());
                    btnCota.setVisible(false);
                }  
        else{   
                txtBarril.setText(jTableCota.getValueAt(0,2).toString());
                txtDolar.setText(jTableCota.getValueAt(0,3).toString());
                btnCota.setVisible(true);
        }
        //jPosto1.getColumnModel().getColumn(10).setMaxWidth(0);
        
    }//GEN-LAST:event_jPanelCotarMouseEntered

    private void jPanelCotarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelCotarMouseClicked
      
    }//GEN-LAST:event_jPanelCotarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
    }//GEN-LAST:event_formWindowOpened
 
     
    //Gerando o grafico
    
    public void grafico()
    {
        
        
        //carregar os dados na jPosto1 quando abrir o formulario
        //criar sql
       
        String sql = "SELECT * FROM tb_posto ORDER BY idposto DESC";
        
        // chamando o metodo para povoar a jPosto
        povoarJPosto1(sql);
        
       
        
        //gas 
        String sqlgas = "SELECT tb_gas.idgas, tb_gas.litro, tb_gas.valor, tb_gas.km, tb_gas.data, tb_gas.media, tb_gas.custo, tb_posto.nome FROM tb_gas, tb_posto WHERE tb_gas.idposto = tb_posto.idposto ORDER BY tb_gas.data DESC";
        povoarJGas1(sqlgas);
        
           // ************cria o gráfico**********
           // Gerar Grafico 
           //gerar valor para grafico
        int j = jGas1.getRowCount();//retirar
        //System.out.println("Numero de linhas na tabela GAS1 " + j);//retirar
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //mudado para mostrar somente 10 ou todos no grafico
        //Alterado para seis ficou melhoro grafico
        if (btnDez.isSelected())
        {
        for (int linha=0; linha<6; linha ++)
            {
                Float media =(Float)jGas1.getValueAt(linha, 5);
                //System.out.println("Valor pego para media "+media);
                String data = (String) jGas1.getValueAt(linha, 4);
               // System.out.println("Valor pego para data "+data); 
                dataset.setValue(media, "Média", data);

            }
        } else
                {
                    for (int linha=0; linha<jGas1.getRowCount(); linha ++)
                    {
                        Float media =(Float)jGas1.getValueAt(linha, 5);
                        //System.out.println("Valor pego para media "+media);
                        String data = (String) jGas1.getValueAt(linha, 4);
                       // System.out.println("Valor pego para data "+data); 
                        dataset.setValue(media, "Média", data);

                    }
                }
           // segundo grafico
          // DefaultCategoryDataset dataset = new DefaultCategoryDataset();
          
           //System.out.println("Valor do !!!! = " + jPosto1.getValueAt(0, NORMAL));
            if (jPosto2.getRowCount() != 0){  
                for (int linha1=0; linha1<jPosto2.getRowCount(); linha1 ++)
                    {
                        Float media1 =(Float)jPosto2.getValueAt(linha1, 4);
                        String data1 = (String) jPosto2.getValueAt(linha1, 3);
                        dataset.setValue(media1, "Posto Selecionado",data1);

                    }
            }
           //JFreeChart chart = ChartFactory.createBarChart(" Media ", " Data ", "KM / Litro", dataset, PlotOrientation.VERTICAL, true, true, false);
          
           JFreeChart chart = ChartFactory.createBarChart(" Média - Fiat Cronos Precision 1.8 ", " Data ", "Km / Litro", dataset, PlotOrientation.VERTICAL, true, true, false);
           
           chart.setBackgroundPaint(Color.white);
           chart.getTitle().setPaint(Color.black);
           CategoryPlot p = chart.getCategoryPlot();
           p.setRangeGridlinePaint(Color.BLACK);
           ChartPanel chartPanel = new ChartPanel(chart);
             jInternalFrameGrafico.setContentPane((new ChartPanel(chart)));
             jInternalFrameGrafico.pack();
            
            jInternalFrameGrafico.setVisible(true);
            jInternalFrameGrafico.remove(1);
            jInternalFrameGrafico.repaint();
      
        
        //Fim Grafico 
        
}
    //Parte para pegar da WEB cotações do Dolar e do Barril
    public void carregarWeb()
    {
        System.setProperty("webdriver.gecko.driver", "D:\\CursoJava\\1 Biblioteca\\geckodriver-v0.25.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://br.investing.com/commodities/brent-oil");
        WebElement valor2 = driver.findElement(By.id("last_last"));
        
        String texto1 = valor2.getText();
      
       //teste para entrar na aba do cabio
       
       System.out.println("1");
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       
       System.out.println("2");
      //driver.findElement(By.linkText("Eu aceito")).click();
      driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    //btnAceita.click();
       driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
       System.out.println("3");
       WebElement btnCambio = driver.findElement(By.id("QBS_1"));
       btnCambio.click();
       
       
       WebElement valor1 = driver.findElement(By.id("sb_last_2103"));
       // WebElement valor1 = driver.findElement(By.id("TSB__summary_last_2103"));
      String texto = valor1.getText();
        
       System.out.println("Aqui");
        // ver valores 
        System.out.println("dados do Dolar "+ texto);
        System.out.println("dados do Barril "+ texto1);
        
        //replace(",",".") comando migra da virgula para o ponto
        // para pordemos inserir no banco
         //txtBarril.setText("$ " + texto1.replace(",","."));
         txtBarril.setText(texto1.replace(",","."));
        
        txtDolar.setText(texto.replace(",","."));
         btnCota.setVisible(false);
         driver.close();   
        
         
         /* inserindo dados coletados para o banco*/
        Cota cota1 = new Cota();

        cota1.setDolar(Float.parseFloat(txtDolar.getText()));
        cota1.setBarril(Float.parseFloat(txtBarril.getText()));
       
       // System.out.println("dados do Dolar "+ txtDolar.getText());
      //  System.out.println("dados do Barril "+ txtBarril.getText());
      //   System.out.println("indo para o acesso ao banco");
        // instanciando a classe CotaDAO do pacote dao e criando seu objeto dao
        CotaDAO dao = new CotaDAO();
        dao.adiciona(cota1);
        JOptionPane.showMessageDialog(null, "Cotação $"+ txtDolar.getText()+" inserido com sucesso! ");
        
        /*fim do acesso ao banco*/
    
          driver.quit();
    }
    
    
    public void limparCampos()
    {
        //txtCodigo.setText("");
        txtLitro.setText("");
        txtKM.setText("");
        txtKM.setEditable(true);
        txtKM.setVisible(true);
        txtValor.setText("");
        txtData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
        txtKMFinal.setText("");
        txtKMFinal.setEnabled(false);
        txtKMFinal.setVisible(true);
        txtKMInicial.setText("");
        txtKMInicial.setEnabled(true);
        txtMedia.setEnabled(false);
        txtMedia.setText("");
        txtPosto.setEnabled(false);
        txtPosto.setText("");
        txtPostoNome.setEnabled(false);
        txtPostoNome.setText("");
        btnInserir.setVisible(true);
        txtCodGas.setVisible(false);
        txtCodGas1.setVisible(false);
        jAlerta3.setVisible(false);
        jAlerta2.setVisible(false);
        btnAlterar.setVisible(false);
        btnDeletar.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCadastroPosto;
    private javax.swing.JButton btnAlterar;
    private java.awt.Button btnCota;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JRadioButton btnDez;
    private javax.swing.ButtonGroup btnG;
    private javax.swing.JToggleButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JRadioButton btnTodos;
    private javax.swing.JLabel jAlerta;
    private javax.swing.JLabel jAlerta2;
    private javax.swing.JLabel jAlerta3;
    private javax.swing.JLabel jCorrer;
    private javax.swing.JTable jGas;
    private javax.swing.JTable jGas1;
    private javax.swing.JButton jHome;
    private javax.swing.JInternalFrame jInternalFrameGrafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelCotar;
    private javax.swing.JTable jPosto;
    private javax.swing.JTable jPosto1;
    private javax.swing.JTable jPosto2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTAbas;
    private javax.swing.JTable jTableCota;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel txtBarril;
    private javax.swing.JLabel txtCodGas;
    private javax.swing.JLabel txtCodGas1;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtDataCota;
    private javax.swing.JLabel txtDolar;
    private javax.swing.JTextField txtKM;
    private javax.swing.JTextField txtKMFinal;
    private javax.swing.JTextField txtKMInicial;
    private javax.swing.JTextField txtLitro;
    private javax.swing.JTextField txtMedia;
    private javax.swing.JTextField txtPosto;
    private javax.swing.JTextField txtPostoNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
