package entities;


public class Produto {

    private String nomeproduto;
    private Double preco;

    // ------------------------------------------------------------------
    // 1. CONSTRUTORES
    // ------------------------------------------------------------------

    public Produto() {
    }

    public Produto(String nomeproduto, Double preco) {
        this.nomeproduto = nomeproduto;
        this.preco = preco;
    }


    public String getNomeproduto() {
        return nomeproduto;
    }

    public Double getPreco() {
        return preco;
    }

    // ------------------------------------------------------------------
    // 3. SETTERS (Para modificar os valores)
    // ------------------------------------------------------------------

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}