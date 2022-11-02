/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.SQLException;

/**
 *
 * @author samue
 */
public class NewClass {
    public static void main(String[] args) throws SQLException {
        ComandaDao dao = new ComandaDao ();
        dao.CriarTabela();
    }
}
