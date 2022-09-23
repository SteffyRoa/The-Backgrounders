function ir() {
  location.href="../../pages/paginaSesionInicio.html";
}

var nombre = document.getElementById('inputEmail');
var password = document.getElementById('inputContraseña');
// var error = document.getElementById('error');

function enviarform(){
    console.log("Enviando formulario");
    
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

const btn = document.getElementById("formulario")
 
btn.addEventListener ("submit", (e) => {
    console.log("gatos");
      e.preventDefault()
      vamosAValidar()
} )

function vamosAValidar () {
  const email1 = document.getElementById("inputEmail")
  const password1 = document.getElementById("inputContraseña")

  const mnsemail = document.getElementById("mensajeEmail")
  const mnspassword = document.getElementById("mensajeContraseña")
  mnsemail.innerHTML = ""
  mnspassword.innerHTML = ""

  const password = /^.{4,12}$/ /* 4 a 12 digitos.*/
  const email = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/

  let validar1 = email.test(email1.value)
  let validar2 = password.test(password1.value)
  const btn = document.getElementById("boton")

  if (validar1 == true && (validar2 == true )){
    btn.setAttribute( "data-toggle", "modal")
    btn.setAttribute( "data-target","#confirmaModal")
    btn.click()

  } if (validar1 == false){
    mnsemail.innerHTML = "completa el campo adecuadamente"
    mnsemail.style.color = "#e71414"
    console.log("nombre");
  }if (validar2 == false){
    mnspassword.innerHTML = "completa el campo adecuadamente"
    mnspassword.style.color = "#e71414"
  }

  fetch(`https://consultorio-dienteslimpios.herokuapp.com/pacientesR/login?correo=${email1.value}&contrasena=${password1.value}`, {method: 'GET'})
  .then(respuesta => {
     return respuesta.json()
  })
  .then(data => {
     
     console.log(data.id);
     localStorage.setItem('id', data.id);
     localStorage.setItem('nombre', data.nombre);
     ir();
        
  })


}