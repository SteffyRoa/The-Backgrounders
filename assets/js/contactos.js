/* mapa googgle */
/* function iniciarMapa(){
    var coord ={lat:-19.3577625, lng:-98.9877431};
    var map = new google.maps.Map(document.getElementById('map'),{
        zoom:10,
        center:coord
    }); 
}*/

/* botones con efecto */
let inicio = document.querySelector("#inicio");
boton01.addEventListener('mouseover',function(){
    inicio.style.padding = "5px"
})

boton01.addEventListener('mouseout',function(){
    inicio.style.padding = "2px"
})