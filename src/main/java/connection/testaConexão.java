/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class testaConexão {
    public static void main(String[] args) {
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null,"Conectado com sucesso");
            
        } catch (HeadlessException erro) {
            JOptionPane.showMessageDialog(null,"Ops aconteceu um erro: " + erro);
        }
    }
}
