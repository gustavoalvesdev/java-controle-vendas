/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class ClienteDAO {
    
    private Connection con;
    
    public ClienteDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarCliente(Cliente obj) {
        
        String sql = "INSERT INTO tb_clientes (nome, rg, cpf, email, celular, telefone, cep, endereco, numero, bairro, cidade, complemento, estado) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getTelefone());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getComplemento());
            stmt.setString(13, obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            
        } catch(SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Usuário já cadastrado!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + erro.getMessage());
        }
        
    }
    
    public void alterarCliente(Cliente obj) {
        String sql = "UPDATE tb_clientes SET nome = ?, rg = ?, cpf = ?, email = ?, celular = ?, telefone = ?, cep = ?, endereco = ?, numero = ?"
                + ", bairro = ?, cidade = ?, complemento = ?, estado = ? WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getTelefone());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getComplemento());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + erro.getMessage());
        }
    }
    
    public void excluirCliente(int id) {
        String sql = "DELETE FROM tb_clientes WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + erro.getMessage());
        }
    }
    
    public List<Cliente> listarClientes() {
        
        try {
            
            List<Cliente> lista = new ArrayList<>();
            
            String sql = "SELECT * FROM tb_clientes";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Cliente obj = new Cliente();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
            return null;
        }
        
    }
    
    // Método consultaCliente por CPF
    public Cliente consultaPorCpf(String cpf) {
    
        try {
            
            String sql = "SELECT * FROM tb_clientes WHERE cpf = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            Cliente obj = new Cliente();
            
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setUf(rs.getString("estado"));
                
                return obj;
                
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            }
            
            
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar por CPF: " + e.getMessage());
        }
        
        return null;
    }
    
    
    // Método buscarClientPorNome
    public List<Cliente> buscarClientPorNome(String nome) {
        
        try {
            
            List<Cliente> lista = new ArrayList<>();
            
            String sql = "SELECT * FROM tb_clientes WHERE nome LIKE ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Cliente obj = new Cliente();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage());
            return null;
        }
        
    }
    
    // Busca CEP
    
    public Cliente buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Cliente obj = new Cliente();
        
        
        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } 
        
        return null;

    }
}
