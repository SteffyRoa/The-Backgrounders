const url = "assets/sugerencias.json"

const imgIcono = document.getElementById("img-icono");
let max = 10;
let min = 1;

let icono = Math.random() * (max-min) + min;
icono = parseInt(icono);
imgIcono.src = `assets/images/icono/${icono}.png` 

async function obtenerSugerencias(url) {
    try {
        const respuesta = await fetch(url);
        const dato = await respuesta.json();
    
        
    } catch (error) {
        console.log(error);
    }
}

obtenerSugerencias(url);