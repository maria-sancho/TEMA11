import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OrdenaNumeros {

    public static void main(String[] args) {
        String archivoEntrada = "numeros.dat";
        String archivoPares = "pares.dat";
        String archivoImpares = "impares.dat";
        try (DataInputStream lector = new DataInputStream(new FileInputStream(archivoEntrada));
             DataOutputStream escritorPares = new DataOutputStream(new FileOutputStream(archivoPares));
             DataOutputStream escritorImpares = new DataOutputStream(new FileOutputStream(archivoImpares))) {
            while (lector.available() > 0) {
                int numero = lector.readInt();
                if (numero % 2 == 0) {
                    escritorPares.writeInt(numero);
                } else {
                    escritorImpares.writeInt(numero);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en archivo.");
        }
    }
}
