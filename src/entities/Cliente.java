package entities;

import java.time.LocalDate;


public class Cliente {

    private String nomecliente;
    private String gmailcliente;
    private LocalDate aniversario;
    private Pedido pedido;

    // 1. CONSTRUTORES

    // Construtor Padrão (Vazio)
    public Cliente(String nome, String gmail, LocalDate dataAniversario) {
    }

    // Construtor Completo (Com Todos os Atributos)
    public Cliente(String nomecliente, String gmailcliente, LocalDate aniversario, Pedido pedido) {
        this.nomecliente = nomecliente;
        this.gmailcliente = gmailcliente;
        this.aniversario = aniversario;
        this.pedido = pedido;
    }

    // ------------------------------------------------------------------
    // 2. GETTERS (Para acessar os valores dos atributos)
    // ------------------------------------------------------------------

    public String getNomecliente() {
        return nomecliente;
    }

    public String getGmailcliente() {
        return gmailcliente;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    // ------------------------------------------------------------------
    // 3. SETTERS (Para modificar os valores dos atributos)
    // ------------------------------------------------------------------

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public void setGmailcliente(String gmailcliente) {
        this.gmailcliente = gmailcliente;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
