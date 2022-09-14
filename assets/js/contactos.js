
boton01.addEventListener('mouseout',function(){
    inicio.style.padding = "2px"
});
  

/* mandarComentario */

 function enviarComentario(){

}

function traerComentario(){
    let comentario = document.querySelector(".cajaComentario");

    fetch("http://localhost:8080/comentario", {method: 'GET', mode: 'cors'})
    .then(respuesta => {
       return respuesta.json()
    })
    .then(data => {
       
        for (let i = 0; index < data.length; i++) {
            comentario.innerHTML += ` <div class="container p-5 cuadroComentarioTestimonios" >
            <h4>${data[i].nombre}</h4>
             
            ${data[i].comentario}
            
             </div>`
        }          
                 
    })
}






    


