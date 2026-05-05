package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Comando "prendi" attrezzo.
 */

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	private IO io;
    
    public ComandoPrendi(IO io) {
        this.io = io;
    }
    
    @Override
    public void esegui(Partita partita) {
    	if(nomeAttrezzo != null) {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			for(Attrezzo attrezzoInStanza : stanzaCorrente.getAttrezzi()) {
				if(attrezzoInStanza != null && nomeAttrezzo.equals(attrezzoInStanza.getNome())) {
					Giocatore giocatore = partita.getGiocatore();
					Borsa borsa = giocatore.getBorsa();
					if(borsa.addAttrezzo(attrezzoInStanza)) {
						stanzaCorrente.removeAttrezzo(attrezzoInStanza);
						io.mostraMessaggio("Hai preso l'oggetto: " + attrezzoInStanza.getNome());
						io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
						io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
					} else {
						io.mostraMessaggio("Troppo pesante per la tua borsa.");
					}
					return;
				}
			}
			io.mostraMessaggio("L'oggetto " + nomeAttrezzo + " non è nella stanza.");
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
			return;
		}
		io.mostraMessaggio("Non è proprio un oggetto... riprova.");
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
    }
    
    
    @Override
    public void setParametro(String parametro) {
        this.nomeAttrezzo = parametro;
    }
    
    @Override
	public String getNome() {
		return "prendi";
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
