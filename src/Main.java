import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Scanner
       // Scanner scanner = new Scanner(System.in);

        //Lista de Productos
        ArrayList<Producto> productos = new ArrayList<Producto>();

        //Objeto
        Producto producto = new Producto("Sin nombre",0,0,"Sin descripción");

        //Variables
        int opcion;

        //Menú interactivo

        do {
            System.out.println("==========================================");
            System.out.println("     Gestor de Ventas e Inventario");
            System.out.println("==========================================");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Información");
            System.out.println("3. Calcular total del producto");
            System.out.println("4.Salir");
            System.out.println("================================");
            System.out.println("\nIngrese el número de la opción  y presione Enter para continuar");
            opcion = Entrada.leerCantidad("Ingrese la opcion: ");

            //Switch case según la opción elegida por el usuario se ejecuta el código
            switch (opcion) {
                case 1:

                        String nombre = Entrada.leerNombre("Ingrese el nombre del producto");
                        double precio = Entrada.leerPrecio("Ingrese el precio del producto");
                        int cantidad = Entrada.leerCantidad("Ingrese el cantidad de productos");
                        String descricpion = Entrada.leerNombre("Ingrese descripcion del producto");

                        Producto nuevo = new Producto(nombre,precio,cantidad,descricpion);
                        productos.add(nuevo);

                        //Asignar valores al objeto producto
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);
                    producto.setDescripcion(descricpion);

                    System.out.println("Se ha creado el producto:  " + producto.getNombre() + ", Precio:  " +" $ "+ producto.getPrecio() + ", Cantidad: " + producto.getCantidad() + " Desripción: " + producto.getDescripcion());
                    break;
                case 2:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos");
                    }else {
                        for (int i = 0; i < productos.size(); i++) {
                            System.out.println("\nProducto # " + (i + 1));
                            productos.get(i).mostrarInformacion();
                        }
                    }
                    break;
                case 3:
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos");
                    }else {
                        System.out.println("Ingrese el número del producto (1 a) " + productos.size());
                        int index = Entrada.leerEntero("Ingrese el número del producto (1 a " + productos.size() + ")") - 1;

                        if (index >= 0 && index < productos.size()) {
                            Producto p = productos.get(index);
                            System.out.println("Total: $ " + p.calcularTotal());
                        }else {
                            System.out.println("Indice invalido");
                        }

                    }

                    break;
                case 4:
                    System.out.println("Gracias por utilizar el programa");
                    break;
                    default:
                        System.out.println("Opcion no valida, vuelva a elegir la opcion");
            }
        }while ( opcion !=4);


    }


}