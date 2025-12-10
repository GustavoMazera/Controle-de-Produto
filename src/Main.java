import entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Removido 'throws ParseException', SimpleDateFormat e imports desnecessários.

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatadorEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate aniversario = null;

        // --- 1. DADOS DO CLIENTE (Usando nextLine() para maior segurança) ---
        System.out.println("Nome do Cliente: ");
        String nome = sc.nextLine();

        System.out.println("Gmail do Cliente: ");
        String gmail = sc.nextLine();

        System.out.println("Digite a data no formato = DD/MM/YYYY");
        String dataString = sc.nextLine();

        try {
            aniversario = LocalDate.parse(dataString, formatadorEntrada);
        } catch (DateTimeParseException e) {
            System.err.println("ERRO: Formato de data inválido. Use DD/MM/YYYY.");
            sc.close();
            return; // Encerra o programa
        }

        // Instancia o Cliente (assumindo que o construtor é Cliente(nome, gmail, aniversario, null))
        Cliente cliente = new Cliente(nome, gmail, aniversario, null);

        // --- 2. DADOS DO PEDIDO ---
        System.out.println("Entre com seu pedido :");
        System.out.print("Status: ");

        // Converte a String de entrada para o ENUM StatusPedido
        String statusStr = sc.nextLine();
        StatusPedido status = StatusPedido.valueOf(statusStr);

        LocalDateTime horacompra = LocalDateTime.now();

        // Instancia o Pedido e associa o Cliente
        Pedido pedido = new Pedido(horacompra, status, cliente);
        cliente.setPedido(pedido); // Conexão bidirecional (Cliente -> Pedido)

        // --- 3. ITENS DO PEDIDO ---
        System.out.print("Quantos itens este pedido terá? ");
        int quantpedidos = sc.nextInt();
        sc.nextLine(); // CONSUMIR a quebra de linha após nextInt()

        for (int x = 0; x < quantpedidos; x++){
            System.out.println("--- Item #" + (x + 1) + " ---");

            System.out.print("Produto: ");
            String nomeproduto = sc.nextLine();

            System.out.print("Valor: ");
            Double valor = sc.nextDouble();

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            sc.nextLine(); // CONSUMIR a quebra de linha após nextInt()

            // Instancia o Produto
            Produto produto = new Produto(nomeproduto, valor);

            // Instancia o ItemPedido
            ItemPedido itempedido = new ItemPedido(quantidade, valor, produto);

            // ⚠️ CORREÇÃO CRÍTICA: Adiciona o ItemPedido à lista do objeto 'pedido'
            pedido.addItem(itempedido);
        }

        sc.close();

        // --- 4. EXIBIR RESUMO ---
        System.out.println("\n" + pedido);
    }
}