package prieto.manuel.maven.clinicaveterinaria.persistencia;

import jakarta.persistence.EntityManager;
import java.util.List;
import prieto.manuel.maven.clinicaveterinaria.logica.Consulta;
import prieto.manuel.maven.clinicaveterinaria.logica.Mascota;
import prieto.manuel.maven.clinicaveterinaria.logica.Responsable;

/**
 *
 * @author Manuel Prieto
 */
public class ControladoraPersistencia {

    // Obtiene un EntityManager por operacion
    private EntityManager getEm() {
        return JpaUtil.getEmf().createEntityManager();
    }

    // Create
    public void guardar(Responsable responsable, Mascota mascota) {

        EntityManager em = getEm();

        try {
            // begin: abre la transaccion
            //como unidad atomica -> se guarda o no se guarda
            em.getTransaction().begin();

            // persist(responsable) Jpa registra el responsable
            // eclipseLink genera el Id via Sequence y prepara el INSERT
            // DEBE ir antes que mascota porque mascota necesita
            // el ID del responsable para la FK
            em.persist(responsable);

            //Jpa registra la mascota
            // en este punto ya responsable tiene su Id asignado
            //Jpa lo usa para escribir responsable_id en la tabla mascota
            em.persist(mascota);

            //commit envia ambos INSERT a MySQL de forma definitiva
            //A partir de este momento, los datos quedan persistidos y visibles
            //para todos los clientes que se conecten a la BD
            em.getTransaction().commit();

        } catch (Exception e) {
            // Si cualquier paso fallo, rollback cancela todo
            // la BD queda exactamente igual que antes antes de llamar a guardar
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            // Se relanza para que la capa superior nos informe
            throw new RuntimeException("Error al guardar: " + e.getMessage(), e);

        } finally {
            // SIEMPRE se cierra el EM, haya error o no
            // Sin esto, la conexion queda abierta y 
            //se agota el pool(conjunto de conexiones abiertas a la bd).
        }

    }

    // Crud consulta
    public void guardarConsulta(Consulta consulta) {

        EntityManager em = getEm();

        try {
            em.getTransaction().begin();
            // persist la consulta es nueva - JPA genera su Id
            em.persist(consulta);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw new RuntimeException("Error al guardar la consulta: " + e.getMessage(), e);
        } finally {
            em.close();
        }

    }

    public List<Consulta> traerConsultasPorMascota(int idMascota) {

        EntityManager em = getEm();

        try {
            // JPQL : traemos solo las consultas de la mascota seleccionada
            // filtrando por el Id de mascota en la fk
            return em.createQuery("SELECT c FROM Consulta c WHERE c.mascota.num_cliente = :idMascota",
                    Consulta.class).setParameter("idMascota", idMascota).getResultList();

        } finally {
            em.close();

        }

    }

    // Read - Traer una mascota
    public Mascota traerMascota(int numCliente) {
        EntityManager em = getEm();
        try {
            // find busca por clave primaria, retorna null si no existe
            return em.find(Mascota.class, numCliente);
        } finally {
            em.close();

        }
    }

    // READ — traer todas las mascotas
    public List<Mascota> traerMascotas() {
        EntityManager em = getEm();
        try {
            // JPQL: lenguaje de consulta de JPA opera sobre clases java
            // no sobre tablas SQL, "m" es el alias de Mascota
            return em.createQuery("SELECT m FROM Mascota m", Mascota.class)
                    .getResultList();
        } finally {
            // READ no necesita transacción explícita, pero el EM
            // siempre se cierra para liberar la conexión

            em.close();
        }
    }

    // Read - traer un responsable por Id
    public Responsable traerResponsable(int id) {
        EntityManager em = getEm();

        try {
            return em.find(Responsable.class, id);
        } finally {
            em.close();
        }
    }

    // Update 
    public void modificarMascota(Mascota mascota, Responsable responsable) {

        EntityManager em = getEm();

        try {
            em.getTransaction().begin();

            // merge toma un objeto DETACHED (fuera del contexto JPA)
            // y sincroniza sus cambios con la BD
            // a diferencia de persist, merge funciona con objetos
            // que ya tiene id asignado (ya existe en la BD)
            em.merge(mascota);
            em.merge(responsable);

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al modificar: " + e.getMessage(), e);
        } finally {
            em.close();
        }

    }

    // Delete
    public void borrarMascota(int numCliente) {
        EntityManager em = getEm();

        try {
            em.getTransaction().begin();

            // find dentro de la transaccion retorna un objeto Managed
            // (dentro del contexto JPA) que es lo que remove necesita
            Mascota mascota = em.find(Mascota.class, numCliente);

            if (mascota != null) {
                // remove marca el objeto para la eliminacion
                // El DELETE SQL se ejecuta en el commit
                em.remove(mascota);
                em.getTransaction().commit();
            } else {
                // Si no existe, no hay nada que borrar
                //Cancelamos la transaccion limpiamente
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al borrar: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

}
