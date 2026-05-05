package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Comando "posa" attrezzo.
 */

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private IO io;
    
    public ComandoPosa(IO io) {
        this.io = io;
    }
    
    @Override
    public void esegui(Partita partita) {
    	if(nomeAttrezzo != null) {
			if(partita.getGiocatore().getBorsa().isEmpty()) {
				io.mostraMessaggio("La borsa è vuota.");
				io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
				io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
			} else {
				if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
					Attrezzo attrezzoInBorsa = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
					Stanza stanzaCorrente = partita.getStanzaCorrente();
					if(stanzaCorrente.addAttrezzo(attrezzoInBorsa)) {
						partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
						io.mostraMessaggio("L'oggetto " + nomeAttrezzo + " è stato rimoosso dalla borsa");
						io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
						io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
					}			
				} else {
					io.mostraMessaggio("L'oggetto " + nomeAttrezzo + " non è nella borsa");
					io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
					io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
					
				}
			} 
			
		} else {
		io.mostraMessaggio("Non è proprio un oggetto... riprova.");
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
	
		}		
    }
    
    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
    
    @Override
	public String getNome() {
		return "posa";
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
