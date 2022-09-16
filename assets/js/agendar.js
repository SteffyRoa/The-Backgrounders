

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

  const btn = document.getElementById("formAgendar")
  btn.addEventListener ("submit", (e) => {
    console.log("gatos");
      e.preventDefault()
      vamosAValidar()} )

  function vamosAValidar(){
    const nombre1 = document.getElementById("inputNombre")
    const apellido1 = document.getElementById("inputApellido")
    const email1 = document.getElementById("inputEmail")
    const celular1 = document.getElementById("inputCelular")

    console.log("gatos55");
    const nombre = /(^[a-zA-Z][a-zA-Z\s]{0,20}[a-zA-Z]$)/ // Letras y espacios, pueden llevar acentos.
    const  apellido = /^[a-zA-ZÀ-ÿ\s]{1,40}$/ // Letras y espacios, pueden llevar acentos.
    const email = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
    const celular = /^(\+\d{1,3}( )?)?((\(\d{1,3}\))|\d{1,3})[- .]?\d{3,4}[- .]?\d{4}$/ ; // 7 a 14 numeros.
    const btn = document.getElementById("boton")
console.log("gatitos");
    let validar1 = nombre.test(nombre1.value);
    console.log(validar1);
    let validar2 = apellido.test(apellido1.value);
    console.log(validar2);
    let validar3 = celular.test(celular1.value);
    console.log(validar3);
    let validar4 = email.test(email1.value);
    console.log(validar4);
    console.log("gatotes");
    
    if ( validar1 == true && (validar2 == true && (validar3 == true && (validar4 == true )))){
                btn.setAttribute( "data-toggle", "modal")
                btn.setAttribute( "data-target","#confirmaModal")
                btn.click()
console.log("Michis");
    }
  }