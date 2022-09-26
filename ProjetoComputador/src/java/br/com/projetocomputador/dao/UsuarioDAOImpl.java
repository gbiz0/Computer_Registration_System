package br.com.projetocomputador.dao;

import br.com.projetocomputador.model.Usuario;
import br.com.projetocomputador.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gbiz0
 */
public class UsuarioDAOImpl implements GenericDAO{
    private Connection conn;

    public UsuarioDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        String sql = "Insert into usuario(nomeusuario, emailusuario, senhausuario) values (?, ?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getEmailUsuario());
            stmt.setString(3, usuario.getSenhaUsuario());

            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar usuario! Erro: " + ex.getMessage());
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

    public Object logarUsuario (String login, String senha) throws SQLException {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        String sql = "select * from usuario where emailusuario = ? and senhausuario = ?;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
        
        while (rs.next()){
            usuario = new Usuario();
            
            usuario.setNomeUsuario(rs.getString("nomeusuario"));
            usuario.setEmailUsuario(rs.getString("emailusuario"));
            usuario.setSenhaUsuario(rs.getString("senhausuario"));
        }
      }catch (SQLException ex) {
            System.out.println("Problemas ao acessar usuário! Erro:" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }  
        return usuario;
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

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

