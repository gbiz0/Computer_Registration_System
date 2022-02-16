package br.com.projetocomputador.model;


public class Produto {
    private Integer idProduto;
    private String fornecedorProduto;
    private Integer precoProduto;

    public Produto() {
    }

    public Produto(Integer idProduto, String fornecedorProduto, Integer precoProduto) {
        this.idProduto = idProduto;
        this.fornecedorProduto = fornecedorProduto;
        this.precoProduto = precoProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getFornecedorProduto() {
        return fornecedorProduto;
    }

    public void setFornecedorProduto(String fornecedorProduto) {
        this.fornecedorProduto = fornecedorProduto;
    }

    public Integer getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Integer precoProduto) {
        this.precoProduto = precoProduto;
    }
    
}
