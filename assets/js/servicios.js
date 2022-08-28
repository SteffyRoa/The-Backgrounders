const servicios = document.getElementById("cards-container");

function mostrarInformacion() {
  servicios.innerHTML = "";
  servicios.innerHTML += 
  `<div  id="card1" class="card card-service shadow rounded">
    <img id="image-service"
      src="../assets/images/obturacion_con_resina2.jpg"
      class="card-img-top img-card img-service"
      alt="..."
    />
    <div class="card-body">
      <h5 id="service-title" class="card-title">Resinas y Amalgamas</h5>
      <p id="description" class="card-text">
      Una obturación dental es una restauración de una pieza dental que ha sido dañado por caries, lo que comúnmente se conoce como «empastar», consiste en limpiar la cavidad dental resultante de una caries para luego rellenarla con algún material.
      </p>
      <h4 id="price">$ 1,250.00</h4>
      <a class="enlace" href="#" onclick="regresar()">Regresar a servicios</a>
    </div>
  </div>
</div>
</div>`;
}

function regresar() {
  window.location.reload();
}
