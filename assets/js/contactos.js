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






    


