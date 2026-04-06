package prieto.manuel.maven.clinicaveterinaria.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Manuel Prieto
 */
@Entity
// Especifica el nombre exacto de la tabla en MySQL
@Table(name = "responsable")
public class Responsable implements Serializable {

    //Version explicita del contrato de serializacion
    //Sin esto, java lo recalcula en cada cambio, rompiendo obj serializados anteriormente
    private static final long serialVersionUID = 1L;

    @Id
    //Usamos Sequence para obtener el proximo Id
    // Es el mas portable entre motores de BD como por ej: oracle, postgreSQL, mySQl
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String nombre;
    private String celResponsable;

    //Constructor vacio obligatorio en JPA
    //JPA necesita instanciar la clase para crear el obj en tiempo de ejecucion
    // Asi invocarlo de manera generica sin parametros para rellenar los campos
    // con los valores de la BD usando setters o acceso directo a los atributos
    public Responsable() {
    }

    public Responsable(int id, String nombre, String celResponsable) {
        this.id = id;
        this.nombre = nombre;
        this.celResponsable = celResponsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelResponsable() {
        return celResponsable;
    }

    public void setCelResponsable(String celResponsable) {
        this.celResponsable = celResponsable;
    }

    @Override
    public String toString() {
        return "Responsable{" + "id=" + id + ", nombre=" + nombre + ", celResponsable=" + celResponsable + '}';
    }

}
