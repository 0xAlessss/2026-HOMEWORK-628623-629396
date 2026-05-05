package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoSbloccante;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
        if (this.direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSbloccante)) {
        	return this;
        } else {
        	return super.getStanzaAdiacente(direzione);
        }
	}
	
	@Override
	public String getDescrizione() {
		return super.getDescrizione() + "\nAttenzione: la direzione " + this.direzioneBloccata + " è bloccata! (serve: " + this.attrezzoSbloccante + ")";
	}

}
