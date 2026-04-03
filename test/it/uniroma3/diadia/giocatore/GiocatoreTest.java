package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	
	private Giocatore giocatore;
	@BeforeEach
	void setUp() throws Exception {
		giocatore = new Giocatore();
	}

	@Test
	void testGetCfuIniziali() {
		assertEquals(20, this.giocatore.getCfuIniziali());
	}
	
	@Test
	void testSetCfu() {
		this.giocatore.setCfu(67);
		assertEquals(67,this.giocatore.getCfu());
	}	
	
	@Test
	void testSetCfu_Zero() {
		this.giocatore.setCfu(0);
		assertEquals(0,this.giocatore.getCfu());
	}	
		
}
