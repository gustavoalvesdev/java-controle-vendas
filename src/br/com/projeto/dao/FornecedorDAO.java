/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.Fornecedor;
import br.com.projeto.model.Funcionario;
import br.com.projeto.model.WebServiceCep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class FornecedorDAO {

    private Connection con;
    private String tabela = "tb_fornecedores";

    public FornecedorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarFornecedor(Fornecedor obj) {

        String sql = "INSERT INTO tb_fornecedores (nome, cnpj, email, celular, telefone, cep, endereco, numero, bairro, cidade, complemento, estado) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getCelular());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getBairro());
            stmt.setString(10, obj.getCidade());
            stmt.setString(11, obj.getComplemento());
            stmt.setString(12, obj.getUf());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + erro.getMessage());
        }

    }

    public List<Fornecedor> listarFornecedor() {

        try {

            List<Fornecedor> lista = new ArrayList<>();

            String sql = "SELECT * FROM " + tabela;

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor obj = new Fornecedor();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar fornecedores: " + e.getMessage());
            return null;
        }

    }

    public void excluirFornecedor(int id) {
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

    public void alterarFornecedor(Fornecedor obj) {
        String sql = "UPDATE " + tabela + " SET nome = ?, cnpj = ?, email = ?, telefone = ?, celular = ?, cep = ?, endereco = ?, numero = ?"
                + ", complemento = ?, bairro = ?, cidade = ?, estado = ? WHERE id = ?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getUf());
            stmt.setInt(13, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + erro.getMessage());
        }
    }

    public Fornecedor consultaPorCnpj(String cnpj) {

        try {

            String sql = "SELECT * FROM " + tabela + " WHERE cnpj = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cnpj);

            ResultSet rs = stmt.executeQuery();

            Fornecedor obj = new Fornecedor();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                return obj;

            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar por CNPJ: " + e.getMessage());
        }

        return null;
    }

    public List<Fornecedor> pesquisaFornecedoresPorNome(String nome) {
        try {

            List<Fornecedor> lista = new ArrayList<>();

            String sql = "SELECT * FROM " + tabela + " WHERE nome LIKE ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Fornecedor obj = new Fornecedor();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar fornecedores: " + e.getMessage());
            return null;
        }
    }

    // Método buscarFornecedorPorNome
    public Fornecedor buscarFornecedorPorNome(String nome) {
        Fornecedor fornecedor = null;

        try {
            String sql = "SELECT * FROM " + tabela + " WHERE nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCelular(rs.getString("celular"));
                fornecedor.setCep(rs.getString("cep"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getInt("numero"));
                fornecedor.setComplemento(rs.getString("complemento"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setUf(rs.getString("estado"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor: " + e.getMessage());
        }

        return fornecedor;
    }
    
    public boolean verificarSeFornecedorTemProduto(int forId) {
        
        try {
            String sql = "SELECT * FROM tb_produtos WHERE for_id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, forId);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor: " + e.getMessage());
        }
        
        return false;
    }

}
