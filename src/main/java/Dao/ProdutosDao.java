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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class ProdutosDao {
    private Connection con;
    
    public ProdutosDao(){
     this.con = new ConnectionFactory().getConnection();
    }
    
    public void Cadastrar(Produtos prod){
    
    
         try {
            String sql = "insert into produto(nome, fabricacao, categoria, descricao,preco,quantidade,validade)"
                    + " values(?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, prod.getNome());
            stmt.setString(2, prod.getFabricação());
            stmt.setString(3, prod.getCategoria());
            stmt.setString(4, prod.getDescrição());
            stmt.setDouble(5, prod.getPreco());
            stmt.setInt(6, prod.getQuantidade());
            stmt.setString(7, prod.getValidade());
            

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
        
    }
     public List<Produtos> ListaDeProdutos() {
        try {
            List<Produtos> Lista;
            Lista = new ArrayList<>();

            String sql = "select * from produto";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos prod = new Produtos();

                prod.setId(rs.getInt("id_prod"));
                prod.setNome(rs.getString("nome"));
                prod.setFabricação(rs.getString("fabricacao"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescrição(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setValidade(rs.getString("validade"));
                

                Lista.add(prod);
            }
            return Lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }
    public void editarProduto(Produtos prod) throws SQLException {
        try {
            String sql = "update produto set nome=?, fabricacao=?, categoria=?, descricao=?, preco=?, quantidade=?, validade=?"
                    + "where id_prod=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, prod.getId());
            stmt.setString(2, prod.getNome());
            stmt.setString(3, prod.getFabricação());
            stmt.setString(4, prod.getCategoria());
            stmt.setString(5, prod.getDescrição());
            stmt.setDouble(6, prod.getPreco());
            stmt.setInt(7, prod.getQuantidade());
            stmt.setString(8, prod.getValidade());
            

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "errado: " + erro);
        }
    }
    public void excluirProdutos(Produtos prod) throws SQLException {
        try {
            String sql = "delete from produto where id_prod=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, prod.getId());

            stmt.execute();

            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "errado: " + erro);
        }
    }
    public List<Produtos> BuscarPorNome(String nome) {
        try {
            List<Produtos> lista = new ArrayList<>();

            String sql = "select id_prod,nome,fabricacao,categoria,descricao,preco,quantidade,validade from produto where nome like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            //recebe a execução do sql
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos prod = new Produtos();
                prod.setId(rs.getInt("id_prod"));
                prod.setNome(rs.getString("nome"));
                prod.setFabricação(rs.getString("fabricacao"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescrição(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setValidade(rs.getString("validade"));
               
               

                lista.add(prod);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }
    }
    public Produtos consultaPorNome(String nome) {
        try {
            String sql = "select id_prod,nome,fabricacao,categoria,descricao,preco,quantidade,validade from produto where nome = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Produtos prod = new Produtos();
            if (rs.next()) {

                prod.setId(rs.getInt("id_prod"));
                prod.setNome(rs.getString("nome"));
                prod.setFabricação(rs.getString("fabricacao"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setDescrição(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setValidade(rs.getString("validade"));

            }
            return prod;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
}
