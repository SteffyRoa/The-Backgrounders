/*
var nombre = document.getElementById('nombre');
var password = document.getElementById('password');
var error = document.getElementById('error');

function enviarForm(){
    console.log("Enviando formulario");
    

    error.innerHTML =  mensajesError.join(', ');
    return false;
}*/
var form = document.getElementById('formulario');
form.addEventListener('submit',function(evt)){
evt.preventDefault();
var mensajesError=[];
var mensajesError =[];
    if(nombre.value===null || nombre.value==='' || nombre.value===' '){
        mensajesError.push('Ingresa tu usuario');
    }
    if(password.value===null || password.value ===''){
        mensajesError.push('Ingresa tu Password');
    }
console.log('Enviando Formulario...')
}



//var button = document.getElementById('button')


//Funcion Steffy


// function validar(){
//     window.location.href ='./paginaSesionInicio.

// function validar(){
//     window.location.href ='./paginaSesionInicio.html';


// var user = document.getElementsById("username").value;
// var pass= document.getElementsById("password").value;
  
//     if(user == "hola" && pass == "hola"){
//        function hola(){
//         window.location.href ='./paginaSesionInicio.html';
//        } 
      
//     }else{
//         alert("verifique los datos")
//     }
// }


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
