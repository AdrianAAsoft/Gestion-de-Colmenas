public class GestorApicultores {

    // Método para registrar un apicultor
    public static void registrarApicultor(DatosApicola datosApicola) {
        System.out.println("\n🐝 REGISTRO DE NUEVO APICULTOR");

        try {
            // Solicitar el nombre del apicultor
            String nombre = Utils.solicitarCampo("Ingrese el nombre del apicultor: ");
    
            // Validar que el nombre no esté vacío
            if (nombre.isEmpty()) {
                System.out.println("⚠️ El nombre no puede estar vacío. Intenta nuevamente.");
                return;
            }
    
            // Solicitar la edad del apicultor
            int edad = obtenerEdad();
    
            // Solicitar los años de experiencia del apicultor
            int aniosExperiencia = obtenerAniosExperiencia();
    
            // Crear un nuevo objeto apicultor con los datos proporcionados
            Apicultor nuevoApicultor = new Apicultor(nombre, edad, aniosExperiencia);
    
            // Agregar el nuevo apicultor al conjunto de apicultores
            datosApicola.agregarApicultor(nuevoApicultor);
    
            // Confirmar que el apicultor fue registrado correctamente
            System.out.println("✅ Apicultor registrado correctamente.");
        } catch (Exception e) {
            // Capturar cualquier error inesperado
            System.out.println("❌ Error al registrar al apicultor: " + e.getMessage());
        }
    }

    // Método para obtener la edad del apicultor con validación
    private static int obtenerEdad() {
        int edad = -1;
        while (edad < 18) {
            try {
                edad = Integer.parseInt(Utils.solicitarCampo("Ingrese la edad del apicultor (mayor de 18): "));
                if (edad < 18) {
                    System.out.println("⚠️ El apicultor debe ser mayor de 18 años.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Por favor, ingrese un número válido para la edad.");
            }
        }
        return edad;
    }

    // Método para obtener los años de experiencia del apicultor con validación
    private static int obtenerAniosExperiencia() {
        int aniosExperiencia = -1;
        while (aniosExperiencia < 0) {
            try {
                aniosExperiencia = Integer.parseInt(Utils.solicitarCampo("Ingrese los años de experiencia del apicultor: "));
                if (aniosExperiencia < 0) {
                    System.out.println("⚠️ Los años de experiencia no pueden ser negativos.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Por favor, ingrese un número válido para los años de experiencia.");
            }
        }
        return aniosExperiencia;
    }
}
