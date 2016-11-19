package domainapp.dom.cobranza;

class Impago implements CobranzaInterfaz {

	@Override
	public void cambiarCobranza(CobranzaContexto cobranzaContexto) {
		// TODO Auto-generated method stub
		cobranzaContexto.setCobranzaInterfaz(new Parcial());
	}

}
