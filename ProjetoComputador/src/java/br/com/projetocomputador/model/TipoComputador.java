package br.com.projetocomputador.model;

/**
 *
 * @author gbiz0
 */
public class TipoComputador {
    
    private Integer idTipo;
    private String tipoComputador;

    public TipoComputador() {
    }

    public TipoComputador(Integer idTipo, String tipoComputador) {
        this.idTipo = idTipo;
        this.tipoComputador = tipoComputador;
    }

    
    public TipoComputador(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoComputador(String tipoComputador) {
        this.tipoComputador = tipoComputador;
    }
    
    

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoComputador() {
        return tipoComputador;
    }

    public void setTipoComputador(String tipoComputador) {
        this.tipoComputador = tipoComputador;
    }

    
}
