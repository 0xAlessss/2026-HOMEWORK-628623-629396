package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	private Stanza bar;
	private Stanza mensa;
	private Stanza aula;
	private Stanza atrio;
	private Stanza biblioteca;
	private Stanza extra;
	private Attrezzo spada;
	
	@BeforeEach
	void setUp() throws Exception {
		this.mensa = new Stanza("mensa");	
	}

	//Tre case_test per il metodo impostaStanzaAdiacente()
	@Test
	void testImpostaStanzaAdiacente_Standard() {
		this.bar = new Stanza("bar");
		this.mensa.impostaStanzaAdiacente("nord", bar);
		
		assertEquals(bar, this.mensa.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testImpostaStanzaAdiacente_Sovrascritta() {
		this.bar = new Stanza("bar");
		this.aula = new Stanza("aula");
		this.mensa.impostaStanzaAdiacente("nord", bar);
		this.mensa.impostaStanzaAdiacente("nord", aula);
		
		assertEquals(aula, this.mensa.getStanzaAdiacente("nord"));	
	}

	@Test
	void testImpostaStanzaAdiacente_LimiteDirezioni() {
		this.bar = new Stanza("bar");
		this.atrio = new Stanza("atrio");
		this.biblioteca = new Stanza("biblioteca");
		this.extra = new Stanza("extra");
		this.mensa.impostaStanzaAdiacente("nord", bar);
		this.mensa.impostaStanzaAdiacente("sud", aula);
		this.mensa.impostaStanzaAdiacente("ovest", atrio);
		this.mensa.impostaStanzaAdiacente("est", biblioteca);		
		this.mensa.impostaStanzaAdiacente("nord_est", extra);
		
		assertNull(this.mensa.getStanzaAdiacente("nord_est"));
	} 
	
	//Tre case_test per il metodo getStanzaAdiacente()
	@Test
	void testGetStanzaAdiacente_Standard() {
		this.bar = new Stanza("bar");
		this.mensa.impostaStanzaAdiacente("est", bar);
		
		assertEquals(bar, this.mensa.getStanzaAdiacente("est"));
	}
	
	@Test
	void testGetStanzaAdiacente_Null() {
		assertNull(this.mensa.getStanzaAdiacente("est"));
	}
	
	@Test
	void testGetStanzaAdiacente_DirezioneFake() {
		this.mensa.impostaStanzaAdiacente("est", bar);
		
		assertNull(this.mensa.getStanzaAdiacente("nord"));
	}
	
	//Tre case_test per il metodo addAttrezzo()
	@Test
	void testAddAttrezzo_Standard() {
		this.spada = new Attrezzo("spada", 2);
		assertTrue(this.mensa.addAttrezzo(spada));
	}
	
	@Test
	void testAddAttrezzo_Piena() {
		for(int i = 0; i<10; i++) {
			this.mensa.addAttrezzo(new Attrezzo("attrezzo" + i, 1));
		}
		Attrezzo extra = new Attrezzo("extra", 1);
		assertFalse(this.mensa.addAttrezzo(extra));
	}
	
	@Test
	void testAddAttrezzo_Null() {
		assertFalse(this.mensa.addAttrezzo(null));
	}
	
	//Tre case_test per il metodo getAttrezzo()
	@Test
	void testGetAttrezzo_Standard() {
		this.spada = new Attrezzo("spada", 2);
		this.mensa.addAttrezzo(spada);
		assertEquals(spada, this.mensa.getAttrezzo("spada"));		
	}
	
	@Test
	void testGetAttrezzo_Assente() {
		assertNull(this.mensa.getAttrezzo("spada"));		
	}
	
	@Test
	void testGetAttrezzo_Null() {
		assertNull(this.mensa.getAttrezzo(null));		
	}

	//Tre case_test per il metodo hasAttrezzo()
	@Test
	void testHasAttrezzo_Positvo() {
		this.spada = new Attrezzo("spada", 2);
		this.mensa.addAttrezzo(spada);
		assertTrue(this.mensa.hasAttrezzo("spada"));
	}
	
	@Test
	void testHasAttrezzo_Negativo() {
		assertFalse(this.mensa.hasAttrezzo("spada"));
	}
	
	@Test
	void testHasAttrezzo_Null() {
		assertFalse(this.mensa.hasAttrezzo(null));
	}
	
	//Tre case_test per il metodo getDirezioni()
	@Test
	void testGetDirezioni_Vuota() {
		assertEquals(0, this.mensa.getDirezioni().length);		
	}
	
	@Test
	void testGetDirezioni_Singola() {
		this.bar = new Stanza("bar");
		this.mensa.impostaStanzaAdiacente("nord", bar);
		String[] direzioni = this.mensa.getDirezioni();
		assertEquals(1, direzioni.length);
		assertEquals("nord", direzioni[0]);
	}
	
	@Test
	void testGetDirezioni_Piena() {
		this.bar = new Stanza("bar");
		this.atrio = new Stanza("atrio");
		this.biblioteca = new Stanza("biblioteca");
		this.extra = new Stanza("extra");
		this.mensa.impostaStanzaAdiacente("nord", bar);
		this.mensa.impostaStanzaAdiacente("sud", aula);
		this.mensa.impostaStanzaAdiacente("ovest", atrio);
		this.mensa.impostaStanzaAdiacente("est", biblioteca);
		this.mensa.impostaStanzaAdiacente("nord_est", extra);
		String[] direzioni = this.mensa.getDirezioni();
		
		assertEquals(4, direzioni.length);
		for(String d : direzioni) {
			assertNotEquals("nord_est", d);			
		}
	}
	
	@Test
	void testRemoveAttrezzo_Positivo() {
		this.spada = new Attrezzo("spada", 2);
		this.mensa.addAttrezzo(spada);
		assertTrue(this.mensa.removeAttrezzo(spada));
		assertFalse(this.mensa.hasAttrezzo("spada"));
	}
	
	@Test
	void testRemoveAttrezzo_Negativo() {
		assertFalse(mensa.removeAttrezzo(spada));
	}
	
	@Test
	void testRemoveAttrezzo_Null() {
		assertFalse(mensa.removeAttrezzo(null));
	}
}
