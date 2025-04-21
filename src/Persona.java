import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private List<Perro> perrosAdoptados;

    public Persona(String nombre, String apellido, int edad, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perrosAdoptados = new ArrayList<>();
    }

    public String getDocumento() {
        return documento;
    }

    public boolean adoptarPerro(Perro perro) {
        if (perrosAdoptados.size() < 3) {
            perrosAdoptados.add(perro);
            return true;
        }
        return false;
    }

    public Perro perroMasGrande() {
        if (perrosAdoptados.isEmpty()) return null;

        Perro mayor = perrosAdoptados.get(0);
        for (Perro p : perrosAdoptados) {
            if (p.getEdad() > mayor.getEdad()) {
                mayor = p;
            }
        }
        return mayor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append(" ").append(apellido)
                .append(", Edad: ").append(edad).append(", Documento: ").append(documento)
                .append("\nPerros adoptados:\n");
        if (perrosAdoptados.isEmpty()) {
            sb.append("  Ninguno\n");
        } else {
            for (Perro p : perrosAdoptados) {
                sb.append("  - ").append(p.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
