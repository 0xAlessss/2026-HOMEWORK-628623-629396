package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Stampa informazioni di aiuto.
 */

public class ComandoAiuto implements Comando {
	private IO io;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	
	public ComandoAiuto(IO io) {
        this.io = io;
    }
	
	@Override
    public void esegui(Partita partita) {
		String comandi = String.join(", ", elencoComandi);
		io.mostraMessaggio("Comandi disponibili: " + comandi);
	}
	
	@Override
    public void setParametro(String parametro) {
        //
    }
	
	@Override
	public String getNome() {
		return "aiuto";
	}
	
	@Override
	public String getParametro() {
		return null;
	}
	
}
