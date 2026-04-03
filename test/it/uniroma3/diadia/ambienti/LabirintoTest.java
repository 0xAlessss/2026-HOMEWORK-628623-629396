package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {

	private Labirinto labirinto;
	
	
	@BeforeEach
	void setUp() throws Exception {
		labirinto = new Labirinto();
	}

	@Test
	void testGetStanzaFinale() {
		assertEquals("Biblioteca", this.labirinto.getStanzaFinale().getNome());
	}
	
	@Test
	void testGetStanzaIniziale() {
		assertEquals("Atrio", this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	void testGetStanza_Collegamenti_Iniziali() {
		assertEquals("Aula N11", this.labirinto.getStanzaIniziale().getStanzaAdiacente("est").getNome());
		assertEquals("Aula N10", this.labirinto.getStanzaIniziale().getStanzaAdiacente("sud").getNome());
		assertEquals("Laboratorio Campus", this.labirinto.getStanzaIniziale().getStanzaAdiacente("ovest").getNome());
		assertEquals("Biblioteca", this.labirinto.getStanzaIniziale().getStanzaAdiacente("nord").getNome());
	}
}
