package com.example;

import java.util.Observable;

public class Predio extends Observable{

    private String nome;
    private String rua;
    private String numero;
    private String cidade;

    public Predio(String nome, String rua, String numero, String cidade) {
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    public void EnviarEncomenda() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Predio{" +
                "nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }

}