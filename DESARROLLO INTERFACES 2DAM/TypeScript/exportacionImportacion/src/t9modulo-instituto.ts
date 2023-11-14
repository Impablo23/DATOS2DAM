// Declaramos la interfaz Direccion con sus respectivos atributos
interface Direccion {
    calle: string;
    CP: string;
    localidad: string;
    provincia: string;
}
// Declaramos la interfaz Ensenanza con sus respectivos atributos
interface Ensenanza {
    nivel: string;
    esObligatoria: boolean;
    familiaProfesional: string;
    modalidad: string;
}
// Declaramos la interfaz Alumno con sus respectivos atributos
interface Alumno {
    nombre: string;
    edad: number;
    sexo: string;
    ensenanza: Ensenanza;
    direccion: Direccion;
}
// Declaramos la interfaz Instituto con sus respectivos atributos
interface Instituto {
    nombre: string;
    director: string;
    telefono: string;
    correo: string;
    direccion: Direccion;
    alumnos: Alumno[];
}

//Creamos una funcion que pide por parametros un alumno y un instituto
function matricularAlumno(alumno: Alumno, instituto: Instituto): void {
    instituto.alumnos.push(alumno);
}

//Creamos una funcion que pide por parametros el instituto y devuelve los datos de los alumnos matriculados en ense instituto
function mostrarAlumnos(instituto: Instituto): void {
    console.log("Alumnos del instituto:");
    for (const alumno of instituto.alumnos) {
        console.log(`Nombre: ${alumno.nombre}, Nivel: ${alumno.ensenanza.nivel}, Localidad: ${alumno.direccion.localidad}`);
    }
}

//Creamos una funcion que pide el instituto y devuelve la direccion completa del instituto
function direccionInstituto(instituto: Instituto): void {
    console.log("Dirección del instituto:");
    console.log(`${instituto.direccion.calle}, ${instituto.direccion.CP}, ${instituto.direccion.localidad}, ${instituto.direccion.provincia}`);
}

//Exportamos las funciones e interfaces oara poder usarlas en el otro archivo .ts
export { matricularAlumno, mostrarAlumnos, direccionInstituto };
export type { Alumno, Instituto,Direccion,Ensenanza };

