package ModeloDatos;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class Ponderado extends Crud {

    private String nombre;
    private int numAcciones;
    private double precio;
    private int idUsuario;
    private int idPartida;

    public Ponderado() {
    }

    public Ponderado(String nombre, int numAcciones, double precio) {
        this.nombre = nombre;
        this.numAcciones = numAcciones;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumAcciones() {
        return numAcciones;
    }

    public void setNumAcciones(int numAcciones) {
        this.numAcciones = numAcciones;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public double sacarPonderado(double precioReal, int numAccionesReal, double precioGuardado, int numAccionesGuardado) {
        double resultado = 0;
        DecimalFormat formateador = new DecimalFormat("###0.##");

        resultado = ((numAccionesGuardado * precioGuardado) + (numAccionesReal * precioReal)) / (numAccionesGuardado + numAccionesReal);
            
        try {
            resultado = formateador.parse(formateador.format(resultado)).doubleValue();
        } catch (ParseException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
        
        return resultado;
    }

    public int update(Compras compras) {
        double ponderado = sacarPonderado(compras.getPrecioCompra(), compras.getCantidad(), this.getPrecio(), this.getNumAcciones());

        String query = "UPDATE ponderado\n"
                + "SET numAcciones = numAcciones + '" + this.getNumAcciones() + "', precio = '" + ponderado + "'\n"
                + "WHERE nombreEmpresa = '" + this.getNombre() + "' AND idUsuario = '" + this.getIdUsuario() + "' AND idPartida = '" + this.getIdPartida() + "';";
        int num = 0;

        num = updateBD(query);

        return num;
    }

    public int insert() {
        String query = "INSERT INTO ponderado VALUES(?,?,?,?,?,?);";
        ArrayList<Object> array = new ArrayList<>();
        int num = 0;

        array.clear();
        array.add(maximo("ponderado", "id") + 1);
        array.add(this.getIdUsuario());
        array.add(this.getNombre());
        array.add(this.getNumAcciones());
        array.add(this.getPrecio());
        array.add(this.getIdPartida());

        num = insertatPSBD(query, array);

        return num;
    }

    @Override
    public String toString() {
        return "Ponderado{" + "nombre=" + nombre + ", numAcciones=" + numAcciones + ", precio=" + precio + '}';
    }
}
