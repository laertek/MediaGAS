/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mediagas.dao;

import com.br.mediagas.factory.ConnectionFactory;
import com.br.mediagas.model.Cota;
import com.br.mediagas.model.Posto;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author Laerte
 */
public class CotaDAO {
    
    private Connection connection;
    int id_cota;
    Date data;
    float barril;
    float dolar;
   
    public CotaDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Cota cota1){ 
        String sql = "INSERT INTO tb_cota(data,barril,dolar) VALUES(CURDATE(),?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            //stmt.setDate(1, cota1.getDate(new java.util.Date(System.currentTimeMillis())));
            stmt.setFloat(1, cota1.getBarril());
            stmt.setFloat(2, cota1.getDolar());
            stmt.execute();
            stmt.close();
        } 
         catch (SQLException u) { 
                    //throw new RuntimeException(u);
                    JOptionPane.showMessageDialog(null, "Não foi inserir no banco!!! " + u);
        }
    }
}
