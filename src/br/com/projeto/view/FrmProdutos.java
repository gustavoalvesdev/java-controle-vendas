/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.view;

import br.com.projeto.dao.ClienteDAO;
import br.com.projeto.dao.FornecedorDAO;
import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.Fornecedor;
import br.com.projeto.model.Produto;
import br.com.projeto.model.Utilitarios;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Gustavo
 */
public class FrmProdutos extends javax.swing.JFrame {

    public void listar() {

        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.listarClientes();
        DefaultTableModel dados = (DefaultTableModel) jTblConsultaProduto.getModel();
        dados.setNumRows(0);

        for (Cliente c : lista) {

            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getRg(),
                c.getCpf(),
                c.getEmail(),
                c.getCelular(),
                c.getTelefone(),
                c.getCep(),
                c.getEndereco(),
                c.getNumero(),
                c.getBairro(),
                c.getCidade(),
                c.getComplemento(),
                c.getUf()
            });

        }
    }

    /**
     * Creates new form FrmClientes
     */
    public FrmProdutos() {
        initComponents();

        
//        try {
//            Utilitarios.converteEmMaiusculo(jtfNome);
//            Utilitarios.converteEmMaiusculo(jtfEmail);
//            Utilitarios.converteEmMaiusculo(jTfEndereco);
//            Utilitarios.converteEmMaiusculo(jTfNumero);
//            Utilitarios.converteEmMaiusculo(jTfBairro);
//            Utilitarios.converteEmMaiusculo(jTfCidade);
//            Utilitarios.converteEmMaiusculo(jTfComplemento);
//        } catch(NullPointerException e) {
//            JOptionPane.showMessageDialog(null, "Falha ao Gerar Dados!");
//        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTpClientes = new javax.swing.JTabbedPane();
        jPnCadastro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfQtdEstoque = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbFornecedor = new javax.swing.JComboBox();
        jBtnPesquisar = new javax.swing.JButton();
        jtfPreco = new javax.swing.JTextField();
        jPnConsulta = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jtfConsultaNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblConsultaProduto = new javax.swing.JTable();
        jBtnNovo = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Produtos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPnCadastro.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código:");

        jtfCodigo.setEditable(false);
        jtfCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descrição:");

        jtfDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Preço:");

        jtfQtdEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Qtd. Estoque:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Fornecedor:");

        jcbFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbFornecedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jcbFornecedorAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/search-24.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jtfPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPnCadastroLayout = new javax.swing.GroupLayout(jPnCadastro);
        jPnCadastro.setLayout(jPnCadastroLayout);
        jPnCadastroLayout.setHorizontalGroup(
            jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnCadastroLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnCadastroLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPnCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(jcbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPnCadastroLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(276, 276, 276)))
                    .addGroup(jPnCadastroLayout.createSequentialGroup()
                        .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPnCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPnCadastroLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtfQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnPesquisar)))
                .addContainerGap())
        );
        jPnCadastroLayout.setVerticalGroup(
            jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnCadastroLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnCadastroLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnCadastroLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnCadastroLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel3))
                            .addComponent(jBtnPesquisar)))
                    .addGroup(jPnCadastroLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jtfQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jcbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTpClientes.addTab("Dados do Produto", jPnCadastro);

        jPnConsulta.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Pesquisar por Nome:");

        jtfConsultaNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfConsultaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfConsultaNomeKeyPressed(evt);
            }
        });

        jTblConsultaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço", "Qtd. Estoque", "Fornecedor"
            }
        ));
        jTblConsultaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblConsultaProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblConsultaProduto);

        javax.swing.GroupLayout jPnConsultaLayout = new javax.swing.GroupLayout(jPnConsulta);
        jPnConsulta.setLayout(jPnConsultaLayout);
        jPnConsultaLayout.setHorizontalGroup(
            jPnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                    .addGroup(jPnConsultaLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPnConsultaLayout.setVerticalGroup(
            jPnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jtfConsultaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTpClientes.addTab("Consulta de Produtos", jPnConsulta);

        jBtnNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/new-32.png"))); // NOI18N
        jBtnNovo.setText("NOVO");
        jBtnNovo.setEnabled(false);
        jBtnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNovoActionPerformed(evt);
            }
        });

        jBtnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/save-32.png"))); // NOI18N
        jBtnSalvar.setText("SALVAR");
        jBtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarActionPerformed(evt);
            }
        });

        jBtnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit-32.png"))); // NOI18N
        jBtnEditar.setText("EDITAR");
        jBtnEditar.setEnabled(false);
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jBtnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete-32.png"))); // NOI18N
        jBtnExcluir.setText("EXCLUIR");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTpClientes)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSalvar)
                .addGap(18, 18, 18)
                .addComponent(jBtnEditar)
                .addGap(18, 18, 18)
                .addComponent(jBtnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtnEditar, jBtnExcluir, jBtnNovo, jBtnSalvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTpClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnSalvar)
                        .addComponent(jBtnEditar)
                        .addComponent(jBtnExcluir)))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtnEditar, jBtnExcluir, jBtnNovo, jBtnSalvar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jBtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarActionPerformed
        try {

            Produto obj = new Produto();
            
            // DESCRIÇÃO
            if (!"".equals(jtfDescricao.getText())) {
                obj.setDescricao(jtfDescricao.getText());
            }
            
            // PREÇO
            if (!"".equals(jtfPreco.getText())) {
                obj.setPreco(Double.valueOf(jtfPreco.getText()));
            }
            
            
            // QTD ESTOQUE
            if (!"".equals(jtfQtdEstoque.getText())) {
                obj.setQtdEstoque(Integer.valueOf(jtfQtdEstoque.getText()));
            }
            
            
            // FORNECEDOR
            if (!"".equals(jcbFornecedor.getSelectedItem().toString())) {
                obj.setFornecedor((Fornecedor)jcbFornecedor.getSelectedItem());
            }

            ProdutoDAO dao = new ProdutoDAO();
            dao.cadastrar(obj);

            new Utilitarios().limpaTela(jPnCadastro);
            
            jBtnSalvar.setEnabled(false);
            jBtnEditar.setEnabled(false);
            jBtnExcluir.setEnabled(false);
            jBtnNovo.setEnabled(true);

            jtfDescricao.setEnabled(false);

            jtfQtdEstoque.setEnabled(false);

            jcbFornecedor.setEnabled(false);
            
        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao receber dados para cadastro: Preencha corretamente os campos");
        } 
    }//GEN-LAST:event_jBtnSalvarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listar();
    }//GEN-LAST:event_formWindowActivated

    private void jTblConsultaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblConsultaProdutoMouseClicked

        // Pega os dados
        try {
            jTpClientes.setSelectedIndex(0);
            jtfCodigo.setText(jTblConsultaProduto.getValueAt(jTblConsultaProduto.getSelectedRow(), 0).toString());
            jtfDescricao.setText(jTblConsultaProduto.getValueAt(jTblConsultaProduto.getSelectedRow(), 1).toString());
         
            jtfQtdEstoque.setText(jTblConsultaProduto.getValueAt(jTblConsultaProduto.getSelectedRow(), 4).toString());
    
            jcbFornecedor.setSelectedItem(jTblConsultaProduto.getValueAt(jTblConsultaProduto.getSelectedRow(), 13).toString());
            
            jtfDescricao.setEnabled(true);

            jtfQtdEstoque.setEnabled(true);

            jcbFornecedor.setEnabled(true);
            jBtnPesquisar.setEnabled(true);

            jBtnNovo.setEnabled(true);
            jBtnEditar.setEnabled(true);
            jBtnExcluir.setEnabled(true);
            jBtnSalvar.setEnabled(false);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada!");
        }

    }//GEN-LAST:event_jTblConsultaProdutoMouseClicked

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        try {

            Cliente obj = new Cliente();
            obj.setNome(jtfDescricao.getText());
 
            obj.setEmail(jtfQtdEstoque.getText());
  
            obj.setUf(jcbFornecedor.getSelectedItem().toString());
            obj.setId(Integer.valueOf(jtfCodigo.getText()));

            ClienteDAO dao = new ClienteDAO();
            dao.alterarCliente(obj);

            new Utilitarios().limpaTela(jPnCadastro);
            
            jtfDescricao.setEnabled(false);

            jtfQtdEstoque.setEnabled(false);

            jcbFornecedor.setEnabled(false);
            jBtnPesquisar.setEnabled(false);

            jBtnSalvar.setEnabled(false);
            jBtnEditar.setEnabled(false);
            jBtnExcluir.setEnabled(false);
            jBtnNovo.setEnabled(true);

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao receber dados para alteração: " + erro.getMessage());
        }
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        try {

            int id = Integer.valueOf(jtfCodigo.getText());

            ClienteDAO dao = new ClienteDAO();
            dao.excluirCliente(id);

            new Utilitarios().limpaTela(jPnCadastro);
            
            jtfDescricao.setEnabled(false);
 
            jtfQtdEstoque.setEnabled(false);

            jcbFornecedor.setEnabled(false);
            jBtnPesquisar.setEnabled(false);

            jBtnSalvar.setEnabled(false);
            jBtnEditar.setEnabled(false);
            jBtnExcluir.setEnabled(false);
            jBtnNovo.setEnabled(true);

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(null, "Falha ao receber dados para exclusão: " + erro.getMessage());
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jtfConsultaNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfConsultaNomeKeyPressed
        // Botão pesquisar

        String nome = jtfConsultaNome.getText();

        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.buscarClientPorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) jTblConsultaProduto.getModel();
        dados.setNumRows(0);

        for (Cliente c : lista) {

            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getRg(),
                c.getCpf(),
                c.getEmail(),
                c.getCelular(),
                c.getTelefone(),
                c.getCep(),
                c.getEndereco(),
                c.getNumero(),
                c.getBairro(),
                c.getCidade(),
                c.getComplemento(),
                c.getUf()
            });

        }
    }//GEN-LAST:event_jtfConsultaNomeKeyPressed

    private void jBtnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNovoActionPerformed
        new Utilitarios().limpaTela(jPnCadastro);

        jtfDescricao.requestFocus();
        jBtnNovo.setEnabled(false);
        jBtnSalvar.setEnabled(true);
        jBtnEditar.setEnabled(false);
        jBtnExcluir.setEnabled(false);

        jtfDescricao.setEnabled(true);
