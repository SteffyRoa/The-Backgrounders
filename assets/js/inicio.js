
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

function isUsuario(){
    const id = localStorage.getItem('id');
    console.log(id);
     if (id != null){
        
        try {
          document.getElementById("id_registro").remove();
          document.getElementById("id_login").remove();
        } catch (error) {
          
        }
       
        const nav = document.getElementById("navbar");
        nav.innerHTML += `<a id="id_salir" class="nav-link text-white">Salir</a>`
        const btn = document.getElementById("id_salir")
  
        btn.addEventListener ("click", (e) => {
            e.preventDefault()
            localStorage.clear();
            location.href="../../pages/login.html";
        } )
     }else{
        const nav = document.getElementById("navbar");
        
        nav.innerHTML += `<a class="nav-link text-white" href="./pages/Registro.html"><b>Registrarse</b></a>
        <a class="nav-link text-white" href="./pages/login.html"><b>Login</b></a>`
     }
}
isUsuario();