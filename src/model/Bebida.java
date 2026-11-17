package model;

import java.util.Random;

public class Bebida extends ItemCardapio {
    private double mls;

    public Bebida(String nome, String descricao, double preco, double mls) {
        super(nome, descricao, preco);
        this.mls = mls;
    }

    public double getMls() {
        return mls;
    }

    public void setMls(double mls) {
        this.mls = mls;
    }
}
