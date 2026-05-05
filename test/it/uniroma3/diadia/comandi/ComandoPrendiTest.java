package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
	
	private Partita partita;
	private ComandoPrendi prendi;
	private IO io;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() {
		this.partita = new Partita();
		this.io = new IOConsole();
		this.prendi = new ComandoPrendi(this.io);
		this.attrezzo = new Attrezzo("attrezzo" , 2);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
	}

	@Test
	void testEsegui_PrendiAttrezzoPositivo() {
		this.prendi.setParametro("attrezzo");
		this.prendi.esegui(this.partita);
		
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
	}

	@Test
	void testEsegui_PrendiAttrezzoNegativo() {
		this.prendi.setParametro("ascia");
		this.prendi.esegui(this.partita);
		
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("ascia"));
	}
	@Test
	void testEsegui_PrendiAttrezzoNull() {
		this.prendi.setParametro(null);
		this.prendi.esegui(this.partita);
		
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty());	
	}

}
