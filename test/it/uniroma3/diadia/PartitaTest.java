package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {
	private Partita partita;
	private Giocatore giocatore;
	
	@BeforeEach
	void setUp() throws Exception {
		partita = new Partita();
		giocatore = new Giocatore();
	}
	//Quattro case_test per il metodo vinta()
	@Test
	void testVinta_Positivo() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	void testVinta_Negativo() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	void testVinta_Spostamento() {
		Stanza bar = new Stanza("bar");
		this.partita.setStanzaCorrente(bar);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	void testVinta_Null() {
		this.partita.setStanzaCorrente(null);
		assertFalse(this.partita.vinta());
	}
	
	//Quattro case_test per il metodo isFinita()
	@Test
	void testIsFinita_Positiva() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testIsFinita_Negativa() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	void testIsFinita_Cfu() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testIsFinita_Settata() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	//Tre case_test per il metodo setStanzaCorrente()
	@Test
	void testSetStanzaCorrente_Standard() {
		Stanza bar = new Stanza("bar");
		this.partita.setStanzaCorrente(bar);
		assertEquals(bar, this.partita.getStanzaCorrente());
	}
	
	@Test
	void testSetStanzaCorrente_Null() {
		this.partita.setStanzaCorrente(null);
		assertNull(this.partita.getStanzaCorrente());
	}
	
	@Test
	void testSetStanzaCorrente_Vincente() {
		Stanza vincente = this.partita.getStanzaVincente();
		this.partita.setStanzaCorrente(vincente);
		assertSame(vincente, this.partita.getStanzaCorrente());
	}
}

