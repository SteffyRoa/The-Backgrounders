
const url = "../assets/sugerencias.json"
const url2 = "http://localhost:8080/pacientesR"

const imgIcono = document.getElementById("img-icono");
let max = 10;
let min = 1;
let despliegue = true;
let icono = Math.random() * (max - min) + min;

icono = parseInt(icono);
imgIcono.src = `../assets/images/icono/${icono}.png`

const imgs = document.querySelectorAll('.img');
imgs.forEach(img => {
    img.addEventListener('click', function () {

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

        let mensajes = ["consejos", "beneficios", "riesgos", "cuidados"];
        let max = 4;
        let min = 0;
        let tipo = parseInt(Math.random() * (max - min) + min);

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
        let mensaje = parseInt(Math.random() * (max - min) + min);
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

function obtenerDatos() {

    fetch("http://localhost:8080/pacientesR", { method: 'GET', mode: 'cors' })
        .then(respuesta => {
            return respuesta.json()
        })
        .then(data => {

            console.log(data[0].nombre);

        })
}

function obtenerCitas(id) {

    fetch("http://localhost:8080/citas/" + id)
        .then(respuesta => {
            return respuesta.json()
        })
        .then(data => {

            console.log(data);
            const list = document.getElementById("list-tab");
            const productList = document.getElementById('tabla');


            let index=1;
            productList.innerHTML=""
            list.innerHTML = "";
            data.forEach(el => {
                if (el === null) {
                    el = ""
                } else {
                    
                    const element = document.createElement('tr');
                   
                    console.log(el.id);
                    element.innerHTML = `
                    <tr id=${el.id}>
                    <th scope="col">${index}</th>
                    <td>${el.servicio}</td>
                    <td>${el.fechaC}</td>
                    <td>${el.horaC}</td>
                    <td class="bg-success text-white">Pendiente</td>
                    </tr>
                    `;

                    
                    list.innerHTML +=`
                    <a class="list-group-item list-group-item-action "  data-toggle="list"  role="tab"  id=${el.id}>${el.servicio}</a>
                    `;

                    productList.appendChild(element);
                }
                index++;
            })

        })
}


function eliminarCita() {

    //Recupera elemento a eliminar
    const idSeleccionado = document.querySelector('.active');

    console.log(idSeleccionado.id);

     //Hacemos petición Http de tipo DELETE
    fetch('http://localhost:8080/citas/eliminar/' + idSeleccionado.id, { method: 'DELETE', mode: 'cors' })
        .then(res => {

            const id = localStorage.getItem('id');
            //Eliminar elemento de la vista usuario
            document.getElementById(idSeleccionado.id).remove();
            obtenerCitas(id);
            
        }) 
}


function actualizar() {
    const select = document.querySelector('.seleccionado');
    const imgIcono = document.getElementById("img-icono");
    imgIcono.src = select.src
}

function isUsuario() {
    const id = localStorage.getItem('id');
    console.log(id);
    if (id != null) {

        obtenerCitas(id);
        document.getElementById("id_registro").remove();

        document.getElementById("id_login").remove();
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
        const registro = document.getElementById("id_registro")
        if (registro == null) {
            nav.innerHTML += `<a class="nav-link text-white" href="./Registro.html"><b>Registrarse</b></a>
            <a class="nav-link text-white" href="./login.html"><b>Login</b></a>`

        }

    }
}
obtenerSugerencias(url);
isUsuario();
