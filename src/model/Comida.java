package model;

public class Comida extends ItemCardapio {
    private double peso;

    public Comida(String nome, String descricao, double preco, double peso) {
        super(nome, descricao, preco);
        this.peso = peso;
    }
}
