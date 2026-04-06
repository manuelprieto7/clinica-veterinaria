package prieto.manuel.maven.clinicaveterinaria.logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

/**
 *
 * @author Manuel Prieto
 */
@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    // fecha de la consulta - localDate mapea a DATE en MySQL
    private LocalDate fechaConsulta;

    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private String veterinario;

    // Muchas consultas pueden pertenecer a la misma mascota
    //  JPA genera la columna MASCOTA_ID (FK) en la tabla consulta
    @ManyToOne
    private Mascota mascota;

    public Consulta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", fechaConsulta=" + fechaConsulta + ", motivo=" + motivo + ", mascota=" + mascota + '}';
    }
    
    

    
        
}
