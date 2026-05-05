package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiaDiaTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test_ComandoFine() {
		String[] comandi = {"fine"};
		IOSimulator simulatore = new IOSimulator(comandi);
		DiaDia gioco = new DiaDia(simulatore);
		gioco.gioca();
		assertTrue(simulatore.hasMessaggio("Grazie di aver giocato!") );
	}
	
	@Test
	void test_VittoriaVeloce() {
		String[] comandiDaEseguire = {"vai nord", "fine"};
		IOSimulator simulatore = new IOSimulator(comandiDaEseguire);
		DiaDia gioco = new DiaDia(simulatore);
		gioco.gioca();
		assertTrue(simulatore.hasMessaggio("Hai vinto!") );
	}
	
	@Test
	void test_Sconfitta() {
		String[] comandiDaEseguire = {"vai sud", "vai nord" , "vai sud", "vai nord" , "vai sud", "vai nord" , "vai sud", "vai nord" , "vai sud", "vai nord" , "vai sud", "vai nord" , "vai sud", "vai nord" , "vai sud", "vai nord" , "vai sud", "vai nord" , "vai sud", "vai nord" , "fine" };
		IOSimulator simulatore = new IOSimulator(comandiDaEseguire);
		DiaDia gioco = new DiaDia(simulatore);
		gioco.gioca();
		assertFalse(simulatore.hasMessaggio("Hai vinto!") );
	}
	
	@Test
	void test_ComandoNonValido() {
	    String[] comandi = {"erore", "fine"};
	    IOSimulator simulatore = new IOSimulator(comandi);
	    DiaDia gioco = new DiaDia(simulatore);
	    gioco.gioca();
	    assertTrue(simulatore.hasMessaggio("Comando sconosciuto")); 
	}
	
	@Test
	void test_ComandoAiuto() {
	    String[] comandi = {"aiuto", "fine"};
	    IOSimulator simulatore = new IOSimulator(comandi);
	    DiaDia gioco = new DiaDia(simulatore);
	    gioco.gioca();
	    assertTrue(simulatore.hasMessaggio("vai"));
	    assertTrue(simulatore.hasMessaggio("aiuto"));
	}
	
	@Test
	void test_ComandoGuarda() {
	    String[] comandi = {"guarda", "fine"};
	    IOSimulator simulatore = new IOSimulator(comandi);
	    DiaDia gioco = new DiaDia(simulatore);
	    gioco.gioca();
	    assertTrue(simulatore.hasMessaggio("Ti trovi in: Atrio"));
	    assertTrue(simulatore.hasMessaggio("CFU rimanenti: 20")); 
	}
}
