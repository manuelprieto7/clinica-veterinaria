package prieto.manuel.maven.peluqueriacanina.logica;

import prieto.manuel.maven.peluqueriacanina.persistencia.ControladoraPersistencia;

/**
 *
 * @author Manuel Prieto
 */
public class Controladora {

    // Unica referencia a la capa de persistencia
    // llama a la Cpersitencia -> para delegar todas las operaciones de BD
    private final ControladoraPersistencia cp = new ControladoraPersistencia();

    //Create
    public void guardar(String nombreMascota, String raza, String color,
            String alergico, String atencionEspecial,
            String observaciones, String nombreResponsable,
            String celResponsable) {
        //Validacion en capa logica

        if (nombreMascota == null || nombreMascota.isBlank()) {
            throw new IllegalArgumentException("El nombre de la mascota no puede estar vacío.");
        }
        if (nombreResponsable == null || nombreResponsable.isBlank()) {
            throw new IllegalArgumentException("El nombre del responsable no puede estar vacío.");
            
        }

        // Construccion del responsable en memoria
        Responsable responsable = new Responsable();
        responsable.setNombre(nombreResponsable);
        responsable.setCelResponsable(celResponsable);

        // Construcción de la Mascota en memoria.
        Mascota mascota = new Mascota();
        mascota.setNombreMascota(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEspecial);
        mascota.setObservaciones(observaciones);

        // Se establece relacion ManytoOne en memoria
        // cuando Jpa persista la mascota, leera el id del responsable
        // para escribir la FK responsable_id en la tabla mascota
        mascota.setResponsable(responsable);

        // llama a guardar en la controladoraP
        // persiste responsable y mascota en una sola transaccion
        cp.guardar(responsable, mascota);
        
    }

    // Read - una mascota por ID
    public Mascota traerMascota(int numCliente) {
        
        return cp.traerMascota(numCliente);
        
    }

    // Update
    public void modificarMascota(Mascota mascota, String nombreMascota,
            String raza, String color, String alergico,
            String atencionEspecial, String observaciones,
            String nombreResponsable, String celResponsable) {
        
        if (nombreMascota == null || nombreMascota.isBlank()) {
            throw new IllegalArgumentException("El nombre de la mascota no puede estar vacío.");
        }

        // Se actualizan los campos del objeto que ya vino de la BD
        // No creamos un objeto nuevo - modificamos el existente para
        // que Jpa pueda hacer merge con el Id correcto
        mascota.setNombreMascota(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEspecial);
        mascota.setObservaciones(observaciones);

        // Se obtiene el responsable asociado para actualizarlo tambien
        Responsable responsable = mascota.getResponsable();
        responsable.setNombre(nombreResponsable);
        responsable.setCelResponsable(celResponsable);

        // Llama a modificarMascota en la Cpersitencia
        // para hacer merge en ambos objetos en una sola transaccion
        cp.modificarMascota(mascota, responsable);
        
    }

    //Delete 
    public void borrarMascota(int numCliente) {
        // Llama a borrar mascota de la Cpersitencia
        cp.borrarMascota(numCliente);
    }
    
}
