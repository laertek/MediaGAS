/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mediagas.dao;

import com.br.mediagas.factory.ConnectionFactory;
import com.br.mediagas.model.Gas;
import com.br.mediagas.model.Posto;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author TSVM
 */
public class GasDAO {
    
    private Connection connection;
    int idgas;
    float litro;
    float valor;
    float km;
    Date data;
    float media;
    float custo;
    int idposto;
    public GasDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Gas gas){ 
        String sql = "INSERT INTO tb_gas(litro,km,data,valor,media,custo, idposto) VALUES(?,?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setFloat(1, gas.getLitro());
            stmt.setFloat(2, gas.getKm());
            stmt.setDate(3, gas.getData());
            stmt.setFloat(4, gas.getValor());
            stmt.setFloat(5, gas.getMedia());
            stmt.setFloat(6, gas.getCusto());
            stmt.setInt(7, gas.getIdposto());
            stmt.execute();
            stmt.close();
        } 
         catch (SQLException u) { 
                    //throw new RuntimeException(u);
                    JOptionPane.showMessageDialog(null, "Não foi inserir no banco!!! " + u);
        } 
        
    } 
    
 // metodo para alterar dados GAS
    public void alterar(Gas gas)
    {
    String sql = "UPDATE tb_gas SET litro = ?, km = ?, data = ?, valor = ?, media = ?,"
            + "custo = ?, idposto = ? WHERE idgas = ?";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setFloat(1, gas.getLitro());
                stmt.setFloat(2, gas.getKm());
                stmt.setDate(3, gas.getData());
                stmt.setFloat(4, gas.getValor());
                stmt.setFloat(5, gas.getMedia());
                stmt.setFloat(6, gas.getCusto());
                stmt.setInt(7, gas.getIdposto());
                stmt.setInt(8, gas.getIdgas());
                stmt.execute();
                stmt.close();
            }
            catch (SQLException u)
            { 
                    //throw new RuntimeException(u);
                    JOptionPane.showMessageDialog(null, "Não foi possível alterar do banco: " + u);
            }
            
            
            
    }
     
    
    //metodo para deletar 
    public void deletar(Gas gas)
    {
        String sql = "DELETE FROM tb_gas WHERE idgas = ?";
            try
            {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, gas.getIdgas());
                stmt.execute();
                stmt.close();    
            }
            catch(SQLException u) { 
                throw new RuntimeException(u);
            }
        
    }
    
}
    
    

