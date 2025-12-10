package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Para formatar no toString()
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private LocalDateTime horacompra;
    private entities.StatusPedido status;

    // CORREÇÃO 2: Associação com Cliente
    private Cliente cliente;

    // CORREÇÃO 1: Inicialização da Lista (Composição)
    private List<ItemPedido> itemspedidos = new ArrayList<>();

    // ------------------------------------------------------------------
    // CONSTRUTORES
    // ------------------------------------------------------------------

    public Pedido() {
    }

    // Construtor COMPLETO: Deve incluir o Cliente
    public Pedido(LocalDateTime horacompra, StatusPedido status, Cliente cliente) {
        this.horacompra = horacompra;
        this.status = status;
        this.cliente = cliente;
    }

    // ------------------------------------------------------------------
    // MÉTODOS DE COMPOSIÇÃO (ADD/REMOVE)
    // ------------------------------------------------------------------

    public void addItem(ItemPedido item) {
        itemspedidos.add(item);
    }

    public void removeItem(ItemPedido item) {
        itemspedidos.remove(item);
    }

    // ------------------------------------------------------------------
    // MÉTODOS LÓGICOS (total)
    // ------------------------------------------------------------------

    // CORREÇÃO 3: Calcula o valor Total do Pedido
    public Double total() {
        double sum = 0.0;
        for (ItemPedido item : itemspedidos) {
            sum += item.subTotal(); // Chama o subTotal() implementado em ItemPedido
        }
        return sum;
    }

    // ------------------------------------------------------------------
    // REPRESENTAÇÃO TEXTUAL (toString para o resumo)
    // ------------------------------------------------------------------

    @Override
    public String toString() {
        // Formatadores para a data e hora
        DateTimeFormatter fmtHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmtAniversario = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ").append(horacompra.format(fmtHora)).append("\n");
        sb.append("Order status: ").append(status).append("\n");

        // Exibe os dados do Cliente (usando o objeto Cliente associado)
        sb.append("Client: ")
                .append(cliente.getNomecliente())
                .append(" (").append(cliente.getAniversario().format(fmtAniversario)).append(")")
                .append(" - ").append(cliente.getGmailcliente()).append("\n");

        sb.append("Order items:\n");

        // Itera sobre a lista de itens, usando o toString() de ItemPedido
        for (ItemPedido item : itemspedidos) {
            sb.append(item.toString()).append("\n");
        }

        sb.append("Total price: $").append(String.format("%.2f", total()));
        return sb.toString();
    }

    // ------------------------------------------------------------------
    // GETTERS & SETTERS
    // ------------------------------------------------------------------

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getHoracompra() {
        return horacompra;
    }
    // ... (restante dos getters/setters)
    // Note: Recomenda-se remover o setter da lista (setItemspedidos) para
    // manter a composição sob controle, usando apenas addItem/removeItem.
}