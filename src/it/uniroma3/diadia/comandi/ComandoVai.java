package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */

public class ComandoVai implements Comando {
    private String direzione;
    private IO io;
    
    public ComandoVai(IO io) {
        this.io = io;
    }
    
    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        Stanza prossimaStanza = null;
        
        if (this.direzione==null) {
            io.mostraMessaggio("Dove vuoi andare?\n" + "Devi specificare una direzione");
            return;
        }
        
        prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
        
        if (prossimaStanza==null) {
            io.mostraMessaggio("Direzione inesistente");
            return;
        }
        
        partita.setStanzaCorrente(prossimaStanza);
        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
        io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().getDescrizione());
    }
    
    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }
    
    @Override
	public String getNome() {
		return "vai";
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}
}