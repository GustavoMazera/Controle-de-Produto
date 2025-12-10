package entities;

public class ItemPedido {

    private int quantidade;
    private Double preco;
    private Produto produto;

    // ------------------------------------------------------------------
    // CONSTRUTORES
    // ------------------------------------------------------------------

    public ItemPedido() {
    }

    public ItemPedido(int quantidade, Double preco, Produto produto) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }


    // Calcula o valor total desta linha do pedido
    public Double subTotal() {
        return preco * quantidade;
    }

    // ------------------------------------------------------------------
    // REPRESENTAÇÃO TEXTUAL (Para o Order Summary)
    // ------------------------------------------------------------------

    @Override
    public String toString() {
        // Formato: TV, $1000.00, Quantity: 1, Subtotal: $1000.00
        return produto.getNomeproduto()
                + ", $"
                + String.format("%.2f", preco)
                + ", Quantity: "
                + quantidade
                + ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }

    // ------------------------------------------------------------------
    // GETTERS E SETTERS
    // ------------------------------------------------------------------

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}