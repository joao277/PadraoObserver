package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class ApartamentooTest {

    @Test
    void deveNotificarChegadaEncomendaNoApartamento() {
        Predio predio = new Predio("Edificio 1", "Dom Vicoso", "336", "Juiz de Fora");
        Apartamento apartamento = new Apartamento("302");
        apartamento.receber(predio);
        predio.EnviarEncomenda();
        assertEquals("302, rua: Predio{nome='Edificio 1', rua='Dom Vicoso', numero='336', cidade='Juiz de Fora'}", apartamento.getUltimaNotificacao());
    }

    @Test
    void deveNotificarChegadaEncomendaDoisApartamentos() {
        Predio predio = new Predio("Edificio 1", "Dom Vicoso", "336", "Juiz de Fora");
        Apartamento apartamento1 = new Apartamento("302");
        Apartamento apartamento2 = new Apartamento("303");
        apartamento1.receber(predio);
        apartamento2.receber(predio);
        predio.EnviarEncomenda();
        assertEquals("302, rua: Predio{nome='Edificio 1', rua='Dom Vicoso', numero='336', cidade='Juiz de Fora'}", apartamento1.getUltimaNotificacao());
        assertEquals("303, rua: Predio{nome='Edificio 1', rua='Dom Vicoso', numero='336', cidade='Juiz de Fora'}", apartamento2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificar() {
        Predio predio = new Predio("Edificio 1", "Dom Vicoso", "336", "Juiz de Fora");
        Apartamento apartamento = new Apartamento("302");
        predio.EnviarEncomenda();
        assertEquals(null, apartamento.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSomenteOApartamento() {
        Predio predio1 = new Predio("Edificio 1", "Dom Vicoso", "336", "Juiz de Fora");
        Predio predio2 = new Predio("Edificio 2", "Dom Vicoso", "299", "Juiz de Fora");
        Apartamento apartamento1 = new Apartamento("302");
        Apartamento apartamento2 = new Apartamento("222");
        apartamento1.receber(predio1);
        apartamento2.receber(predio2);
        predio1.EnviarEncomenda();
        assertEquals("302, rua: Predio{nome='Edificio 1', rua='Dom Vicoso', numero='336', cidade='Juiz de Fora'}", apartamento1.getUltimaNotificacao());
        assertEquals(null, apartamento2.getUltimaNotificacao());
    }
}
