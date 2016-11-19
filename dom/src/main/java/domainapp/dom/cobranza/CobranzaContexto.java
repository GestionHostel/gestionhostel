package domainapp.dom.cobranza;

public class CobranzaContexto {
	CobranzaInterfaz cobranzaInterfaz;
	
	public CobranzaContexto() {
		this.cobranzaInterfaz = new Impago();
	}
	
	
	public void setCobranzaInterfaz(CobranzaInterfaz cobranzaInterfaz) {
		this.cobranzaInterfaz = cobranzaInterfaz;
	}
	
	public void cambiarCobranza() {
		this.cobranzaInterfaz.cambiarCobranza(this);
	}
	
	
	
	
}
