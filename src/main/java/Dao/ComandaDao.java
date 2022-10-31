/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Produtos;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
        String sql = "use padaria;" + "drop table if exists " + nome + ";" + 
                "create table " + nome + "(id int (10)primary key, nome varchar(50), quantidade int(100), preco Double(5,2));";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        JOptionPane.showMessageDialog(null, "Comanda cadastrada com sucesso");
    
    }
    
    public void AdicionarAComanda(String nome, String comanda) throws SQLException{
        String sql = "select id_prod,nome,quantidade,preco from produto where nome = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
         ResultSet rs = stmt.executeQuery();
         
         Produtos prod = new Produtos();
         
         if(rs.next()){
             prod.setId(rs.getInt("id_prod"));
             prod.setNome(rs.getString("nome"));
             prod.setQuantidade(rs.getInt("quantidade"));
             prod.setPreco(rs.getDouble("preco"));
         }
         
    }
    
   /*public void cadastrarCliente(Cliente cl) {
        try {
            String sql = "insert into cliente (nome, idade, endereco, celular, cpf)"
                    + "values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cl.getNome());
            stmt.setInt(2, cl.getIdade());
            stmt.setString(3, cl.getEndereco());
            stmt.setString(4, cl.getCelular());
            stmt.setString(5, cl.getCpf());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cadastrado errado" + erro);
        }
    }*/
}
