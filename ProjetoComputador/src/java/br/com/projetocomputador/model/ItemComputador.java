package br.com.projetocomputador.model;

/**
 *
 * @author gbiz0
 */
public class ItemComputador {
    private Computador idComputador;
    private Item idItem;

    public ItemComputador() {
    }

    public ItemComputador(Computador idComputador, Item idItem) {
        this.idComputador = idComputador;
        this.idItem = idItem;
    }

    public Computador getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Computador idComputador) {
        this.idComputador = idComputador;
    }

    public Item getIdItem() {
        return idItem;
    }

    public void setIdItem(Item idItem) {
        this.idItem = idItem;
    }

    
}
