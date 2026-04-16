package sv.edu.udb.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "alumno_materia")
public class AlumnoMateria {

    //Primary KEY
    @EmbeddedId
    private AlumnoMateriaId id; //traemos clas AlumnoMateriaId

    //Foreign KEYs
    @ManyToOne
    @MapsId("idAlumno")
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @MapsId("idMateria")
    @JoinColumn(name = "id_materia")
    private Materia materia;

    public AlumnoMateria() {
    }

    public AlumnoMateria(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
        //traemos objetos alumno y materia extare IDs y
        // crea objeto AlumnoMateriId
        this.id= new AlumnoMateriaId(alumno.getId(), materia.getId());
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }
}
