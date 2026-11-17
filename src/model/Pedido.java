package model;

import java.util.ArrayList;

public class Pedido {
    private static int contadorId = 1;
    private int id;
    private ArrayList<ItemPedido> itens;

    public Pedido() {
        this.id = contadorId++;
        this.itens = new ArrayList<>();
    }

    public int getId() { return id; }

    public void adicionarItem(ItemCardapio item, int quantidade) {
        // Se o item já existe no pedido, apenas soma a quantidade
        for (ItemPedido ip : itens) {
            if (ip.getNome().equalsIgnoreCase(item.getNome())) {
                ip.setQuantidade(ip.getQuantidade() + quantidade);
                return;
            }
        }
        itens.add(new ItemPedido(item, quantidade));
    }

    public double valorFinal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPrecoTotal();
        }
        return total;
    }

    public void mostraPedido() {
        System.out.println("------------- RESUMO DO PEDIDO #" + id + " -------------");
        for (int i = 0; i < itens.size(); i++) {
            ItemPedido item = itens.get(i);
            System.out.printf("%d. %s | Qtd: %d | Subtotal: R$ %.2f\n",
                    (i + 1), item.getNome(), item.getQuantidade(), item.getPrecoTotal());
        }
        System.out.printf("TOTAL: R$ %.2f\n", valorFinal());
    }
}