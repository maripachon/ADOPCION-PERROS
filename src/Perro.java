public class Perro {
    private String placa;
    private String nombre;
    private String raza;
    private int edad;
    private String tamaño;

    public Perro(String placa, String nombre, String raza, int edad, String tamaño) {
        this.placa = placa;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamaño = tamaño;
    }
    public int getEdad() {
        return edad;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Nombre: " + nombre + ", Raza: " + raza +
                ", Edad: " + edad + ", Tamaño: " + tamaño;
    }
}
