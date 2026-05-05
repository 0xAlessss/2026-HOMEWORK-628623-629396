package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;


class ComandoPosaTest {
	private Partita partita;
	private ComandoPosa posa;
	private IO io;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() {
		this.partita = new Partita();
		this.io = new IOConsole();
		this.posa = new ComandoPosa(this.io);
		this.attrezzo = new Attrezzo("attrezzo" , 2);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	}
	
	@Test
	void testEsegui_PosaAttrezzoPositivo() {
		this.posa.setParametro("attrezzo");
		this.posa.esegui(this.partita);
		
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("attrezzo"));
	}

	@Test
	void testEsegui_PosaAttrezzoNegativo() {
		this.posa.setParametro("ascia");
		this.posa.esegui(this.partita);
		
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("ascia"));
	}
	@Test
	void testEsegui_PosaAttrezzoNull() {
		this.posa.setParametro(null);
		this.posa.esegui(this.partita);
		
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzo"));
		
	}

}
