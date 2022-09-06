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



