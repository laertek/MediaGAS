/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mediagas.model;

import java.sql.Date;
/**
 *
 * @author Laerte
 */
public class Cota {
    public static int id_cota;
    public static Date data;
    public static float barril;
    public static float dolar;

    public static int getId_cota() {
        return id_cota;
    }

    public static void setId_cota(int id_cota) {
        Cota.id_cota = id_cota;
    }

    public static Date getData() {
        return data;
    }

    public static void setData(Date data) {
        Cota.data = data;
    }

    public static float getBarril() {
        return barril;
    }

    public static void setBarril(float barril) {
        Cota.barril = barril;
    }

    public static float getDolar() {
        return dolar;
    }

    public static void setDolar(float dolar) {
        Cota.dolar = dolar;
    }
   
    
}
