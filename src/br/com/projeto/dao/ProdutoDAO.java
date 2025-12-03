package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedor;
import br.com.projeto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    private Connection con;
    
    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrar(Produto obj) {
        try {
            
            String sql = "INSERT INTO tb_produtos (descricao, preco, qtd_estoque, for_id) VALUES (?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtdEstoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!!!");
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Produto: " + e.getMessage());
        }
    }
    
    public List<Produto> listarProdutos() {
        
        try {
            
            List<Produto> lista = new ArrayList<>();
            
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "FROM tb_produtos as p INNER JOIN tb_fornecedores AS f ON (p.for_id = f.id) ORDER BY p.id";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto obj = new Produto();
                Fornecedor f = new Fornecedor();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + erro.getMessage());
            return null;
        }
        
    }
    
    public void alterar(Produto obj) {
        
        try {
            
            String sql = "UPDATE tb_produtos SET descricao = ?, preco = ?, qtd_estoque = ?, for_id = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtdEstoque());
            
            stmt.setInt(4, obj.getFornecedor().getId());
            
            stmt.setInt(5, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");
            
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Produto: " + erro.getMessage());
        }
        
    }
    
    public void excluirProduto(int id) {
        String sql = "DELETE FROM tb_produtos WHERE id = ?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto Excluído com Sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Produto: " + erro.getMessage());
        }
    }
    
    // Método buscar produtos por nome
    public List<Produto> listarProdutosPorNome(String nome) {
        
        try {
            
            List<Produto> lista = new ArrayList<>();
            
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "FROM tb_produtos as p INNER JOIN tb_fornecedores AS f ON (p.for_id = f.id) where p.descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto obj = new Produto();
                Fornecedor f = new Fornecedor();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            
            return lista;
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + erro.getMessage());
            return null;
        }
        
    }
    
    public Produto consultaPorNome(String nome) {
        
        try {
            
            Produto obj = new Produto();
            
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "FROM tb_produtos as p INNER JOIN tb_fornecedores AS f ON " 
                    + "(p.for_id = f.id) where p.descricao = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
      
                Fornecedor f = new Fornecedor();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                
            }
            
            return obj;
            
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + erro.getMessage());
            return null;
        }
        
    }
}
