package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private StanzaMagica magic;
	private Attrezzo bacchetta;
	
	@BeforeEach
	void setUp() throws Exception {
		magic = new StanzaMagica("Magia", 1);
		bacchetta = new Attrezzo("bacchetta", 1);
		this.magic.addAttrezzo(bacchetta);
	}

	@Test
	void testAddAttrezzo_Normale() {
		assertEquals("bacchetta", this.magic.getAttrezzo("bacchetta").getNome());
		assertEquals(1, this.magic.getAttrezzo("bacchetta").getPeso());
		assertNull(this.magic.getAttrezzo("attehccab"));
	}
	
	@Test
	void testAddAttrezzo_Magico() {
		this.magic.addAttrezzo(bacchetta);
		assertEquals("attehccab", this.magic.getAttrezzo("attehccab").getNome());
		assertEquals(2, this.magic.getAttrezzo("attehccab").getPeso());
	}


}
