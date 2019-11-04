package ar.com.fluxit.candidatos.dto;

/**
 * Created by Pablo on 2/11/2019.
 */
public class CandidatoDTO implements Cloneable {
    private static CandidatoDTO instance = null;
    private String nombre;
    private String dni;


    public CandidatoDTO() {
    }

    public CandidatoDTO(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
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
}
