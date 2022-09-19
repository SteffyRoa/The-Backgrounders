function ir() {
    location.href="./paginaSesionInicio.html";

}

(function() {
    'use strict';
    window.addEventListener('load', function() {
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.getElementsByClassName('needs-validation');
      // Loop over them and prevent submission
      var validation = Array.prototype.filter.call(forms, function(form) {
        form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  })();

  const btn = document.getElementById("formRegistro")
btn.addEventListener ("submit", (e) => {
  console.log("gatos");
    e.preventDefault()
    vamosAValidar()} )

function vamosAValidar () {
    // $Nombre.innerHTML = " "
    // $Apellido.innerHTML = " "
    // $FechadeNacimiento.innerHTML = " "
    // $NumerodeCelular.innerHTML = " "
    // $Email.innerHTML = " "
    // $Contraseña.innerHTML = ""

    const nombre1 = document.getElementById("inputNombre")
    const apellido1 = document.getElementById("inputApellido")
    const celular1 = document.getElementById("inputCelular")
    const email1 = document.getElementById("inputEmail")
    const password1 = document.getElementById("inputContraseña")
    const fecha = document.getElementById("inputFecha")
    
    const mnsNombre = document.getElementById('mensajeNombre');
    const mnsApell = document.getElementById("mensajeApellido")
    const mnsCel = document.getElementById("mensajeNumero")
    const mnsEma = document.getElementById("mensajeEmail")
    const mnsPass = document.getElementById("mensajePassword")

    let max = 10;
    let min = 1;
    let icono = Math.random() * (max-min) + min;

icono = parseInt(icono);

    mnsNombre.innerHTML = ""
    mnsApell.innerHTML = ""
    mnsCel.innerHTML = ""
    mnsEma.innerHTML = ""
    mnsPass.innerHTML = ""

    const nombre = /(^[a-zA-Z][a-zA-Z\s]{0,20}[a-zA-Z]$)/ // Letras y espacios, pueden llevar acentos.
    const  apellido = /^[a-zA-ZÀ-ÿ\s]{1,40}$/ // Letras y espacios, pueden llevar acentos.
    const password = /^.{4,12}$/ /* 4 a 12 digitos.*/
    const email = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
    const celular = /^\+?[1-9][0-9]{7,14}$/ // 7 a 14 numeros.
    const btn = document.getElementById("boton")

    let validar1 = nombre.test(nombre1.value);
    let validar2 = apellido.test(apellido1.value);
    let validar3 = celular.test(celular1.value);
    let validar4 = email.test(email1.value);
    let validar5 = password.test(password1.value);
    if ( validar1 == true && (validar2 == true && (validar3 == true && (validar4 == true && (validar5 == true) )))){
                btn.setAttribute( "data-toggle", "modal")
                btn.setAttribute( "data-target","#confirmaModal")
                btn.click()
       
                
    }if (validar1 == false){
        mnsNombre.innerHTML = "Completa el campo adecuadamente"
        mnsNombre.style.color = "#e71414"
        //console.log("nombre");
    }if (validar2 == false){
        mnsApell.innerHTML = "Completa el campo adecuadamente"
        mnsApell.style.color = "#e71414"
        //console.log("apellido");
    }if (validar3 == false){
        mnsCel.innerHTML = "Completa el campo adecuadamente"
        mnsCel.style.color = "#e71414"
        //console.log("celular");
    }if (validar4 == false){ 
        mnsEma.innerHTML =="Completa el campo adecuadamente"
        mnsEma.style.color == "#e71414"
        //console.log("email");
    }if (validar5 == false){
        mnsPass.innerHTML == "Completa el campo adecuadamente"
        mnsPass.style.color = "#e71414"
        //console.log("password");
    }

    fetch('http://localhost:8080/pacientesR', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify({
          nombre: nombre1.value,
          apellido: apellido1.value,
          correo: email1.value,
          fecha: fecha.value,
          telefono: celular1.value ,
          contrasena: password1.value,
          icono: icono
      }),
    })
      .then(response => response.json())
      .then(data => {
          console.log('Success:', data);
      })
      .catch((error) => {
          console.error('Error:', error);
      }); 

}