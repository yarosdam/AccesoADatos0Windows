package AccesoADatos0Windows;

import java.util.InputMismatchException;
import java.util.Scanner;

import lectores.LectorCsv;

public class Controlador {
	private Scanner lector;
	private LectorCsv lectorCsv;
	
	public Controlador() {
		lector = new Scanner(System.in);
		lectorCsv = new LectorCsv();
	}
	
	public void menu() {
		System.out.println(menuString());
		ejecutar(leerEleccion());
	}

	public String menuString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Lector de datos - Sprint 1\n");
		builder.append("Selecciona una opcion\n");
		builder.append("1. Leer TXT\n");
		builder.append("2. Leer CSV\n");
		builder.append("3. Leer XML\n");
		builder.append("0. Salir\n");
		return builder.toString();
	}

	public int leerEleccion() {
		int num = 0;
		while (true) {
			try {
				while (true) {
					num = lector.nextInt();
					if (num < 0 && num > 3) {
						System.out.println("Introduce un numero entre 0 y 3");
						continue;
					} else
						break;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Opcion invalida, introduce el numero otra vez");
				continue;
			}
		}
		return num;
	}
	
	public boolean ejecutar(int numero) {
		switch (numero) {
		case 0:
			System.exit(0);
		case 1:
			
		case 2:
			lectorCsv.setRecords(lectorCsv.cargarCsv("MOCK_DATA.csv"));
			lectorCsv.setCampos(lectorCsv.cargarCamposCsv());
			System.out.println(lectorCsv.leerPosicion(5));
		case 3:
		}
		return true;
	}
}
