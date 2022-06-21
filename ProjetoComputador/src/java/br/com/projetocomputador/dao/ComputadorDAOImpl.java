package br.com.projetocomputador.dao;

import br.com.projetocomputador.model.Computador;
import br.com.projetocomputador.model.TipoComputador;
import br.com.projetocomputador.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ComputadorDAOImpl implements GenericDAO{
    private Connection conn;

    public ComputadorDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    

    @Override
    public Boolean cadastrar(Object object) {
        
        Computador computador = (Computador) object;
        PreparedStatement stmt = null;
                
        String sql = "Insert into computadores(ssdcomputador, ramcomputador, idtipo, idproduto) values (?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, computador.getSsdComputador());
            stmt.setInt(2, computador.getRamComputador());
            stmt.setInt(3, computador.getIdTipo().getIdTipo());
            stmt.setInt(4, new ProdutoDAOImpl().cadastrar(computador));


            stmt.execute();
            return true;
        } catch (Exception ex) {
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
    public List<Object> listar() {
        List<Object> computadores = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "select c.*, p.*, tc.* from computadores c, produto p, tipo tc where c.idcomputador = p.idproduto and c.idtipo = tc.idtipo;";
        
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Computador computador = new Computador();
                computador.setIdComputador(rs.getInt("idcomputador"));
                computador.setFornecedorProduto(rs.getString("fornecedorproduto"));
                computador.setPrecoProduto(rs.getInt("precoproduto"));
                computador.setSsdComputador(rs.getInt("ssdcomputador"));
                computador.setRamComputador(rs.getInt("ramcomputador"));
                computador.setIdProduto(rs.getInt("idproduto"));
                computador.setIdTipo(new TipoComputador(rs.getInt("idtipo")));
                computador.setIdTipo(new TipoComputador(rs.getString("tipocomputador")));
                computadores.add(computador);
                        
            }
             } catch (SQLException ex) {
            System.out.println("Problemas ao listar computadores! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }  
        return computadores;
    }

    

    @Override
    public Boolean excluir(int idOject) {
        PreparedStatement stmt = null; 
        String sql = "delete from computadores where idproduto = ?;" 
                + "commit;"
                + "delete from produto where idproduto = ?;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idOject);
            stmt.setInt(2, idOject);
            stmt.executeUpdate();
            return true;
        }catch (Exception ex){
             System.out.println("Problemas ao listar computadores! Erro:" + ex.getMessage());
             ex.printStackTrace();
             return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch (Exception e){
              System.out.println("Problemas ao fechar conexão! Erro:" + e.getMessage());
              e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.*, p.* from computadores c, produto p where c.idproduto = p.idproduto and p.idproduto = ?;";
        Computador computador = new Computador();

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                computador = new Computador();
                computador.setIdComputador(rs.getInt("idcomputador"));
                computador.setFornecedorProduto(rs.getString("fornecedorproduto"));
                computador.setPrecoProduto(rs.getInt("precoproduto"));
                computador.setRamComputador(rs.getInt("ramcomputador"));
                computador.setSsdComputador(rs.getInt("ssdcomputador"));
                computador.setIdProduto(rs.getInt("idproduto"));
                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao alterar computadores! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return computador;
         
    }

    @Override
    public Boolean alterar(Object object) {
        Computador computador = (Computador) object;
        PreparedStatement stmt = null;
        String sql = "update computadores set ssdcomputador = ?, ramcomputador = ?"
                + "idproduto = ? where idtipo = ?;";
                    
       try {
           stmt = conn.prepareStatement(sql);
           stmt.setInt(1, computador.getSsdComputador());
           stmt.setInt(2, computador.getRamComputador());
           stmt.setInt(3, computador.getIdProduto());
           stmt.setInt(4, computador.getIdTipo().getIdTipo());
           
           if (new ProdutoDAOImpl().alterar(computador)){
               stmt.executeUpdate();
               return true;
           } else{
               return false;
           }
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
}
