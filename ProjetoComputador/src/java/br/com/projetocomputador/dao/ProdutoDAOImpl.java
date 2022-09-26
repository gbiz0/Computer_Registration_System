package br.com.projetocomputador.dao;

import br.com.projetocomputador.model.Produto;
import br.com.projetocomputador.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProdutoDAOImpl implements GenericDAO {

    private Connection conn;

    public ProdutoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Integer cadastrar(Produto produto) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idProduto = null;

        String sql = "insert into produto(fornecedorproduto, precoproduto) values(?, ?) returning idproduto;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getFornecedorProduto());
            stmt.setInt(2, produto.getPrecoProduto());
            rs = stmt.executeQuery();

            if (rs.next()) {
                idProduto = rs.getInt("idproduto");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idProduto;
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int idOject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean alterar(Produto produto) {
        PreparedStatement stmt = null;
        String sql = "update produto set fornecedorproduto = ?, precoproduto = ? where idproduto = ?;";
                    
       try {
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, produto.getFornecedorProduto());
           stmt.setInt(2, produto.getPrecoProduto());
           stmt.setInt(3, produto.getIdProduto());
           stmt.executeUpdate();
           return true;

       }catch (Exception ex) {
            System.out.println("Problemas ao cadastrar computador! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
       }
    
        }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   }