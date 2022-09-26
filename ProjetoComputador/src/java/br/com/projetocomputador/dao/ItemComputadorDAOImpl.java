package br.com.projetocomputador.dao;

import br.com.projetocomputador.model.Item;
import br.com.projetocomputador.model.Computador;
import br.com.projetocomputador.model.ItemComputador;
import br.com.projetocomputador.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gbiz0
 */
public class ItemComputadorDAOImpl implements GenericDAO {

    private Connection conn;

    public ItemComputadorDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        ItemComputador itemcomputador = (ItemComputador) object;
        PreparedStatement stmt = null;

        String sql = "Insert into itemcomputador(idcomputador, iditem) values (?, ?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, itemcomputador.getIdComputador().getIdComputador());
            stmt.setInt(2, itemcomputador.getIdItem().getIdItem());
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

    public List<Object> ListarItem(int idObject) {
        List<Object> itens = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String sql = "select ic.iditem, c.idcomputador, i.nomeitem from item i, computadores c, itemcomputador ic where ic.idcomputador = c.idcomputador and ic.iditem = i.iditem and c.idcomputador = ?;";

       try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
                while (rs.next()) {
                    Item item = new Item();
                    item.setIdItem(rs.getInt("iditem"));
                    item.setNomeItem(rs.getString("nomeitem"));
                    itens.add(item);
                }
            } catch (Exception ex) {
            System.out.println("Problemas ao listar item! Erro:" + ex.getMessage());
            ex.printStackTrace();



       } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro" + e.getMessage());
                e.printStackTrace();
            }
        }
        return itens;
    }

    @Override
    public Boolean excluir(int idOject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
