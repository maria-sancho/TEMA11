import java.io.*;
import java.util.*;

public class OrdenaNombres {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        try {
            FileInputStream fis = new FileInputStream("nombres.txt");
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                nombres.add(sc.nextLine());
            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String nombre;
        do {
            System.out.print("Introduzca un nombre (o 'fin' para terminar): ");
            nombre = scanner.nextLine();

            if (!nombre.equalsIgnoreCase("fin")) {
                int indice = 0;
                while (indice < nombres.size() && nombres.get(indice).compareToIgnoreCase(nombre) < 0) {
                    indice++;
                }
                nombres.add(indice, nombre);
            }
        } while (!nombre.equalsIgnoreCase("fin"));

        scanner.close();

        try {
            FileOutputStream fos = new FileOutputStream("nombres.txt");
            PrintWriter pw = new PrintWriter(fos);

            for (String n : nombres) {
                pw.println(n);
            }

            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
