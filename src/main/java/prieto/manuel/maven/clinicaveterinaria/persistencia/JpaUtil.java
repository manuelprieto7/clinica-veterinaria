package prieto.manuel.maven.clinicaveterinaria.persistencia;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Manuel Prieto
 */
public class JpaUtil {
    
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("PeluCaninaPU");
    
    public static EntityManagerFactory getEmf(){
        return emf;
    }
    
    public static void cerrar(){
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }

}
