package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
