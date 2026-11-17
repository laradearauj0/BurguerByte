package model;

import java.util.Scanner;

public class ItemCardapio {
    private static int contadorId = 1; // Gera 1, 2, 3 automaticamente
    private int id;
    private String nome;
    private String descricao;
    private double preco;

    public ItemCardapio(String nome, String descricao, double preco) {
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public double getPreco() { return preco; }
    public String getDescricao() { return descricao; }
    public String getNome() { return nome; }
    public int getId() { return id; }

    public static ItemCardapio adicionarItemCardapio(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();

        System.out.print("1 - Bebida | 2 - Comida: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        if (opcao == 1) {
            System.out.print("Quantidade (ml): ");
            double mls = sc.nextDouble();
            sc.nextLine();
            return new Bebida(nome, descricao, preco, mls);
        } else if (opcao == 2) {
            System.out.print("Peso (g): ");
            double peso = sc.nextDouble();
            sc.nextLine();
            return new Comida(nome, descricao, preco, peso);
        }
        System.out.println("ERRO: OPÇÃO INVÁLIDA");
        return null;
    }
}