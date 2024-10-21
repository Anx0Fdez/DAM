# Tarea 4

---
#### ***1. Utiliza la imagen de Ubuntu , tag 22 y apoyandote en esta guía sigue sus instrucciones para instalar LAMP en dicho contenedor.***

`sudo docker run -it ubuntu:22.04`

`apt update` # Actualiza la lista de paquetes


#### ***2. Crea un contenedor con la imagen de Ubuntu 22.04 y ejecuta el comando tail -f /dev/null para mantenerlo en ejecución.***

`sudo docker run -d --name ubuntu1 ubuntu:22.04 tail -f /dev/null` 

`sudo docker ps` # Para verificar que el contenedor está activo
