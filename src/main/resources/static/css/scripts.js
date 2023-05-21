const btn = document.querySelector('#menu-btn');
const menu = document.querySelector('#menuLateral')
btn.addEventListener('click', e=>{
    menu.classList.toggle("menu-expanded");
    menu.classList.toggle("menu-collapsed");

    document.querySelector('body').classList.toggle('body-expanded')
})



var contadorDates = 1;

function reiniciarContador() {
    contadorDates = 1;
  }

function agregarCampData() {
  var dataContainer = document.getElementById("dataContainer");

  var nouCampoData = document.createElement("div");
  nouCampoData.innerHTML = '<label for="data' + contadorDates + '">Data Curs:</label><input type="date" id="data' + contadorDates + '" name="data[' + contadorDates + ']">';

  // Agregar el nuevo campo al contenedor
  dataContainer.appendChild(nouCampoData);
  contadorDates++;
}
