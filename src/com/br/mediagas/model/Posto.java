/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.mediagas.model;

/**
 *
 * @author TSVM
 */
public class Posto {
    public static int idposto;
    public static String nome;
    public static String rua;
    public static int numero;
    public static int cep;
    public static String tel;
    public static String cidade;
    public static String bairro;
    public static String estado;
    public static float longitude;
    public static float latitude;

    public static String getBairro() {
        return bairro;
    }

    public static void setBairro(String bairro) {
        Posto.bairro = bairro;
    }

    public static int getCep() {
        return cep;
    }

    public static void setCep(int cep) {
        Posto.cep = cep;
    }

    public static int getIdposto() {
        return idposto;
    }

    public static void setIdposto(int idposto) {
        Posto.idposto = idposto;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Posto.nome = nome;
    }

    public static String getRua() {
        return rua;
    }

    public static void setRua(String rua) {
        Posto.rua = rua;
    }

    public static int getNumero() {
        return numero;
    }

    public static void setNumero(int numero) {
        Posto.numero = numero;
    }

    public static String getTel() {
        return tel;
    }

    public static void setTel(String tel) {
        Posto.tel = tel;
    }

    public static String getCidade() {
        return cidade;
    }

    public static void setCidade(String cidade) {
        Posto.cidade = cidade;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        Posto.estado = estado;
    }

    public static float getLongitude() {
        return longitude;
    }

    public static void setLongitude(float longitude) {
        Posto.longitude = longitude;
    }

    public static float getLatitude() {
        return latitude;
    }

    public static void setLatitude(float latitude) {
        Posto.latitude = latitude;
    }

    
    
}
