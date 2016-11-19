package domainapp.dom.cobranza;

class Parcial implements CobranzaInterfaz {

	@Override
	public void cambiarCobranza(CobranzaContexto cobranzaContexto) {
		// TODO Auto-generated method stub
		cobranzaContexto.setCobranzaInterfaz(new Finalizado()); 	
	}
	
}
