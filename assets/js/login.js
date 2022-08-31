
//var button = document.getElementById('button')



function validar(){
    window.location.href ='./paginaSesionInicio.html';

var user = document.getElementsById("username").value;
var pass= document.getElementsById("password").value;
  
    if(user == "hola" && pass == "hola"){
       function hola(){
        window.location.href ='./paginaSesionInicio.html';
       } 
      
    }else{
        alert("verifique los datos")
    }
}
