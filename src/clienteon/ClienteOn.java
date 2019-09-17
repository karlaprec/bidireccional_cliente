package clienteon;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteOn {

    static String direccionIP;
    static int nsocket;
    static Socket socket;

    public static void main(String[] args){
        try {

            try {
                direccionIP = args[0];
            } 
            catch (Exception e) {
                System.out.println("Escriba una ip valida");
                System.exit(0);
            }

            try {
                nsocket = Integer.parseInt(args[1]);
            } 
            catch (Exception e) {
                System.out.println("Escriba un socket valido");
                System.exit(2);
            }
            try {
                socket = new Socket(direccionIP, nsocket);
            } 
            catch (Exception e) {
                System.out.println("Error al crear socket");
                System.exit(3);
            }
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String datos;
            String datosEntrada;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                if (!(datos = scanner.nextLine()).isEmpty()) {
                    escritor.println(datos);
                    datosEntrada = lector.readLine();
                    System.out.println(datosEntrada);
                } else {
                    System.out.println("Escriba un mensaje valido");
                }
            }
        } catch (IOException e) {
            System.out.println("Reintentar");
        }
    }

}