;
        jtfQtdEstoque.setEnabled(true);

        jcbFornecedor.setEnabled(true);
        jBtnPesquisar.setEnabled(true);
    }//GEN-LAST:event_jBtnNovoActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // Botão buscar por CPF


        Cliente obj = new Cliente();

        ClienteDAO dao = new ClienteDAO();


        if (obj != null) {
            // Exibir os dados nos campos de texto
            jtfCodigo.setText(String.valueOf(obj.getId()));
            jtfDescricao.setText(obj.getNome());

            jtfQtdEstoque.setText(obj.getEmail());
 
            jcbFornecedor.setSelectedItem(obj.getUf());
            
            jtfDescricao.setEnabled(true);
  
            jtfQtdEstoque.setEnabled(true);

            jcbFornecedor.setEnabled(true);
            jBtnPesquisar.setEnabled(true);
            
            jBtnEditar.setEnabled(true);
            jBtnExcluir.setEnabled(true);
            jBtnSalvar.setEnabled(false);
            jBtnNovo.setEnabled(true);
        }

        jtfDescricao.requestFocus();
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jcbFornecedorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jcbFornecedorAncestorAdded
        // Carregando ComboBox Fornecedores
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> listaDeFornecedores = dao.listarFornecedor();
        
        jcbFornecedor.removeAll();
        
        for (Fornecedor f : listaDeFornecedores) {
            jcbFornecedor.addItem(f);
        }
    }//GEN-LAST:event_jcbFornecedorAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnNovo;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPnCadastro;
    private javax.swing.JPanel jPnConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblConsultaProduto;
    private javax.swing.JTabbedPane jTpClientes;
    private javax.swing.JComboBox jcbFornecedor;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfConsultaNome;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfPreco;
    private javax.swing.JTextField jtfQtdEstoque;
    // End of variables declaration//GEN-END:variables
}
