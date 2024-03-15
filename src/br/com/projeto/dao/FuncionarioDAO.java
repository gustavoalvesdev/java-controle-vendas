/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import br.com.projeto.model.Funcionario;
import br.com.projeto.model.WebServiceCep;
import br.com.projeto.view.FrmMenu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class FuncionarioDAO {
    private Connection con;
    
    private String tabela = "tb_funcionarios";
    
    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarFuncionario(Funcionario obj) {
        
        String sql = "INSERT INTO " + tabela + " (nome, rg, cpf, email, senha, cargo, nivel_acesso, celular, telefone, cep, endereco, numero, bairro, cidade, complemento, estado) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getCelular());
            stmt.setString(9, obj.getTelefone());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getBairro());
            stmt.setString(14, obj.getCidade());
            stmt.setString(15, obj.getComplemento());
            stmt.setString(16, obj.getUf());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + erro.getMessage());
        }
        
    }
    
    public void alterarFuncionario(Funcionario obj) {
        String sql = "UPDATE " + tabela + " SET nome = ?, rg = ?, cpf = ?, email = ?, senha = ?, cargo = ?, nivel_acesso = ?, celular = ?, telefone = ?, cep = ?, endereco = ?, numero = ?"
                + ", bairro = ?, cidade = ?, complemento = ?, estado = ? WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getCelular());
            stmt.setString(9, obj.getTelefone());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getBairro());
            stmt.setString(14, obj.getCidade());
            stmt.setString(15, obj.getComplemento());
            stmt.setString(16, obj.getUf());
            stmt.setInt(17, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + erro.getMessage());
        }
    }
    
    public List<Funcionario> listarFuncionarios() {
        
        try {
            
            List<Funcionario> lista = new ArrayList<>();
            
            String sql = "SELECT * FROM " + tabela;
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Funcionario obj = new Funcionario();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionários: " + e.getMessage());
            return null;
        }
        
    }
    
    public Funcionario buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       

        Funcionario obj = new Funcionario();
        
        
        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } 
        
        return null;

    }
    
    public Funcionario consultaPorCpf(String cpf) {
    
        try {
            
            String sql = "SELECT * FROM " + tabela + " WHERE cpf = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            Funcionario obj = new Funcionario();
            
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
            }
            
            
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar por CPF: " + e.getMessage());
        }
        
        return null;
    }
    
    public List<Funcionario> buscarFuncionarioPorNome(String nome) {
        
        try {
            
            List<Funcionario> lista = new ArrayList<>();
            
            String sql = "SELECT * FROM " + tabela + " WHERE nome LIKE ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Funcionario obj = new Funcionario();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
            JOptionPane.showMessageDialog(null, "Erro ao listar funcionários: " + e.getMessage());
            return null;
        }
        
    }
    
    public void excluirFuncionario(int id) {
        String sql = "DELETE FROM " + tabela + " WHERE id = ?";
        
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
    
    public void efetuarLogin(String email, String senha) {
        try {
            
            String sql = "SELECT * FROM " + tabela + " WHERE email = ? AND senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            // Usuário conseguiu logar no sistema
            if (rs.next()) {
                
                JOptionPane.showMessageDialog(null, "Bem-vindo(a) ao sistema!");
                FrmMenu tela = new FrmMenu();
                tela.usuarioLogado = rs.getString("nome");
                tela.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorreto(s)!");
            }
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
