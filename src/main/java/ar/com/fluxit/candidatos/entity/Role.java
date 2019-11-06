package ar.com.fluxit.candidatos.entity;

import javax.persistence.*;

/**
 * Created by Pablo on 5/11/2019.
 */
@Entity
@Table(name = "ROL")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROL_ID")
    private int id;
    @Column(name = "ROL")
    private String name;
    @ManyToOne
    @JoinColumn(name = "USUARIO")
    private UserEntity userEntity;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
