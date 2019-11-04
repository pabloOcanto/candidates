package ar.com.fluxit.candidatos.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Pablo on 2/11/2019.
 */
@Entity
@Table(name = "CANDIDATO")
public class CandidatoEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CANDIDATO_ID")
    private int id;
    @NotNull(message = "nombre no puede ser nulo")
    @Column(name = "NOMBRE_APELLIDO")
    private String nombre;
    @NotNull(message = "dni no puede ser nulo")
    @Column(name = "DNI")
    private String dni;
    @NotNull(message = "fecha nacimiento no puede ser nulo")
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimento;
    @NotNull(message = "domicilio no puede ser nulo")
    @Column(name = "DOMICILIO")
    private String domicilio;
    @NotNull(message = "telefono no puede ser nulo")
    @Column(name = "TELEFONO")
    private String telefono;
    @NotNull(message = "email no puede ser nulo")
    @Column(name = "EMAIL")
    private String email;

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimento() {
        return fechaNacimento;
    }

    public void setFechaNacimento(Date fechaNacimento) {
        this.fechaNacimento = fechaNacimento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
