/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author samue
 */
public class Vendas {
    //id int (10)primary key, nome varchar(50),nome_cl varchar(50),data Date,cpf_cl varchar(20), quantidade int(100), preco Double, precoFinal Double)
        private int id;
        private String nome;
        private String nome_cl;
        private String data;
        private String cpf_cl;
        private int id_cl;
        private int id_prod;
        private int quantidade;
        private double preco;
        private double precoFinal;
        private double Total;

    public int getId_cl() {
        return id_cl;
    }

    public void setId_cl(int id_cl) {
        this.id_cl = id_cl;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

        
        
        
    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
        
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_cl() {
        return nome_cl;
    }

    public void setNome_cl(String nome_cl) {
        this.nome_cl = nome_cl;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCpf_cl() {
        return cpf_cl;
    }

    public void setCpf_cl(String cpf_cl) {
        this.cpf_cl = cpf_cl;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }
        
        
}
