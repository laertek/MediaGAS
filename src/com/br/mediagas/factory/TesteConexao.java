/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mediagas.factory;

import java.sql.Connection; 
import java.sql.SQLException; 
/**
 *
 * @author TSVM
 */
public class TesteConexao {
     public static void main(String[] args) throws SQLException {
         Connection connection = new ConnectionFactory().getConnection();
         System.out.println("Conexão aberta!");
         connection.close();
     }
}
