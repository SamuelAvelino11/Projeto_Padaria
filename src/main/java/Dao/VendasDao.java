/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Vendas;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author samue
 */
public class VendasDao {
     private Connection con;

    public VendasDao() {
        
        this.con = new ConnectionFactory().getConnection();
    }
     
     
    
    public void SalvarVenda() throws SQLException{
    
        String sql = "insert into venda (nome,nome_cl,data,cpf_cl,quantidade,preco,precoFinal)"
                + "values(?,?,?,?,?,?,?)";
    
        PreparedStatement stmt = con.prepareStatement(sql);
        
        Vendas v = new Vendas(); 
        
        stmt.setString(1, v.getNome());
        stmt.setString(2, v.getNome_cl());
        stmt.setString(3, v.getData());
        stmt.setString(4, v.getCpf_cl());
        stmt.setInt(5, v.getQuantidade());
        stmt.setDouble(6, v.getPreco());
        stmt.setDouble(7, v.getPrecoFinal());
        
        stmt.execute();
        stmt.close();
    
    }
    
    
    
}
