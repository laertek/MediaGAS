/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// situa em qual package ou "pacote" está a classe 
package com.br.mediagas.factory;

// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection; 
// conexão SQL para Java 
import java.sql.DriverManager; 
// driver de conexão SQL para Java 
import java.sql.SQLException; 
// classe para tratamento de exceções 

public class ConnectionFactory {

     public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_gas?useTimezone=true&serverTimezone=America/Sao_Paulo","teste","");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}


