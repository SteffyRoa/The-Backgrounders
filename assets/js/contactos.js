/* ibjeto grobal */
const datos ={
    nombre :'',
    mensaje:''
}
/* variables */
const nombre = document.querySelector('#nombre');
const mensaje = document.querySelector('#mensaje');
const formulario = document.querySelector('.formulario');

nombre.addEventListener('input',leerTexto);
mensaje.addEventListener('input',leerTexto);



/* addevenlisent 
sugerencia ocupar sumbit por formulario*/
formulario.addEventListener('submit', function(evento){
    evento.preventDefault();
   

    //validar datos con desrocion
    const {nombre,mensaje}=datos;
        if(nombre ==='' || mensaje ===''){
            mostrarAlerta('Todods los campos son obligatorios',true);
            return; //corta la ehjecucion del codigo
        }

        //crear alerta de envio correctp
        mostrarAlerta('Mensaje enviado correctamente')
        console.log('Enviando');
    });
        
    function leerTexto(e){
        //con esto referencio al valor de los 
        //inputs
        datos[e.target.id] = e.target.value; //checar lo de target
        }

    function mostrarAlerta(mensaje ,error=null){
        const alerta = document.createElement('P');
        alerta.textContent= mensaje;
        if(error){
            alerta.classList.add('error');
        }else{
            alerta.classList.add('correcto')
        }
        formulario.appendChild(alerta);

        setTimeout(()=>{
            alerta.remove();//lo elimine remove
        },1000)
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
            
            nav.innerHTML += `<a class="nav-link text-white" href="./Registro.html"><b>Registrarse</b></a>
            <a class="nav-link text-white" href="./login.html"><b>Login</b></a>`
         }
}
isUsuario();





    


