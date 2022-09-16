
let contador = 1;
let espera;
function time(index) {
    let vid = document.getElementById(contador);

    vid.pause();
    vid.currentTime = 0;

    contador = contador+index;

    if(contador == 0){
        contador = 3;
        espera = setTimeout(reproductor, 1000);
    }else{

        espera = setTimeout(reproductor, 1000);
    }
    
}
function reproductor (){

    if(contador == 4 ){
       
        contador = 1;
        vid = document.getElementById(contador);
        vid.play();
        
    }else{
        vid = document.getElementById(contador);
        vid.play();
    }

    if(contador == 0 ){
        contador = 3;
        vid = document.getElementById(contador);
        vid.play();

        
    }else{
        vid = document.getElementById(contador);
        vid.play();
    }

}