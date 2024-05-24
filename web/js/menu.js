document.addEventListener("DOMContentLoaded", function() {
    const toggleSubMenu = document.getElementById("submenubtn");
    const subMenu = document.querySelector(".submenu");

    const toggleMenuUsuario = document.getElementById("menuUsuariobtn");
    const MenuUsuario = document.querySelector(".menuUsuario");

    // Agregar un controlador de eventos al enlace principal
    toggleSubMenu.addEventListener("click", function(event) {
        event.preventDefault(); // Prevenir el comportamiento predeterminado del enlace

        // Toggle (alternar) la visibilidad del menú desplegable
        if (subMenu.style.display === "block") {
            subMenu.style.display = "none";
        } else {
            subMenu.style.display = "block";
        }
    });

    toggleMenuUsuario.addEventListener("click", function(event){
        event.preventDefault();

        if(MenuUsuario.style.display === "block"){
            MenuUsuario.style.display = "none";
        }else{
            MenuUsuario.style.display ="block";
        }
    })

});
