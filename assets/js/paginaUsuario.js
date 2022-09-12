
const url = "../assets/sugerencias.json"
const url2 = "http://localhost:8080/pacientesR"

const imgIcono = document.getElementById("img-icono");
let max = 10;
let min = 1;
let despliegue = true;
let icono = Math.random() * (max-min) + min;

icono = parseInt(icono);
imgIcono.src = `../assets/images/icono/${icono}.png` 

const imgs = document.querySelectorAll('.img');
imgs.forEach(img=>{
    img.addEventListener('click', function(){
        
        const select = document.querySelector('.seleccionado');   
        select.classList.remove('seleccionado');
        img.classList.add('seleccionado');
       
    })
})

async function obtenerSugerencias(url) {
    try {
        const respuesta = await fetch(url);
        const dato = await respuesta.json();
        const msj = document.getElementById("mensaje");

        let mensajes = ["consejos","beneficios","riesgos","cuidados"];
        let max = 4;
        let min = 0;
        let tipo = parseInt(Math.random() * (max-min) + min) ;

        switch (tipo) {
            case 0:
                msj.classList.add('bg-success');
                break;
            case 1:
                msj.classList.add('bg-info');
                break;
            case 2:
                msj.classList.add('bg-danger');
                break;
            case 3:
                msj.classList.add('bg-warning');
                break;
          }

        max = dato[mensajes[tipo]].length;
        let mensaje = parseInt(Math.random() * (max-min) + min);
        console.log(mensajes[tipo]);
        msj.innerHTML = "";
        msj.innerHTML += `<h3 class="m-0 text-center py-4 text-white">
          ${dato[mensajes[tipo]][mensaje].titulo}
        </h3>
        <p class="m-0 text-center py-4 text-white">
          ${dato[mensajes[tipo]][mensaje].informacion}
        </p>
      </div> `

        
    } catch (error) {
        console.log(error);
    }
}

function obtenerDatos(){

    fetch("http://localhost:8080/pacientesR", {method: 'GET', mode: 'cors'})
    .then(respuesta => {
       return respuesta.json()
    })
    .then(data => {
       
       console.log(data[0].nombre);
          
    })
}

function borrar() {
    const active = document.querySelector('.active')
    console.log(active.textContent);
}

function actualizar(){
    const select = document.querySelector('.seleccionado');
    const imgIcono = document.getElementById("img-icono");
    imgIcono.src = select.src
}
obtenerSugerencias(url);
//obtenerDatos();