import java.util.Scanner;

public class Entrada {
    private static final Scanner scanner =new Scanner(System.in);

    //Metodo Leer Double

    public static double leerPrecio(String mensaje) {
        double valor;

        while (true) {
            System.out.println(mensaje);
            if (scanner.hasNextDouble()){
                valor = scanner.nextDouble();
                scanner.nextLine(); //Limpiar el salto de linea
                return valor;
            }else {
                System.out.println("Ingrese un número valido, ejmeplo (12,56)");
                scanner.nextLine();//descartar entrada valida
            }
        }
    }

    //Leer Entrada int

    public static int leerCantidad(String mensaje) {

        int valor;

        while (true) {
            System.out.println(mensaje);
            if (scanner.hasNextInt()){
                  valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }else {
                System.out.println("Ingrese un numero valido");
                scanner.nextLine();
            }
        }

    }

    public static int leerEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                numero = Integer.parseInt(scanner.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    public static String leerNombre(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();

    }

}
