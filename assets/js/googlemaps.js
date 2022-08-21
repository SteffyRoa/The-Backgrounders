
function iniciarMapa(){
    var coord ={lat:-19.3577625, lng:-98.9877431};
    var map = new google.maps.Map(document.getElementById('map'),{
        zoom:10,
        center:coord
    });
}