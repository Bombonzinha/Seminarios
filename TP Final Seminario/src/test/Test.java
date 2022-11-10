package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {
		int i=0;
		FileWriter archivoEscribir = new FileWriter("hola.txt", true);
		File archivo = new File("hola.txt");
		Scanner leer = new Scanner(archivo);
		while(leer.hasNextInt()) {
			System.out.print(leer.nextInt() + " ");
			i++;
		}
		archivoEscribir.write(i+" ");
		archivoEscribir.close();
	}

}
