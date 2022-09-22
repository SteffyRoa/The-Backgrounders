
(function () {
  'use strict';
  window.addEventListener('load', function () {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();

const btn = document.getElementById("formAgendar")
btn.addEventListener("submit", (e) => {
  console.log("gatos");
  e.preventDefault()
  vamosAValidar()
})

function vamosAValidar() {
  const nombre1 = document.getElementById("inputNombre")
  const apellido1 = document.getElementById("inputApellido")
  const email1 = document.getElementById("inputEmail")
  const celular1 = document.getElementById("inputCelular")

  console.log("gatos55");
  const nombre = /(^[a-zA-Z][a-zA-Z\s]{0,20}[a-zA-Z]$)/ // Letras y espacios, pueden llevar acentos.
  const apellido = /^[a-zA-ZÀ-ÿ\s]{1,40}$/ // Letras y espacios, pueden llevar acentos.
  const email = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
  const celular = /^(\+\d{1,3}( )?)?((\(\d{1,3}\))|\d{1,3})[- .]?\d{3,4}[- .]?\d{4}$/; // 7 a 14 numeros.
  const btn = document.getElementById("boton")

  let validar1 = nombre.test(nombre1.value);
  console.log(validar1);
  let validar2 = apellido.test(apellido1.value);
  console.log(validar2);
  let validar3 = celular.test(celular1.value);
  console.log(validar3);
  let validar4 = email.test(email1.value);
  console.log(validar4);
  console.log("gatotes");

  if (validar1 == true && (validar2 == true && (validar3 == true && (validar4 == true)))) {
    btn.setAttribute("data-toggle", "modal")
    btn.setAttribute("data-target", "#confirmaModal")
    btn.click()
  }
}

function agendarCita() {  

  const idU = localStorage.getItem('id');
  const nombre = document.getElementById("inputNombre");
  const apellido = document.getElementById("inputApellido");
  const servicio = document.getElementById("inputState");
  const fecha = document.getElementById("inputFCita");

  if (idU != null) {

    fetch('http://localhost:8080/citas/usuarios', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        fechaC: fecha.value,
        horaC: "00:00:00",
        servicio: servicio.value,
        confirmacionC: 1,
        cita:{
            id: idU
        }
      }),
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        location.href="../../pages/paginaSesionInicio.html";
      })
      .catch((error) => {
        console.error('Error:', error);
      });

  }else{

    const mail = document.getElementById("inputApellido");
    const celular = document.getElementById("inputApellido");

    fetch('http://localhost:8080/nueva', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        nombre: nombre.value,
        apellido: apellido.value,
        correo: mail.value,
        fecha: fecha.value,
        telefono: celular.value,
        
      }),
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        localStorage.setItem('idI', data.id);
      })
      .catch((error) => {
        console.error('Error:', error);
      });

      //Agendar cita

      const idI = localStorage.getItem('idI');

      fetch('http://localhost:8080/citas/invitados', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        fechaC: fecha.value,
        horaC: "00:00:00",
        servicio: servicio.value,
        confirmacionC: 1,
        invitado:{
            id: idI
        }
      })
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        localStorage.clear();
      })
      .catch((error) => {
        console.error('Error:', error);
      });


  } 
}

function isUsuario() {
  const id = localStorage.getItem('id');
  console.log(id);
  if (id != null) {

    try {
      document.getElementById("id_registro").remove();
      document.getElementById("id_login").remove();
      document.getElementById("id_telefono").remove();
      document.getElementById("id_correo").remove();
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
    const param = document.getElementById("opciones");

    nav.innerHTML += `<a class="nav-link text-white" href="./Registro.html">Registrarse</a>
        <a class="nav-link text-white" href="./login.html">Login</a>`

    param.innerHTML += ` <!-- Campo Correo -->
        <div class="form-group col-md-6" id="id_correo">
        <!-- Icono -->
          <i class="far fa-envelope"></i>
          <label for="inputEmail" >Correo Electrónico </label><div class="users input-group has-validation">
          <input type="email" class="form-control" id="inputEmail" placeholder="hola@gmail.com" required>
          <div class="invalid-feedback">
              Por favor, ingresa un correo válido.
          </div>
          </div></div>
          <!-- Campo Telefono -->
          <div class="form-group col-md-6 " id="id_telefono">
            <!-- Icono -->
            <i class="fas fa-mobile-alt"></i>
            <label for="inputCeluar">Teléfono</label><div class="users">
            <input type="number" class="form-control" id="inputCelular" placeholder="(52)5555555" required>
            <div class="invalid-feedback">
            Por favor, ingresa un número de teléfono.
            </div>
          </div></div>`
  }
}
isUsuario();