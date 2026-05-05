package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica factory;
	private IO io;
	private Comando comando;
	
	@BeforeEach
	void setUp() throws Exception {
		this.io = new IOConsole();
		this.factory = new FabbricaDiComandiFisarmonica(this.io);
	}

	@Test
	void testCostriuisciComando_Null() {
		comando = factory.costruisciComando(null);
		assertEquals("non valido", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void testCostriuisciComando_Vai() {
		comando = factory.costruisciComando("vai nord");
		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}
	
	@Test
	void testCostriuisciComando_Prendi() {
		comando = factory.costruisciComando("prendi osso");
		assertEquals("prendi", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}
	
	@Test
	void testCostriuisciComando_Posa() {
		comando = factory.costruisciComando("posa osso");
		assertEquals("posa", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}
	
	@Test
	void testCostriuisciComando_Aiuto() {
		comando = factory.costruisciComando("aiuto");
		assertEquals("aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void testCostriuisciComando_Fine() {
		comando = factory.costruisciComando("fine");
		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void testCostriuisciComando_Guarda() {
		comando = factory.costruisciComando("guarda");
		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}
	
	@Test
	void testCostriuisciComando_Vuoto() {
		comando = factory.costruisciComando("");
		assertEquals("non valido", comando.getNome());
		assertNull(comando.getParametro());
	}
	
}
