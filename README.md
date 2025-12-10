# 🛒 Sistema de Gestão de Pedidos (Order Management System)

Este é um projeto simples em Java focado em **Programação Orientada a Objetos (POO)**, demonstrando conceitos fundamentais como **Associação**, **Composição** e o uso da API moderna de datas (`java.time`).

O objetivo é simular o processo de registro de um pedido, desde a entrada dos dados do cliente e a seleção dos produtos até o cálculo do valor total e a geração de um resumo formatado.

---

## 🚀 Funcionalidades

O programa principal (`Main`) permite:

1.  **Entrada de Dados do Cliente:** Coleta nome, e-mail e data de nascimento (com validação de formato `DD/MM/YYYY`).
2.  **Registro do Pedido:** Cria o pedido associando-o ao cliente e definindo o momento e o status.
3.  **Composição de Itens:** Adiciona múltiplos produtos e suas quantidades ao pedido.
4.  **Cálculo de Subtotal e Total:** Calcula o valor de cada linha (`ItemPedido`) e o valor final do pedido (`Pedido.total()`).
5.  **Geração de Resumo:** Imprime um resumo completo da transação (`ORDER SUMMARY`), usando formatação específica.

---

## 🛠️ Estrutura do Projeto (Classes e Associações)

O projeto é dividido nas seguintes entidades, refletindo as relações de Cardinalidade (1:1, 1:N) e Composição:

### 📦 Entidades Core

| Classe | Papel | Associações Importantes |
| :--- | :--- | :--- |
| **`Pedido`** | Classe central (Agregador) | **Composição** com `List<ItemPedido>` / **Associação** com `Cliente` |
| **`ItemPedido`** | Detalhe da linha de compra | **Associação** com `Produto` (1:1) |
| **`Cliente`** | Entidade com dados cadastrais | **Associação** com `Pedido` (1:1 no escopo deste projeto) |
| **`Produto`** | Item vendido | Associado ao `ItemPedido` |

### 🚩 Enumeração

| Enum | Descrição |
| :--- | :--- |
| **`StatusPedido`** | Define os estados possíveis de um pedido (ex: `PROCESSING`, `SHIPPED`, etc.). |

---

## ⚙️ Como Executar

1.  **Pré-requisitos:** Certifique-se de ter o **Java 8** ou superior instalado (devido ao uso da API `java.time`).
2.  **Estrutura de Pastas:** Mantenha as classes de entidade dentro do pacote `entities` (ou `entities.enums` para o StatusPedido).
3.  **Execução:** Compile e execute a classe principal (`Main`). O programa solicitará interativamente todos os dados via `Scanner`.

### Exemplo de Interação:
