package model;

public class ItemPedido {
    private ItemCardapio item;
    private int quantidade;
    private double precoTotal;

    public ItemPedido(ItemCardapio item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
        this.precoTotal = item.getPreco() * quantidade;
    }

    public String getNome() {
        return item.getNome();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.precoTotal = item.getPreco() * quantidade;
    }

    public void alterarQuantidade(int quantidade) {
        this.quantidade += quantidade;
        this.precoTotal = item.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "item=" + item +
                ", quantidade=" + quantidade +
                ", precoTotal=" + precoTotal +
                '}';
    }
}
