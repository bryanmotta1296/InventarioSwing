public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private String descripcion;

    //Constructor

    public Producto(String nombre, double precio, int cantidad, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    //GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {

            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                this.nombre = nombre;
                return true;
            } else {
                System.out.println("El nombre no es valido");
                return false;
            }

    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        }else{
            System.out.println("El precio no es valido, debe ser mayor a 0");
        }

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        }else {
            System.out.println("La cantidad no es valida, debe ser mayor que 0, vuelva a intentarlo");
        }

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double calcularTotal(){
        return cantidad * precio;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Total: " + calcularTotal());
    }



}
