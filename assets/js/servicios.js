const servicios = document.getElementById("cards-container");
const url = "../assets/servicios.json"
let dato;
async function obtenerServicios(url) {
  try {
      const respuesta = await fetch(url);
      dato = await respuesta.json();
      
      
  } catch (error) {
      console.log(error);
  }
}
obtenerServicios(url)

function mostrarInformacion(id) {

  console.log(dato);
  servicios.innerHTML = "";
  servicios.innerHTML += 
  `<div  id="card1" class="card card-service shadow rounded">
    <img id="image-service"
      src=${dato[id].imagen}
      class="card-img-top img-card img-service"
      alt="..."
    />
    <div class="card-body">
      <h5 id="service-title" class="card-title">${dato[id].nombre}</h5>
      <p id="description" class="card-text">
      ${dato[id].descripcion}
      </p>
      <h4 id="price">${dato[id].precio}</h4>
      <a class="enlace" href="#" onclick="regresar()">Regresar a servicios</a>
    </div>
  </div>
</div>
</div>`;
}

function regresar() {
  window.location.reload();
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