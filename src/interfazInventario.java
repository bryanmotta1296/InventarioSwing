import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class interfazInventario {

    // Lista global de productos
    private ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        new interfazInventario().crearVentana();
    }

    public void crearVentana() {
        // ---------- VENTANA PRINCIPAL ----------
        JFrame ventana = new JFrame("Gestor de Inventario");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(700, 500);
        ventana.setLocationRelativeTo(null); // Centrado
        ventana.setLayout(new BorderLayout(10, 10));

        // ---------- TITULO ----------
        JLabel titulo = new JLabel("Gestor de Inventario", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ventana.add(titulo, BorderLayout.NORTH);

        // ---------- PANEL IZQUIERDO: FORMULARIO ----------
        JPanel panelFormulario = new JPanel(new GridLayout(8, 1, 5, 5));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelFormulario.setPreferredSize(new Dimension(300, 0));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField();

        JLabel lblCantidad = new JLabel("Cantidad:");
        JTextField txtCantidad = new JTextField();

        JLabel lblDescripcion = new JLabel("Descripción:");
        JTextField txtDescripcion = new JTextField();

        panelFormulario.add(lblNombre);
        panelFormulario.add(txtNombre);
        panelFormulario.add(lblPrecio);
        panelFormulario.add(txtPrecio);
        panelFormulario.add(lblCantidad);
        panelFormulario.add(txtCantidad);
        panelFormulario.add(lblDescripcion);
        panelFormulario.add(txtDescripcion);

        ventana.add(panelFormulario, BorderLayout.WEST);

        // ---------- PANEL CENTRAL: AREA DE PRODUCTOS ----------
        JTextArea areaProductos = new JTextArea();
        areaProductos.setEditable(false);
        areaProductos.setFont(new Font("Consolas", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(areaProductos);
        scroll.setBorder(BorderFactory.createTitledBorder("Productos registrados"));
        ventana.add(scroll, BorderLayout.CENTER);

        // ---------- PANEL INFERIOR: BOTONES ----------
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnAgregar = new JButton("Agregar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnEditar = new JButton("Editar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnEditar);

        ventana.add(panelBotones, BorderLayout.SOUTH);

        // ---------- EVENTOS DE BOTONES ----------

        // Agregar producto
        btnAgregar.addActionListener(e -> {
            try {
                String nombre = txtNombre.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                int cantidad = Integer.parseInt(txtCantidad.getText());
                String descripcion = txtDescripcion.getText();

                Producto nuevo = new Producto(nombre, precio, cantidad, descripcion);
                productos.add(nuevo);

                JOptionPane.showMessageDialog(ventana, "✅ Producto agregado correctamente");

                // Limpiar campos
                txtNombre.setText("");
                txtPrecio.setText("");
                txtCantidad.setText("");
                txtDescripcion.setText("");

                // Actualizar área de productos
                mostrarProductos(areaProductos);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ventana, "❌ Error: ingrese valores válidos");
            }
        });

        // Mostrar todos los productos
        btnMostrar.addActionListener(e -> mostrarProductos(areaProductos));

        // Buscar producto
        btnBuscar.addActionListener(e -> {
            String buscado = JOptionPane.showInputDialog(ventana, "Ingrese nombre a buscar:");
            if (buscado == null || buscado.trim().isEmpty()) return;
            boolean found = false;
            for (Producto p : productos) {
                if (p.getNombre().equalsIgnoreCase(buscado.trim())) {
                    areaProductos.setText("🔍 Producto encontrado:\n");
                    areaProductos.append("Nombre: " + p.getNombre() + "\n");
                    areaProductos.append("Precio: $" + p.getPrecio() + "\n");
                    areaProductos.append("Cantidad: " + p.getCantidad() + "\n");
                    areaProductos.append("Descripción: " + p.getDescripcion() + "\n");
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(ventana, "Producto no encontrado");
            }
        });

        // Eliminar producto
        btnEliminar.addActionListener(e -> {
            String eliminar = JOptionPane.showInputDialog(ventana, "Ingrese nombre a eliminar:");
            if (eliminar == null || eliminar.trim().isEmpty()) return;
            Producto toRemove = null;
            for (Producto p : productos) {
                if (p.getNombre().equalsIgnoreCase(eliminar.trim())) {
                    toRemove = p;
                    break;
                }
            }
            if (toRemove != null) {
                productos.remove(toRemove);
                JOptionPane.showMessageDialog(ventana, "Producto eliminado");
                mostrarProductos(areaProductos);
            } else {
                JOptionPane.showMessageDialog(ventana, "Producto no encontrado");
            }
        });

        // Editar producto
        btnEditar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(ventana, "Ingrese nombre a editar:");
            if (nombre == null || nombre.trim().isEmpty()) return;
            for (Producto p : productos) {
                if (p.getNombre().equalsIgnoreCase(nombre.trim())) {
                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", p.getNombre());
                    double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", p.getPrecio()));
                    int nuevasUnidades = Integer.parseInt(JOptionPane.showInputDialog("Nuevas unidades:", p.getCantidad()));
                    String nuevaDescripcion = JOptionPane.showInputDialog("Nueva descripción:", p.getDescripcion());

                    p.setNombre(nuevoNombre);
                    p.setPrecio(nuevoPrecio);
                    p.setCantidad(nuevasUnidades);
                    p.setDescripcion(nuevaDescripcion);

                    JOptionPane.showMessageDialog(ventana, "Producto actualizado");
                    mostrarProductos(areaProductos);
                    return;
                }
            }
            JOptionPane.showMessageDialog(ventana, "Producto no encontrado");
        });

        ventana.setVisible(true);
    }

    // ---------- FUNCION MOSTRAR PRODUCTOS ----------
    private void mostrarProductos(JTextArea areaProductos) {
        if (productos.isEmpty()) {
            areaProductos.setText("No hay productos registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append("Nombre: ").append(p.getNombre()).append("\n");
            sb.append("Precio: $").append(p.getPrecio()).append("\n");
            sb.append("Cantidad: ").append(p.getCantidad()).append("\n");
            sb.append("Descripción: ").append(p.getDescripcion()).append("\n");
            sb.append("-----------------------------\n");
        }
        areaProductos.setText(sb.toString());
    }

}




