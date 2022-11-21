/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Cliente;
import Model.Comandas;
import Model.Produtos;
import Model.Vendas;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author samue
 */
public class ComandaDao {
    
    
    //primeiro criar uma variavel do tipo Connection
    private Connection con;

    public ComandaDao() {
        //depois instanciar a variavel como um objeto da classe connectiofactory
        //e que receba o metodo de conexão getConnection
        this.con = new ConnectionFactory().getConnection();
    }
    public void CriarTabelaComanda(String nome) throws SQLException{
        
        String sql =  
                "create table IF NOT EXISTS " + nome + "(id int (10)primary key, nome varchar(50), quantidade int(100), preco Double, precoFinal Double);";
        
        Statement stmt;
        stmt = con.createStatement();
        stmt.execute(sql);
        
        JOptionPane.showMessageDialog(null, "Comanda cadastrada com sucesso");
    
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void CriarTabela() throws SQLException{
        String nome = "venda";
        String sql =  
                "create table IF NOT EXISTS " + nome + "(id int (10)primary key, nome varchar(50),nome_cl varchar(50),data Date,cpf_cl varchar(20), quantidade int(100), preco Double, precoFinal Double);";
        
        Statement stmt;
        stmt = con.createStatement();
        stmt.execute(sql);
        
        JOptionPane.showMessageDialog(null, "Comanda cadastrada com sucesso");
    
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void AdicionarAComanda(String nome, String comanda, int qtd) throws SQLException{
        String sql = "select id_prod,nome,preco from produto where nome = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
         ResultSet rs = stmt.executeQuery();
         
         Produtos prod = new Produtos();
         
         if(rs.next()){
             prod.setId(rs.getInt("id_prod"));
             prod.setNome(rs.getString("nome"));
             prod.setPreco(rs.getDouble("preco"));
         }
         
         String sql2 = "insert into "+ comanda +"(id, nome, quantidade, preco , precoFinal) values (?,?,?,?,?)";
         
         PreparedStatement insert = con.prepareStatement(sql2);
         
         Comandas com = new Comandas();
         com.setId(prod.getId());
         com.setNome(prod.getNome());
         com.setQuantidade(qtd);
         com.setPreco(prod.getPreco());
         com.setPrecoFinal(prod.getPreco() * qtd);
         insert.setInt(1, com.getId());
         insert.setString(2, com.getNome());
         insert.setInt(3, com.getQuantidade());
         insert.setDouble(4, com.getPreco());
         insert.setDouble(5, com.getPrecoFinal());
         
         stmt.execute();
         stmt.close();
         insert.execute();
         insert.close();
         
    }
    ///////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    
    public List<Comandas> listaDeItens(String nome) throws SQLException{
        List<Comandas> lista = new ArrayList<>();
        
        String sql = "select * from " + nome;
        
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Comandas com = new Comandas();
            
            com.setId(rs.getInt("id"));
            com.setNome(rs.getString("nome"));
            com.setQuantidade(rs.getInt("quantidade"));
            com.setPreco(rs.getDouble("preco"));
            com.setPrecoFinal(rs.getDouble("precoFinal"));
            
            lista.add(com);
        }
        
        
        return lista;
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
     public  Cliente consultaPorNome(String nome) {
        try {
            String sql = "select nome,cpf from cliente where nome = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Cliente cl = new Cliente();
            if (rs.next()) {
                                
                cl.setNome(rs.getString("nome"));
                cl.setCpf(rs.getString("cpf"));              
            }
            return cl;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
 ///////////////////////////////////////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////////////////////////////////
     public Double Total(String nome) throws SQLException{
         String sql = "select sum(precoFinal) from " + nome;
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
         
         Vendas ven = new Vendas();
         
         if (rs.next()){
             ven.setTotal(rs.getDouble("sum(precoFinal)"));
         }
         return ven.getTotal();
     }
     ///////////////////////////////////////////////////////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////////////////////////////////////////////
     
     public void limpar(String nome){
         try {
            String truncate = "truncate table " + nome;
            
            PreparedStatement stmt = con.prepareStatement(truncate);
            stmt.execute();
            stmt.close();
         } catch (Exception e) {
         }
     }
     //////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////
     
     public void updateComanda(Comandas c,String nome) throws SQLException{
         
         String update = "update "+ nome +" set nome=?,quantidade=?,precoFinal=? where id=?";
         
         PreparedStatement stmt = con.prepareStatement(update);
         
         int qtd = c.getQuantidade();
         stmt.setString(1, c.getNome());
         stmt.setInt(2, c.getQuantidade());
         stmt.setDouble(3, c.getPrecoFinal() * qtd);
         stmt.setInt(4, c.getId());
         
         stmt.execute();
         stmt.close();
         
     }
     
     public void deleteItem(Comandas c,String nome) throws SQLException{
         
         String delete = "delete from " + nome + " where id=?";
         
         PreparedStatement stmt = con.prepareStatement(delete);
         
         stmt.setInt(1, c.getId());
         
         stmt.execute();
         stmt.close();
         
     }
     
    
}