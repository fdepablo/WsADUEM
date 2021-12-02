package es.act1.modelo.negocio;

import java.util.List;

import es.act1.modelo.dao.DaoFichero;

public class GestorFichero {

	private DaoFichero dao = new DaoFichero();
	
	public boolean crearFichero() {
		return dao.crearFichero();
	}
	
	public List<String> listar(){
		return dao.listar();
	}
	
	/**
	 * Metodo que introduce una frase con ayuda del dao
	 * @param frase
	 * @return 0 en caso de que se haya introducido, 1 en caso de que la frase
	 * sea nula o este vacia y 2 en caso de problemas con el fichero
	 */
	public int introducirFrase(String frase) {
		if(frase == null || "".equals(frase)) {
			return 1;
		}
		
		boolean fraseIntroducida = dao.introducirFrase(frase);
		if(fraseIntroducida) {
			return 0;
		}else {
			return 2;
		}
	}
	
	public String obtenerFraseAleatoria() {
		return dao.obtenerFraseAleatoria();
	}

}

/*
 * 


	if ((frase != null) && (frase.length() > 0)) {
		
	} else {
		BackToMenu();
	}
*/
