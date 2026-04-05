package prieto.manuel.maven.peluqueriacanina.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Manuel Prieto
 */
@Entity
@Table(name = "mascota")
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_cliente;

    private String nombreMascota;
    private String raza;
    private String color;
    private String alergico;
    private String atencionEspecial;
    private String observaciones;

    //ManyToOne -> muchas mascotas pueden apuntar al mismo Responsable
    // Jpa genera la columna 'responsable_id' (FK) en la tabla mascota
    // Sin esto Jpa no sabria que debe crear esa FK
    // Trataria a reponsable como un campo normal y fallaria
    @ManyToOne
    private Responsable responsable;

    public Mascota() {
    }

    public Mascota(int num_cliente, String nombreMascota, String raza, String color, String alergico, String atencionEspecial, String observaciones, Responsable responsable) {
        this.num_cliente = num_cliente;
        this.nombreMascota = nombreMascota;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencionEspecial = atencionEspecial;
        this.observaciones = observaciones;
        this.responsable = responsable;
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencionEspecial() {
        return atencionEspecial;
    }

    public void setAtencionEspecial(String atencionEspecial) {
        this.atencionEspecial = atencionEspecial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Mascota{" + "num_cliente=" + num_cliente
                + ", nombreMascota=" + nombreMascota
                + ", responsable="
                + responsable + '}';
    }

}
