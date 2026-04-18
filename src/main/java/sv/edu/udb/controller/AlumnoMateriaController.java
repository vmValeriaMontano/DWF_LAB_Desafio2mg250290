package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.domain.Alumno;
import sv.edu.udb.domain.AlumnoMateria;
import sv.edu.udb.domain.Materia;
import sv.edu.udb.repository.AlumnoMateriaRepository;
import sv.edu.udb.repository.AlumnoRepository;
import sv.edu.udb.repository.MateriaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class AlumnoMateriaController {

    @Autowired
    private AlumnoMateriaRepository repo;

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Autowired
    private MateriaRepository materiaRepo;

    @GetMapping
    public List<AlumnoMateria> listar(){
        return repo.findAll();
    }

    @PostMapping
    public AlumnoMateria inscribir(@RequestParam Long alumnoId, @RequestParam Long materiaId){

        Alumno alumno = alumnoRepo.findById(alumnoId).orElseThrow();
        Materia materia = materiaRepo.findById(materiaId).orElseThrow();

        return repo.save(new AlumnoMateria(alumno, materia));
    }

    @DeleteMapping
    public void eliminar(@RequestParam Long alumnoId, @RequestParam Long materiaId){
        repo.deleteById(new sv.edu.udb.domain.AlumnoMateriaId(alumnoId, materiaId));
    }
}