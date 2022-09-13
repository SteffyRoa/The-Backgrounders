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