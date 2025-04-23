import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        List<Perro> perrosDisponibles = new ArrayList<>();

        int opcion;
        int edad;
        int edadPerro;
        String nombre;
        String apellido;
        String documento;
        String placa;
        String nombrePerro;
        String raza;
        String tamaño;
        String placaBuscar;
        String docConsulta;
        String doc;

        do {
            System.out.println("\n--- MENÚ SISTEMA DE ADOPCIÓN ---");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar perro");
            System.out.println("3. Ver personas registradas");
            System.out.println("4. Ver perros disponibles");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Consultar el perro más viejo adoptado por una persona");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.print("Edad: ");
                    edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Documento: ");
                    documento = sc.nextLine();
                    personas.add(new Persona(nombre, apellido, edad, documento));
                    System.out.println("Persona registrada.");
                    break;

                case 2:
                    System.out.print("Placa: ");
                    placa = sc.nextLine();
                    System.out.print("Nombre del perro: ");
                    nombrePerro = sc.nextLine();
                    System.out.print("Raza: ");
                    raza = sc.nextLine();
                    System.out.print("Edad: ");
                    edadPerro = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tamaño: ");
                    tamaño = sc.nextLine();
                    perrosDisponibles.add(new Perro(placa, nombrePerro, raza, edadPerro, tamaño));
                    System.out.println("Perro registrado.");
                    break;

                case 3:
                    if (personas.isEmpty()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        for (Persona p : personas) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    if (perrosDisponibles.isEmpty()) {
                        System.out.println("No hay perros disponibles.");
                    } else {
                        for (Perro p : perrosDisponibles) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Documento de la persona: ");
                    doc = sc.nextLine();
                    Persona persona = buscarPersona(personas, doc);
                    if (persona == null) {
                        System.out.println("Persona no encontrada.");
                        break;
                    }

                    System.out.print("Placa del perro a adoptar: ");
                    placaBuscar = sc.nextLine();
                    Perro perro = buscarPerro(perrosDisponibles, placaBuscar);
                    if (perro == null) {
                        System.out.println("Perro no disponible.");
                        break;
                    }

                    if (persona.adoptarPerro(perro)) {
                        perrosDisponibles.remove(perro);
                        System.out.println("Perro adoptado con éxito.");
                    } else {
                        System.out.println("Esta persona ya adoptó el máximo de perros (3).");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese documento de la persona: ");
                    docConsulta = sc.nextLine();
                    Persona Consulta = buscarPersona(personas, docConsulta);
                    if (Consulta == null) {
                        System.out.println("Persona no encontrada.");
                    } else {
                        Perro mayor = Consulta.perroMasGrande();
                        if (mayor == null) {
                            System.out.println("La persona no ha adoptado ningún perro aún.");
                        } else {
                            System.out.println("El perro más viejo adoptado por " + Consulta.getNombre() + " es:");
                            System.out.println("" + mayor);
                        }
                    }
                    break;

                case 7:
                    System.out.println("👋 ¡Gracias por usar el sistema de adopción!");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 7);
        sc.close();
    }

    public static Persona buscarPersona(List<Persona> personas, String documento) {
        for (Persona p : personas) {
            if (p.getDocumento().equalsIgnoreCase(documento)) {
                return p;
            }
        }
        return null;
    }

    public static Perro buscarPerro(List<Perro> perros, String placa) {
        for (Perro p : perros) {
            if (p.getPlaca().equalsIgnoreCase(placa)) {
                return p;
            }
        }
        return null;
    }
}
