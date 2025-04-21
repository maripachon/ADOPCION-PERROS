import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        List<Perro> perrosDisponibles = new ArrayList<>();

        int opcion;
        int edad;

        do {
            System.out.println("\n--- MENÚ SISTEMA DE ADOPCIÓN ---");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar perro");
            System.out.println("3. Ver personas registradas");
            System.out.println("4. Ver perros disponibles");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Consultar el perro más viejo adoptado");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();
                System.out.print("Edad: ");
                edad = sc.nextInt();
                sc.nextLine();
                System.out.print("Documento: ");
                String documento = sc.nextLine();

                personas.add(new Persona(nombre, apellido, edad, documento));
                System.out.println("Persona registrada.");

            } else if (opcion == 2) {
                System.out.print("Placa: ");
                String placa = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Raza: ");
                String raza = sc.nextLine();
                System.out.print("Edad: ");
                edad = sc.nextInt();
                sc.nextLine();
                System.out.print("Tamaño: ");
                String tamaño = sc.nextLine();

                perrosDisponibles.add(new Perro(placa, nombre, raza, edad, tamaño));
                System.out.println("Perro registrado.");

            } else if (opcion == 3) {
                if (personas.isEmpty()) {
                    System.out.println("No hay personas registradas.");
                } else {
                    for (Persona p : personas) {
                        System.out.println(p);
                    }
                }

            } else if (opcion == 4) {
                if (perrosDisponibles.isEmpty()) {
                    System.out.println("No hay perros disponibles.");
                } else {
                    for (Perro p : perrosDisponibles) {
                        System.out.println(p);
                    }
                }

            } else if (opcion == 5) {
                System.out.print("Documento de la persona: ");
                String documento = sc.nextLine();
                Persona persona = null;
                for (Persona p : personas) {
                    if (p.getDocumento().equalsIgnoreCase(documento)) {
                        persona = p;
                        break;
                    }
                }

                if (persona == null) {
                    System.out.println("Persona no encontrada.");
                    continue;
                }

                System.out.print("Placa del perro a adoptar: ");
                String placa = sc.nextLine();
                Perro perro = null;
                for (Perro p : perrosDisponibles) {
                    if (p.getPlaca().equalsIgnoreCase(placa)) {
                        perro = p;
                        break;
                    }
                }
                if (perro == null) {
                    System.out.println("Perro no disponible o ya adoptado.");
                    continue;
                }

                if (persona.adoptarPerro(perro)) {
                    perrosDisponibles.remove(perro);
                    System.out.println("Perro adoptado exitosamente.");
                } else {
                    System.out.println("No puede adoptar más perros (máximo 3).");
                }

            } else if (opcion == 6) {
                System.out.print("Documento de la persona: ");
                String documento = sc.nextLine();
                Persona persona = null;
                for (Persona p : personas) {
                    if (p.getDocumento().equalsIgnoreCase(documento)) {
                        persona = p;
                        break;
                    }
                }

                if (persona == null) {
                    System.out.println("Persona no encontrada.");
                    continue;
                }

                Perro viejo = persona.perroMasGrande();
                if (viejo == null) {
                    System.out.println("La persona no ha adoptado ningún perro.");
                } else {
                    System.out.println("Perro más viejo adoptado:\n" + viejo);
                }

            } else if (opcion == 7) {
                System.out.println("Saliendo...");

            } else {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
