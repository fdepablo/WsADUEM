package es.act1.vista;

import java.util.List;

import javax.swing.JOptionPane;

import es.act1.modelo.negocio.GestorFichero;

public class Menu {

	private GestorFichero gp;

	public void start() {
		gp = new GestorFichero();
		gp.crearFichero();
		
		MyIcon icon = new MyIcon();
		String[] options = { "Introducir frases celebres", 
						"Mostrar frases celebres", 
						"Mostrar frase celebre aleatoria",
						"Salir" };
				
		boolean continuar = true;
		do {
			int seleccion = JOptionPane.showOptionDialog(null, "Por favor seleccione una opcion ", "Frases",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);

			if (seleccion == 0) {
				String frase = JOptionPane.showInputDialog(null, "Introduzca una frase por favor");			
				int resultado = gp.introducirFrase(frase);
				if(resultado == 0) {
					JOptionPane.showMessageDialog(null, "Se ha introducido el mensaje");
				}else if(resultado == 1) {
					JOptionPane.showMessageDialog(null, "No se admiten vacios");
				}else {
					JOptionPane.showMessageDialog(null, "Algun problema con el fichero");
				}
			}
			if (seleccion == 1) {
				List<String> listaFrases = gp.listar();
				String frases = "";
				for (String element : listaFrases) {
					frases += element + "\n";
				}
				JOptionPane.showMessageDialog(null, frases);
			}

			if (seleccion == 2) {
				String frase = gp.obtenerFraseAleatoria();
				JOptionPane.showMessageDialog(null, frase);
			}

			if (seleccion == 3) {
				int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Atención!",
						JOptionPane.YES_NO_OPTION);
				if (resp == 0) {
					continuar = false;
				}
			}
		}while(continuar);		
	}
}