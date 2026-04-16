package sv.edu.udb.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {

    //id automático
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    //Constructor vacío
    public Profesor() {
    }

    //constructor con parametros
    public Profesor( String nombre) {
        this.nombre = nombre;
    }

    //Getter y Setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
