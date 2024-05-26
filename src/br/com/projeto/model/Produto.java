package br.com.projeto.model;

public class Produto {
    
    private int id;
    private String descricao;
    private double preco;
    private int qtdEstoque;
    private Fornecedor fornecedor;
    
    public Produto() {
        id = 0;
        descricao = null;
        preco = 0.0;
        qtdEstoque = 0;
        fornecedor = null;
    }
    
    public Produto(int id, String descricao, double preco, int qtdEstoque, Fornecedor fornecedor) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.fornecedor = fornecedor;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
