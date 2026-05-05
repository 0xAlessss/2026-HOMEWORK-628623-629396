package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private StanzaBuia dark;
	private Attrezzo lanterna;
	
	@BeforeEach
	void setUp() throws Exception {
		dark = new StanzaBuia("Dark", "lanterna");
		lanterna = new Attrezzo("lanterna", 1);
	}

	@Test
	void testGetDescrizione_Negativo() {
		assertEquals("qui c'è buio pesto", dark.getDescrizione());
	}
	
	@Test
	void testGetDescrizione_Positivo() {
		dark.addAttrezzo(lanterna);
		assertEquals(dark.getDescrizione(), dark.toString());
	}
}
