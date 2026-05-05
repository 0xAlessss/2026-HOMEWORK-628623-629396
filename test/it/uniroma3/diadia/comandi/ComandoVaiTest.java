package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

class ComandoVaiTest {
	private Partita partita;
	private ComandoVai vai;
	private IO io;
	private Stanza partenza;
	
	@BeforeEach
	void setUp() {
		this.partita = new Partita();
		this.io = new IOConsole();
		this.vai = new ComandoVai(this.io);
		this.partenza = this.partita.getStanzaCorrente();
	}

	@Test
	void testEsegui_DirezioneEsistente() {
		this.vai.setParametro("nord");
		this.vai.esegui(this.partita);
		
		assertEquals("Biblioteca", this.partita.getStanzaCorrente().getNome());
		assertEquals(19, this.partita.getGiocatore().getCfu());
	}
	
	@Test
	void testEsegui_DirezioneInesistente() {
		this.vai.setParametro("ghost");
		this.vai.esegui(this.partita);
		
		assertEquals(this.partenza.getNome(), this.partita.getStanzaCorrente().getNome());
		assertEquals(20, this.partita.getGiocatore().getCfu());
	}
	
	@Test
	void testEsegui_SenzaDirezione() {
		this.vai.setParametro(null);
		this.vai.esegui(this.partita);
		
		assertEquals(this.partenza.getNome(), this.partita.getStanzaCorrente().getNome());
		assertEquals(20, this.partita.getGiocatore().getCfu());
	}
}
