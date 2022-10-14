/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import connection.ConnectionFactory;
import Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class ClienteDao {

    //primeiro criar uma variavel do tipo Connection
    private Connection con;

    public ClienteDao() {
        //depois instanciar a variavel como um objeto da classe connectiofactory
        //e que receba o metodo de conexão getConnection
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarCliente(Cliente cl) {
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
    }

    public void alterarCliente(Cliente cl) throws SQLException {
        try {
            String sql = "update cliente set nome=?, idade=?, endereco=?, celular=?, cpf=?"
                    + "where id_cliente=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cl.getId());
            stmt.setString(2, cl.getNome());
            stmt.setInt(3, cl.getIdade());
            stmt.setString(4, cl.getEndereco());
            stmt.setString(5, cl.getCelular());
            stmt.setString(6, cl.getCpf());
            

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "errado: " + erro);
        }
    }

    public void excluirCliente(Cliente cl) throws SQLException {
        try {
            String sql = "delete from cliente where id_cliente=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cl.getId());
           

            stmt.execute();
            
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "errado: " + erro);
        }
    }

    public List<Cliente> listarClientes() {
        try {
            List<Cliente> lista = new ArrayList<>();

            String sql = "select * from cliente";

            PreparedStatement stmt = con.prepareStatement(sql);
            //recebe a execução do sql
            ResultSet rs = stmt.executeQuery();

            
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id_cliente"));
                cl.setNome(rs.getString("nome"));
                cl.setIdade(rs.getInt("idade"));
                cl.setEndereco(rs.getString("endereco"));
                cl.setCelular(rs.getString("celular"));
                cl.setCpf(rs.getString("cpf"));

                lista.add(cl);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }
    }
}
