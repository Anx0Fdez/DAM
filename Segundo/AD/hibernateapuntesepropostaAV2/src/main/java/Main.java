public class Main {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();

        // Inserir unha nova persoa
        Persona persona1 = new Persona();
        persona1.setId(4L);
        persona1.setNome("Carlos");
        persona1.setApelido("Gomez");
        persona1.setSalario(2500.0);
        personaDAO.gardarPersona(persona1);

        // Modificar unha persoa existente
        persona1.setSalario(2600.0);
        personaDAO.actualizarPersona(persona1);

        // Eliminar unha persoa
        personaDAO.eliminarPersona(4L);
    }
}