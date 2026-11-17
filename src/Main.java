import model.ItemCardapio;
import model.Pedido;
import java.util.ArrayList;
import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);
    ArrayList<ItemCardapio> cardapioDoDia = new ArrayList<>();
    ArrayList<Pedido> pedidosDoDia = new ArrayList<>();
    int opcaoMenu = 0;

    String menu = """
            
            MENU BURGUERBYTE
            1. ADICIONAR ITEM AO CARDÁPIO
            2. VISUALIZAR CARDÁPIO
            3. NOVO PEDIDO
            4. ADICIONAR ITEM AO PEDIDO
            5. VISUALIZAR PEDIDO
            6. FINALIZAR PEDIDO
            7. FECHAR SISTEMA
            Escolha: """;

    while (opcaoMenu != 7) {
        System.out.print(menu);
        opcaoMenu = sc.nextInt();
        sc.nextLine(); // Limpa o Enter

        switch (opcaoMenu) {
            case 1 -> {
                int opcao = 1;
                while (opcao == 1) {
                    ItemCardapio novoItem = ItemCardapio.adicionarItemCardapio(sc);
                    if (novoItem != null) {
                        cardapioDoDia.add(novoItem);
                        System.out.println("ITEM ADICIONADO! (ID: " + novoItem.getId() + ")");
                    }
                    System.out.print("1 para mais itens ou 0 para menu: ");
                    opcao = sc.nextInt();
                    sc.nextLine();
                }
            }
            case 2 -> {
                if (cardapioDoDia.isEmpty()) {
                    System.out.println("CARDÁPIO VAZIO :(");
                } else {
                    System.out.println("--- CARDÁPIO BURGUERBYTE ---");
                    for (ItemCardapio item : cardapioDoDia) {
                        System.out.printf("[%d] %s -- R$ %.2f\n", item.getId(), item.getNome(), item.getPreco());
                    }
                }
            }
            case 3 -> {
                Pedido novoPedido = new Pedido();
                pedidosDoDia.add(novoPedido);
                System.out.println("PEDIDO CRIADO! ID DO PEDIDO: " + novoPedido.getId());
                adicionarItensNoPedido(sc, cardapioDoDia, novoPedido);
            }
            case 4 -> {
                Pedido pedido = buscarPedido(sc, pedidosDoDia);
                if (pedido != null) adicionarItensNoPedido(sc, cardapioDoDia, pedido);
            }
            case 5 -> {
                Pedido pedido = buscarPedido(sc, pedidosDoDia);
                if (pedido != null) pedido.mostraPedido();
            }
            case 6 -> {
                Pedido pedido = buscarPedido(sc, pedidosDoDia);
                if (pedido != null) {
                    pedido.mostraPedido();
                    pedidosDoDia.remove(pedido);
                    System.out.println("PEDIDO FINALIZADO E PAGO!");
                }
            }
            case 7 -> System.out.println("SISTEMA ENCERRADO.");
            default -> System.out.println("OPÇÃO INVÁLIDA!");
        }
    }
}

// --- MÉTODOS AUXILIARES PARA ENCURTAR O MAIN ---

Pedido buscarPedido(Scanner sc, ArrayList<Pedido> pedidos) {
    System.out.print("DIGITE O ID DO PEDIDO: ");
    int id = sc.nextInt();
    sc.nextLine();
    for (Pedido p : pedidos) {
        if (p.getId() == id) return p;
    }
    System.out.println("PEDIDO NÃO ENCONTRADO!");
    return null;
}

void adicionarItensNoPedido(Scanner sc, ArrayList<ItemCardapio> cardapio, Pedido pedido) {
    int continuar = 1;
    while (continuar != 0) {
        System.out.print("DIGITE O NOME DO PRODUTO: ");
        String nome = sc.nextLine();
        System.out.print("QUANTIDADE: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        boolean achou = false;
        for (ItemCardapio item : cardapio) {
            if (item.getNome().toLowerCase().contains(nome.toLowerCase())) {
                pedido.adicionarItem(item, qtd);
                System.out.println(item.getNome() + " adicionado ao pedido!");
                achou = true;
                break;
            }
        }
        if (!achou) System.out.println("PRODUTO NÃO ENCONTRADO NO CARDÁPIO.");

        System.out.print("1 para adicionar outro item ou 0 para voltar: ");
        continuar = sc.nextInt();
        sc.nextLine();
    }
}