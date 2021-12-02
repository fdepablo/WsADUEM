package es.act1.modelo.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DaoFichero {

	public static final String NOMBRE_FICHERO = "miFichero.txt";

	public boolean crearFichero() {

		File fn = new File(NOMBRE_FICHERO);
		if (!fn.exists()) {
			try {
				fn.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Creado el archivo " + fn.getName());
			return true;
		} else {
			return false;
		}
	}

	public boolean introducirFrase(String frase) {
		try (FileWriter fw = new FileWriter(NOMBRE_FICHERO, true); 
				BufferedWriter pw = new BufferedWriter(fw);) {
			pw.write(frase);
			pw.newLine();
			pw.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<String> listar(){
		try (FileReader fr = new FileReader(NOMBRE_FICHERO); 
				BufferedReader br = new BufferedReader(fr);) {
			List<String> list = new ArrayList<>();
			String frase = br.readLine();
			while (frase != null) {
				list.add(frase);
				frase = br.readLine();
			}
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String obtenerFraseAleatoria() {
		List<String> listaFrases = listar();
		String fraseRandom = null;
		Random rand = new Random(System.nanoTime());
		
		if (!listaFrases.isEmpty()) {
			int random = rand.nextInt(listaFrases.size());
			fraseRandom = listaFrases.get(random);
		} 
		
		return fraseRandom;
	}
}
