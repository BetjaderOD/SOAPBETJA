import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

@WebService(name = "Service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class Service {
    Scanner sc = new Scanner(System.in);

    @WebMethod(operationName = "responseMessage")
    public String responseMessage(@WebParam(name = "message") String message) {
        return "El mensaje recibido fue... " +  message;
    }

    Random random = new Random();

    @WebMethod(operationName = "guessNumber")


    public String guessNumber(@WebParam(name = "number") int number) {
        int numberram = random.nextInt();
        System.out.println(numberram);
        if (number != numberram) {
            return "Intenta de nuevo";
        }
        return "Correcto";
    }

    @WebMethod(operationName = "characters")
    public String characters(@WebParam(name = "name") String name) {
        char[] consonantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        String cadenanueva = "";
        if (name == null) {
            return "Teclea";
        } else {
            for (int i = 0; i < name.length(); i++) {
                for (int j = 0; j < consonantes.length; j++) {
                    if (name.charAt(i) == consonantes[j]) {
                        cadenanueva += name.charAt(i);
                    }
                }
            }
            return cadenanueva;
        }

    }

    @WebMethod(operationName = "getRfc")
    public String getRfc(@WebParam(name = "name") String name, @WebParam(name = "apellidoP") String apellidoP, @WebParam(name = "apellidoM") String apellidoM, @WebParam(name = "dateBirth") String dateBirth){
        String rfcName = "" + apellidoP.charAt(0) + apellidoP.charAt(1) + apellidoM.charAt(0) + name.charAt(0);
        String datePart = dateBirth.substring(2, 4) + dateBirth.substring(5, 7) + dateBirth.substring(8, 10);

        String alphanumerics = "abcdefghijklmnopqrstuvwxyz1234567890";
        String clave = "";
        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * (alphanumerics.length()) - 1);
            clave += alphanumerics.charAt(randomNumber);
        }
        String rfc = (rfcName + datePart + clave + "").toUpperCase();
        return rfc;
    }
    public static void main(String[] args) {
        System.out.println("Initializaning server...");
        Endpoint.publish("http://localhost:8085/Service?wsdl", new Service());
        System.out.println("Wating request");
    }
}
