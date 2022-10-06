import utez.Service;
import utez.ServiceService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SoapClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();

        // String response = port.responseMessage(scanner.nextLine());
        // System.out.println(response);


        //System.out.println("Ingresa el numero: ");
        //  int n = scanner.nextInt();

        // System.out.println(port.guessNumber(n));

        //  System.out.println("Ingresa la cadena: ");
        // String cadena = scanner.next();
        //   System.out.println(port.characters(cadena));

        int opc = 0;
       do {
                System.out.println("1.- RFC");
                System.out.println("2.- Numero");
                System.out.println("3.- Cadena");
                System.out.println("4.- Salir");
                System.out.println("Ingresa una opcion: ");
                opc = scanner.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("Ingresa el nombre: ");
                        String name = scanner.next();
                        System.out.println("Ingresa el apellido paterno: ");
                        String apellidoP = scanner.next();
                        System.out.println("Ingresa el apellido materno: ");
                        String apellidoM = scanner.next();
                        System.out.println("Ingresa la fecha de nacimiento: ");
                        String dateBirth = scanner.next();
                        System.out.println(port.getRfc(name, apellidoP, apellidoM, dateBirth));
                        break;
                    case 2:
                        System.out.println("Ingresa el numero: ");
                        int n = scanner.nextInt();
                        System.out.println(port.guessNumber(n));
                        break;

                    case 3:
                        System.out.println("Ingresa la cadena sin espacios: ");
                        String cadena = scanner.next();
                        System.out.println(port.characters(cadena));
                        break;
                    case 4:
                        System.out.println("Adios");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } while (opc != 4);
    }

}



