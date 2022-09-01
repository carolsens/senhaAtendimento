/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Atendimento;
import util.ConnectionFactory;

/**
 *
 * @author Carolina
 */
public class AtendimentoController {
    
    public void creat(Atendimento atendimento) {
        
        String sql = "INSERT INTO atendimento "
                + "(nome, "
                + "data, "
                + "atendimento, "
                + "status) "
                + "VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, atendimento.getNome());
            statement.setDate(2, new Date(atendimento.getDataSenha().getTime()));
            statement.setDate(3, new Date(atendimento.getDataAtendimento().getTime()));
            statement.setInt(4, atendimento.getStatus());         
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar o "
                    + "atendimento " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Atendimento> list() {
        
        String sql = "SELECT * FROM atendimento";
         
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Atendimento> atendimentos = new ArrayList<>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            
            Atendimento atendimento = new Atendimento();
            
            atendimento.setId(resultSet.getInt("id"));
            atendimento.setNome(resultSet.getString("Nome"));
            atendimento.setDataSenha(resultSet.getDate("data"));
            atendimento.setDataSenha(resultSet.getDate("atendimento"));
            atendimento.setStatus(resultSet.getInt("status"));
                        
            atendimentos.add(atendimento);
        }            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao listar "
                    + "atendimento(s) " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return atendimentos;
    }
    
    public void edit(Atendimento atendimento) {
        
        String sql = "UPDATE atendimento SET "
                + "nome = ?, "
                + "data = ?, "
                + "atendimento = ?, "
                + "status = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, atendimento.getNome());
            statement.setDate(2, new Date(atendimento.getDataSenha().getTime()));
            statement.setDate(3, new Date(atendimento.getDataAtendimento().getTime()));
            statement.setInt(4, atendimento.getStatus());   
            statement.setInt(5, atendimento.getId());   
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao editar o "
                    + "atendimento " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void delet(int atendimentoId) {
        
        String sql = "DELET FROM atendimento WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, atendimentoId);
            statement.execute();            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar "
                    + "atendimento " + ex.getMessage(), ex);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
