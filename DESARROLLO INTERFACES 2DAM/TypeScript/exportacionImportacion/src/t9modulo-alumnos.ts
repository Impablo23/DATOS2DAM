//Importamos los las funciones e interfaces de el otro archivo .ts
import {matricularAlumno, mostrarAlumnos, direccionInstituto } from "./t9modulo-instituto";
import type { Alumno,Instituto } from "./t9modulo-instituto";

//Creamos un alumno 1 y le añadimos los datos
const alumno1: Alumno = {
    nombre: "Juan",
    edad: 16,
    sexo: "Masculino",
    ensenanza: {
        nivel: "Secundaria",
        esObligatoria: true,
        familiaProfesional: "",
        modalidad: "Mañana"
    },
    direccion: {
        calle: "Calle Playamar",
        CP: "22222",
        localidad: "Torremolinos",
        provincia: "Malaga"
    }
};
//Creamos un alumno 2 y le añadimos los datos
const alumno2: Alumno = {
    nombre: "María",
    edad: 17,
    sexo: "Femenino",
    ensenanza: {
        nivel: "Bachillerato",
        esObligatoria: true,
        familiaProfesional: "",
        modalidad: "Tarde"
    },
    direccion: {
        calle: "Avenida Playamar",
        CP: "11111",
        localidad: "Torremolinos",
        provincia: "Malaga"
    }
};
//Creamos un instituto y le añadimos los datos
const instituto: Instituto = {
    nombre: "Instituto Playamar",
    director: "Miguel",
    telefono: "111-222-333",
    correo: "info@institutoplayamar.com",
    direccion: {
        calle: "Calle de la Educación 789",
        CP: "54321",
        localidad: "Ciudad C",
        provincia: "Provincia Z"
    },
    alumnos: []
};

//Matriculamos mediante la funcion exportada los datos de los alumnos insertados anteriormente 
matricularAlumno(alumno1, instituto);
matricularAlumno(alumno2, instituto);

//Mostramos mediante la funcion exportada los datos de los alumnos que esten en el instituto añadido anteriormente
mostrarAlumnos(instituto);
//Mostramos la direccion del instituto
direccionInstituto(instituto);
