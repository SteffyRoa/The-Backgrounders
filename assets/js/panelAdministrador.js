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

function isUsuario(){
    const id = localStorage.getItem('id');
    console.log(id);
     if (id != null){
        
        try {
          document.getElementById("id_registro").remove();
          document.getElementById("id_login").remove();
        } catch (error) {
          
        }
       
        const nav = document.getElementById("navbar");
        nav.innerHTML += `<a id="id_salir" class="nav-link text-white">Salir</a>`
        const btn = document.getElementById("id_salir")
  
        btn.addEventListener ("click", (e) => {
            e.preventDefault()
            localStorage.clear();
            location.href="../../pages/login.html";
        } )
     }else{
        const nav = document.getElementById("navbar");
        
        nav.innerHTML += `<a class="nav-link text-white" href="./Registro.html"><b>Registrarse</b></a>
        <a class="nav-link text-white" href="./login.html"><b>Login</b></a>`
     }
  }
  isUsuario();