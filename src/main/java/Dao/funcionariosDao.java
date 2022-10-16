/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.Funcionario;
import View.Tela_Menu;
import View.view_Funcionario;
import connection.ConnectionFactory;


/**
 *
 * @author samue
 */
public class funcionariosDao {
    private Connection con;
    
    public funcionariosDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void CadastrarFuncionario(Funcionario func){
        try {
            String sql = "insert into funcionarios values(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setLong(1, func.getId());
            stmt.setString(2, func.getNome());
            stmt.setInt(3, func.getIdade());
            stmt.setString(4, func.getEndereco());
            stmt.setString(5, func.getCelular());
            stmt.setString(6, func.getMatricula());
            stmt.setString(7, func.getRg());
             stmt.setString(8, func.getCpf());
             stmt.setString(9, func.getSenha());
                
                  
                   stmt.execute();
                   stmt.close();
                   
                   JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
                      
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    
    
    
    }
    
    public void Login(String nome, String senha){
        try {
            String sq1 = "select * from funcionario where nome = ? and senha = ?";
            
            PreparedStatement stmt = con.prepareStatement(sq1);
            
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Seja Bem Vindo");
                view_Funcionario tela = new view_Funcionario();
                tela.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Dados incorretos");
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            
            
        }
    
    }
    
    public List<Funcionario> ListaDeFuncionarios(){
        try {
            List<Funcionario> Lista;
            Lista = new ArrayList<>();
            
            String sql = "select * from funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            Funcionario func = new Funcionario();
            
            func.setId(rs.getInt("id"));
            func.setNome(rs.getString("nome"));
            func.setIdade(rs.getInt("idade"));
            func.setEndereco(rs.getString("endereco"));
            func.setCelular(rs.getString("celular"));
            func.setMatricula(rs.getString("matricula"));
            func.setRg(rs.getString("rg"));
            func.setCpf(rs.getString("cpf"));
            func.setSenha(rs.getString("senha"));
            
            Lista.add(func);
            }
            return Lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    
    }
    
}