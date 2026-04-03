package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

	private Borsa borsa;
	private Attrezzo osso;
	
	@BeforeEach
	void setUp() throws Exception {
		borsa = new Borsa(10);
	}

	@Test
	void testAddAttrezzo_Positivo() {
		osso = new Attrezzo("osso", 1);
		assertTrue(borsa.addAttrezzo(osso));
	}
	
	@Test
	void testAddAttrezzo_Negativo_AttrezzoPesante() {
		osso = new Attrezzo("attrezzo", 11);
		assertFalse(borsa.addAttrezzo(osso));
	}
	
	@Test
	void testAddAttrezzo_Negativo_TroppiAttrezzi() {
		for(int i = 0; i < 10; i++) {
			Attrezzo attrezzo = new Attrezzo("attrezzo" + i , 0);
			borsa.addAttrezzo(attrezzo);
		}
		osso = new Attrezzo("osso", 1);
		assertFalse(borsa.addAttrezzo(osso));
	}
	
	@Test
	void testAddAttrezzo_Null() {
		assertFalse(borsa.addAttrezzo(null));
	}
	
	@Test
	void testGetAttrezzo_RicercaPositiva() {
		osso = new Attrezzo("osso", 1);
		borsa.addAttrezzo(osso);
		assertEquals(osso, borsa.getAttrezzo("osso"));
		assertNull(borsa.getAttrezzo("spada"));
	}
	
	@Test
	void testGetAttrezzo_RicercaNegativa() {
		assertNull(borsa.getAttrezzo("osso"));
	}
	
	@Test
	void testGetAttrezzo_Null() {
		assertNull(borsa.getAttrezzo(null));
	}
	
	@Test
	void testGetAttrezzo_() {
		assertNull(borsa.getAttrezzo("osso"));
	}
	
	@Test 
	void testGetAttrezzo_PiuAttrezzi() {
		for(int i = 0; i < 3; i++) {
			Attrezzo attrezzo = new Attrezzo("attrezzo" + i , 0);
			borsa.addAttrezzo(attrezzo);
		}
		assertEquals("attrezzo1", borsa.getAttrezzo("attrezzo1").getNome());
	}
	
	@Test
	void testRemoveAttrezzo_Positivo() {
		osso = new Attrezzo("osso", 1);
		borsa.addAttrezzo(osso);
		assertEquals(osso, borsa.removeAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzo_Negativo() {
		assertNull(borsa.removeAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzo_Null() {
		assertNull(borsa.removeAttrezzo(null));
	}
	
	@Test
	void testRemoveAttrezzo_PositivoPiuAttrezzi() {
		for(int i = 0; i < 3; i++) {
			Attrezzo attrezzo = new Attrezzo("attrezzo" + i , 0);
			borsa.addAttrezzo(attrezzo);
		}
		osso = new Attrezzo("osso", 1);
		borsa.addAttrezzo(osso);
		assertEquals(osso, borsa.removeAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzo_Verifica() {
		Attrezzo leggero = new Attrezzo("piuma", 1);
		Attrezzo pesante = new Attrezzo("incudine", 9);
		borsa.addAttrezzo(leggero);
		borsa.addAttrezzo(pesante);
		
		this.borsa.removeAttrezzo("incudine");
		assertEquals(1, this.borsa.getPeso());
		assertFalse(this.borsa.hasAttrezzo("incudine"));
	}


}
