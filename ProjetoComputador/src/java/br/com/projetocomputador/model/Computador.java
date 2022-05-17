package br.com.projetocomputador.model;


public class Computador extends Produto{
    private Integer idComputador;
    private Integer ssdComputador;
    private Integer ramComputador;
    private TipoComputador idTipo;

    public Computador() {
    }

    public Computador(Integer idComputador, Integer ssdComputador, Integer ramComputador, TipoComputador idTipo) {
        this.idComputador = idComputador;
        this.ssdComputador = ssdComputador;
        this.ramComputador = ramComputador;
        this.idTipo = idTipo;
    }

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }

    public Integer getSsdComputador() {
        return ssdComputador;
    }

    public void setSsdComputador(Integer ssdComputador) {
        this.ssdComputador = ssdComputador;
    }

    public Integer getRamComputador() {
        return ramComputador;
    }

    public void setRamComputador(Integer ramComputador) {
        this.ramComputador = ramComputador;
    }

    public TipoComputador getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoComputador idTipo) {
        this.idTipo = idTipo;
    }
 
}
