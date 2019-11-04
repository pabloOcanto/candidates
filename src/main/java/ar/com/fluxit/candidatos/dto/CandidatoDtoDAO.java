package ar.com.fluxit.candidatos.dto;

/**
 * Created by Pablo on 4/11/2019.
 */
public class CandidatoDtoDAO extends CandidatoDTO {
    private String info;

    public CandidatoDtoDAO(String info, String dni, String nombre) {
        super(nombre, dni);
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
