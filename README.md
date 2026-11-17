# 🍔 BurguerByte

Sistema de gerenciamento de cardápio e pedidos para hamburgueria desenvolvido em Java via terminal (CLI), aplicando conceitos fundamentais de Programação Orientada a Objetos (POO).

## 📋 Funcionalidades

- **Gerenciamento de Cardápio:**
  - Cadastro de produtos divididos em **Comidas** (com controle de peso em gramas) e **Bebidas** (com controle de volume em ml).
  - Visualização completa dos itens disponíveis com seus respectivos IDs e preços.
- **Controle de Pedidos:**
  - Criação de novos pedidos com geração automática de ID sequencial.
  - Adição de múltiplos itens e quantidades a um pedido existente (agrupando quantidades caso o mesmo item seja adicionado novamente).
  - Visualização detalhada do resumo do pedido com cálculo automático de subtotais e valor total.
  - Finalização e encerramento de pedidos.

## 🏗️ Estrutura do Projeto

```text
src/
├── Main.java                 # Interface CLI, menus e fluxo principal da aplicação
└── model/
    ├── ItemCardapio.java     # Classe base para os produtos do cardápio
    ├── Comida.java           # Subclasse de ItemCardapio (atributo peso)
    ├── Bebida.java           # Subclasse de ItemCardapio (atributo mls)
    ├── ItemPedido.java       # Representa um item adicionado ao pedido e sua quantidade
    └── Pedido.java           # Gerencia a lista de ItemPedido e o cálculo do valor final
