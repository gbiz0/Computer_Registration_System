package br.com.projetocomputador.model;

/**
 *
 * @author gbiz0
 */
public class Item {
    private Integer idItem;
    private String nomeItem;
    
    public Item() {
    }

    public Item(Integer idItem, String nomeItem) {
        this.idItem = idItem;
        this.nomeItem = nomeItem;
    }

    public Item(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public void add(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
