package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata blocked;
	private Attrezzo piedediporco;
	private Stanza next;
	private Stanza prev;
	
	@BeforeEach
	void setUp() throws Exception {
		blocked = new StanzaBloccata("Bloccata", "nord", "piedediporco");
		next = new Stanza("next");
		prev = new Stanza("prev");
		blocked.impostaStanzaAdiacente("nord", next);
		blocked.impostaStanzaAdiacente("sud", prev);
		piedediporco = new Attrezzo("piedediporco", 1);
	}


	@Test
	void testGetDirezione_BloccataNegativo() {
		assertEquals(blocked.getStanzaAdiacente("nord"), blocked);
	}
	
	@Test
	void testGetDirezione_BloccataPositivo() {
		blocked.addAttrezzo(piedediporco);
		assertEquals(blocked.getStanzaAdiacente("nord"), next);
	}
	
	@Test
	void testGetDirezione_SbloccataPositivo() {
		assertEquals(blocked.getStanzaAdiacente("sud"), prev);
	}

}
