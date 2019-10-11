/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mediagas.model;

import java.sql.Date;
/**
 *
 * @author TSVM
 */
public class Gas {
    
    public static int idgas;
    public static float litro;
    public static float valor;
    public static float km;
    public static Date data;
    public static float media;
    public static float custo;
    public static int idposto;

    public static int getIdposto() {
        return idposto;
    }

    public static void setIdposto(int idposto) {
        Gas.idposto = idposto;
    }

    
      public static float getLitro() {
        return litro;
    }

    public static void setLitro(float litro) {
        Gas.litro = litro;
    }
    
    public static int getIdgas() {
        return idgas;
    }

    public static void setIdgas(int idgas) {
        Gas.idgas = idgas;
    }


    public static float getValor() {
        return valor;
    }

    public static void setValor(float valor) {
        Gas.valor = valor;
    }

    public static float getKm() {
        return km;
    }

    public static void setKm(float km) {
        Gas.km = km;
    }

    public static Date getData() {
        return data;
    }

    public static void setData(Date data) {
        Gas.data = data;
    }

    public static float getMedia() {
        return media;
    }

    public static void setMedia(float media) {
        Gas.media = media;
    }

    public static float getCusto() {
        return custo;
    }

    public static void setCusto(float custo) {
        Gas.custo = custo;
    }

   
    
}
