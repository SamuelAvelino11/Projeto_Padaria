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
        private Date data;
        private String cpf_cl;
        private int quantidade;
        private double preco;
        private double precoFinal;
        private double Total;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
