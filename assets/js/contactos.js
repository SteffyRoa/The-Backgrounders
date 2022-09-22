/* ibjeto grobal */
const datos = {
    nombre: '',
    mensaje: ''
}
/* variables */
const nombre = document.querySelector('#nombre');
const mensaje = document.querySelector('#mensaje');
const formulario = document.querySelector('.formulario');

nombre.addEventListener('input', leerTexto);
mensaje.addEventListener('input', leerTexto);



/* addevenlisent 
sugerencia ocupar sumbit por formulario*/
formulario.addEventListener('submit', function (evento) {
    evento.preventDefault();


    //validar datos con desrocion
    const { nombre, mensaje } = datos;
    if (nombre === '' || mensaje === '') {
        mostrarAlerta('Todods los campos son obligatorios', true);
        return; //corta la ehjecucion del codigo
    }


    //crear alerta de envio correctp
    mostrarAlerta('Mensaje enviado correctamente')
    console.log('Enviando');
});


function leerTexto(e) {
    //con esto referencio al valor de los 
    //inputs
    datos[e.target.id] = e.target.value; //checar lo de target
}

function mostrarAlerta(mensaje, error = null) {
    const alerta = document.createElement('P');
    alerta.textContent = mensaje;
    if (error) {
        alerta.classList.add('error');
    } else {
        alerta.classList.add('correcto')
    }
    formulario.appendChild(alerta);

    setTimeout(() => {
        alerta.remove();//lo elimine remove
    }, 1000)
}

function isUsuario() {
    const id = localStorage.getItem('id');
    console.log(id);
    if (id != null) {

        try {
            document.getElementById("id_registro").remove();
            document.getElementById("id_login").remove();
        } catch (error) {

        }

        const nav = document.getElementById("navbar");
        nav.innerHTML += `<a id="id_salir" class="nav-link text-white">Salir</a>`
        const btn = document.getElementById("id_salir")

        btn.addEventListener("click", (e) => {
            e.preventDefault()
            localStorage.clear();
            location.href = "../../pages/login.html";
        })
    } else {
        const nav = document.getElementById("navbar");

        nav.innerHTML += `<a class="nav-link text-white" href="./Registro.html"><b>Registrarse</b></a>
            <a class="nav-link text-white" href="./login.html"><b>Login</b></a>`
    }
}

function ver_comentarios() {
    fetch("http://localhost:8080/comentario", {method: 'GET', mode: 'cors'})
    .then(respuesta => {
       return respuesta.json()
    })
    .then(data => {
       
       console.log(data[0].nombre);

       const cajaComent = document.getElementById("caja-comentarios");
       cajaComent.innerHTML += ""
       for (let i = 0; i < data.length; i++) {
        
           cajaComent.innerHTML += `<div class="container p-5 cuadroComentarioTestimonios" >
            <h4>${data[i].nombre}</h4>
            ${data[i].text}
            
           </div>`
       }
          
    })
}

function agendar() {

    const nombre = document.getElementById("nombre")
    const mensaje = document.getElementById("mensaje")

    fetch('http://localhost:8080/comentario', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      nombre: nombre.value,
      text: mensaje.value
      
    }),
  })
    .then(response => response.json())
    .then(data => {
        ver_comentarios();
    })
    .catch((error) => {
      console.error('Error:', error);
    }); 
}

isUsuario();
ver_comentarios();
