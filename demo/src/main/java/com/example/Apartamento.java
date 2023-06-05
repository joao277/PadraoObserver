package com.example;

import java.util.Observable;
import java.util.Observable;
import java.util.Observer;

public class Apartamento implements Observer{
    
        private String numeroApartamento;
        private String ultimaNotificacao;
    
        public Apartamento(String numeroApartamento) {
            this.numeroApartamento = numeroApartamento;
        }
    
        public String getUltimaNotificacao() {
            return this.ultimaNotificacao;
        }
    
        public void receber(Predio predio) {
            predio.addObserver(this);
        }
    
        public void update(Observable predio, Object arg1) {
            this.ultimaNotificacao = this.numeroApartamento + ", apartamento para entrega: " + predio.toString();
        }
    
    }