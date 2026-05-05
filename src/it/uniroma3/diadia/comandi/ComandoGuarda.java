package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	private IO io;
	
	public ComandoGuarda(IO io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Ti trovi in: " + partita.getStanzaCorrente().getDescrizione());
		
		this.io.mostraMessaggio("CFU rimanenti: " + partita.getGiocatore().getCfu());
		
		this.io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		// Questo comando non utilizza parametri
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}
	
	@Override
	public String getParametro() {
		return null;
	}
}
