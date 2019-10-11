/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mediagas.dao;

import com.br.mediagas.factory.ConnectionFactory;
import com.br.mediagas.model.Posto;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
/**
 *
 * @author Laerte Fernandes Kertischka
 */


public class PostoDAO {
    
    private Connection connection;
    
    //Variaveis Posto
    int idposto;
    String nome;
    String rua;
    int numero;
    int cep;
    String tel;
    String bairro;
    String cidade;
    String estado;
    float longitude;
    float latidude;
    int cpf; 
    
    
    public PostoDAO(){
        this.connection = new ConnectionFactory().getConnection();
        
    }
    
    public void adiciona(Posto posto){
            String sql = "INSERT INTO tb_posto(nome, rua, bairro, numero, cep, tel, cidade, estado, longitude, latitude) VALUES(?,?,?,?,?,?,?,?,?,?)";
    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, posto.getNome());
            stmt.setString(2, posto.getRua());
            stmt.setString(3, posto.getBairro());
            stmt.setInt(4, posto.getNumero());
            stmt.setInt(5, posto.getCep());
            stmt.setString(6, posto.getTel());
            stmt.setString(7, posto.getCidade());
            stmt.setString(8, posto.getEstado());
            stmt.setFloat(9, posto.getLongitude());
            stmt.setFloat(10, posto.getLatitude());
            stmt.execute();
            stmt.close();
    }
    
    catch (SQLException u) { 
            throw new RuntimeException(u);
    }
}
    
      //método para alterar
    public void alterar(Posto posto)
    {
        String sql = "UPDATE tb_posto SET nome = ?, rua = ?, bairro = ?, numero = ?, cep= ?, tel= ?, cidade = ?, estado = ?, longitude = ?, latitude = ? WHERE idposto = ?";
        //, rua = ?, numero = ?, cep= ?, tel= ?, cidade = ?, estado = ?, longitude = ?, latitude = ?,
            try
            {
                PreparedStatement stmt1 = connection.prepareStatement(sql);
               // stmt.setInt(1, posto.getIdposto());
                stmt1.setString(1, posto.getNome());
                stmt1.setString(2, posto.getRua());
                stmt1.setString(3, posto.getBairro());
                stmt1.setInt(4, posto.getNumero());
                stmt1.setInt(5, posto.getCep());
                stmt1.setString(6, posto.getTel());
                stmt1.setString(7, posto.getCidade());
                stmt1.setString(8, posto.getEstado());
                stmt1.setFloat(9, posto.getLongitude());
                stmt1.setFloat(10, posto.getLatitude());
                stmt1.setInt(11, posto.getIdposto());
                stmt1.execute();
                stmt1.close();         


            }
                 catch (SQLException u) { 
                    //throw new RuntimeException(u);
                    JOptionPane.showMessageDialog(null, "Não foi possível alterar do banco: " + u);
            }
        
        
    }
     public void deletar(Posto posto)
    {
        String sql = "DELETE FROM tb_posto WHERE idposto = ?";
        //, rua = ?, numero = ?, cep= ?, tel= ?, cidade = ?, estado = ?, longitude = ?, latitude = ?,
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, posto.getIdposto());
//            stmt.setString(2, posto.getRua());
//            stmt.setInt(3, posto.getNumero());
//            stmt.setInt(4, posto.getCep());
//            stmt.setString(5, posto.getTel());
//            stmt.setString(6, posto.getCidade());
//            stmt.setString(7, posto.getEstado());
//            stmt.setFloat(8, posto.getLongitude());
//            stmt.setFloat(9, posto.getLatitude());
            stmt.execute();
            stmt.close();         
            
            
        }
         catch (SQLException u) { 
            throw new RuntimeException(u);
        }

}
}
