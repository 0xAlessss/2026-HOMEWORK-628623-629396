package it.uniroma3.diadia;

import java.util.Scanner;

public class IOSimulator implements IO {
	
	private String[] righeLette;
	private int indiceRigheLette;
	
	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	
	public IOSimulator(String[] righeLette) {
		this.righeLette = righeLette;
		this.indiceRigheLette = 0;
		
		this.messaggiProdotti = new String[100];
		this.indiceMessaggiProdotti = 0;
	}
	@Override
	public void mostraMessaggio(String msg) {
		if(this.indiceMessaggiProdotti < this.messaggiProdotti.length) {
			this.messaggiProdotti[this.indiceMessaggiProdotti] = msg;
			this.indiceMessaggiProdotti++;
		}
	}
	
	@Override
	public String leggiRiga() {
		if (this.indiceRigheLette < this.righeLette.length) {
			String riga = this.righeLette[this.indiceRigheLette];
			this.indiceRigheLette++;
			return riga;
		}
		return "";
	}
	
	public boolean hasMessaggio(String frammentoDaCercare) {
		for (int i = 0; i < this.indiceMessaggiProdotti; i++) {
	        if (this.messaggiProdotti[i] != null && this.messaggiProdotti[i].contains(frammentoDaCercare)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public String getMessaggio(int indice) {
		if (indice >= 0 && indice < this.indiceMessaggiProdotti) {
			return this.messaggiProdotti[indice];
		}
		return null;
	}
	public String[] getMessaggi() {
		return this.messaggiProdotti;
	}
}
