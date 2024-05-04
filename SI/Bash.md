# ***Bash***
### *by: [Anxo Fdez]*
#### *github: [Anx0Fdez](https://github.com/Anx0Fdez)* 
###### *@Author:* [Ana Valladares](https://github.com/anavalladaares)

---
# Comandos Linux

Este documento contiene una lista de comandos de Linux útiles para administrar usuarios, archivos, procesos y más. Los comandos se dividen en categorías para facilitar su uso y comprensión.

### INDICE
  - [Comandos Generales](#comandos-generales)
  - [Gestión de Archivos y Directorios](#gestión-de-archivos-y-directorios)
  - [Permisos y Enlaces](#permisos-y-enlaces)
  - [Documentación y Ayuda](#documentación-y-ayuda)
  - [Gestión de usuarios](#gestión-de-usuarios)
  - [Gestión de procesos](#gestión-de-procesos)
  - [Utilidades de Monitorización](#utilidades-de-monitorización)
  - [Gestión de la Prioridad de Procesos](#gestión-de-la-prioridad-de-procesos)
  - [Información del Sistema](#información-del-sistema)
  - [Gestión de Tareas Programadas](#gestión-de-tareas-programadas)
  - [Uso de Señales](#uso-de-señales)
  - [Ejecución en Segundo Plano](#ejecución-en-segundo-plano)
---

## Comandos Generales
#### `passwd`
- **Descripción**: Permite al usuario cambiar o asignar una contraseña.
- **Ejemplo**: `passwd usuario`
- **Opciones**:
    - Sin opciones especiales.

#### `uname`
- **Descripción**: Obtiene el nombre del sistema operativo.
- **Ejemplo**: `uname -a`
- **Opciones**:
    - `-X` para información extendida (dependiendo del sistema).

#### `logname`
- **Descripción**: Muestra el nombre de usuario con el que se ha iniciado sesión.
- **Ejemplo**: `logname`
- **Opciones**:
    - Sin opciones adicionales.

#### `id`
- **Descripción**: Muestra el UID y GID del usuario.
- **Ejemlo**: `id`
- **Opciones**:
    - Sin opciones adicionales.

#### `date`
- **Descripción**: Muestra o establece la fecha y hora del sistema.
- **Ejemplo**: `date`
- **Opciones**:
    - `+formato` para mostrar la fecha en un formato específico.

#### `who`
- **Descripción**: Muestra quién está conectado al sistema.
- **Ejemplo**: `who`
- **Opciones**:
    - `-H` para incluir cabeceras.
    - `-u` para mostrar información detallada.
    - `-q` para mostrar solo los nombres y el total de usuarios.

## Gestión de Archivos y Directorios

#### `pwd`
- **Descripción**: Muestra el directorio actual de trabajo.
- **Ejemplo**: `pwd`
- **Opciones**:
    - Sin opciones adicionales.

#### `ls`
- **Descripción**: Lista el contenido de un directorio.
- **Ejemplo**: `ls`
- **Opciones**:
    - `-l` para formato detallado.
    - `-A` para incluir archivos ocultos.
    - `-R` para listado recursivo.

#### `cd`
- **Descripción**: Cambia el directorio actual.
- **Ejemplo**: `cd directorio`
- **Opciones**:
    - Sin argumentos vuelve al directorio home.

#### `cat`
- **Descripción**: Muestra el contenido de un archivo.
- **Ejemplo**: `cat archivo`
- **Opciones**:
    - Sin opciones adicionales.

#### `touch`
- **Descripción**: Crea un archivo vacío o actualiza el tiempo de acceso y modificación de un archivo existente.
- **Ejemplo**: `touch archivo` | `touch -t 202401010000 archivo`
- **Opciones**:
    - `-t` para cambiar la fecha de creación de un archivo previamente creado

#### `mkdir`
- **Descripción**: Crea directorios.
- **Ejemplo**: `mkdir directorio`
- **Opciones**:
    - `-p` para crear directorios padres necesarios.
    - `-m` para especificar permisos.

#### `rmdir`
- **Descripción**: Elimina directorios vacíos.
- **Ejemplo**: `rmdir directorio`
- **Opciones**:
    - `-p` para eliminar directorios padres si también están vacíos.

#### `mv`
- **Descripción**: Mueve o renombra archivos o directorios.
- **Ejemplo**: `mv origen destino`
- **Opciones**:
    - `-i` para preguntar antes de sobrescribir.

#### `cp`
- **Descripción**: Copia archivos o directorios.
- **Ejemplo**: `cp origen destino`
- **Opciones**:
    - `-i` para preguntar antes de sobrescribir.
    - `-R` para copiar directorios de manera recursiva.
    - `-p` para preservar el tiempo de modificación, acceso y permisos.

#### `rm`
- **Descripción**: Elimina archivos o directorios.
- **Ejemplo**: `rm archivo`
- **Opciones**:
    - `-i` para confirmación antes de cada eliminación.
    - `-r` para eliminación recursiva.

#### `stat`
- **Descripción**: Muestra información detallada sobre un archivo o directorio.
- **Ejemplo**: `stat archivo`
- **Opciones**:
    - Sin opciones adicionales.

## Permisos y Enlaces

#### `chmod`
- **Descripción**: Cambia los permisos de archivos o directorios.
- **Ejemplo**: `chmod permisos archivo`
- **Opciones**:
    - Utiliza una notación simbólica o numérica para especificar permisos.
    - Permisos:
        - `r` para lectura.
        - `w` para escritura.
        - `x` para ejecución.
        - `a` para todos los usuarios.
        - `u` para el propietario.
        - `g` para el grupo.
        - `o` para otros.
        - `+` para añadir permisos.
        - `-` para quitar permisos.
        - `=` para establecer permisos.
        - `X` para establecer permisos de ejecución si el archivo es un directorio o ya tiene permisos de ejecución.
        - `u+r` para añadir permiso de lectura al propietario.
        - `g-w` para quitar permiso de escritura al grupo.
        - `o=x` para establecer permiso de ejecución a otros.
        - `a=rw` para establecer permisos de lectura y escritura a todos los usuarios.
        - `755` para establecer permisos de lectura, escritura y ejecución al propietario, y solo lectura y ejecución al grupo y otros.

#### `chown`
- **Descripción**: Cambia el propietario de un archivo o directorio.
- **Ejemplo**: `chown usuario archivo`
- **Opciones**:
    - Sin opciones adicionales.

#### `ln`
- **Descripción**: Crea enlaces físicos o simbólicos.
- **Ejemplo**: `ln archivo enlace`
- **Opciones**:
    - `-s` para crear un enlace simbólico.

#### `umask`
- **Descripción**: Establece la máscara de permisos predeterminada para nuevos archivos y directorios.
- **Ejemplo**: `umask 022` -> directorios: rwxr-xr-x, archivos: rw-r--r--
- **Opciones**: No hay opciones adicionales.

## Documentación y Ayuda

#### `man`
- **Descripción**: Muestra la página del manual para comandos.
- **Ejemplo**: `man comando`
- **Opciones**:
    - `-k` para buscar páginas de manual que contienen una palabra clave.
    - `-e` para encontrar secciones con una descripción específica.


## Gestión de usuarios

#### `useradd`
- **Descripción**: Crea cuentas de usuario.
- **Ejemplo**: `useradd "usuario"`
- **Opciones**:
  - `-c comentario`: Añade un comentario sobre el usuario.
  - `-d directorio`: Directorio home del usuario.
  - `-m`: Crea el directorio home si no existe.
  - `-g grupo`: Grupo principal del usuario.
  - `-G grupo1,grupo2`: Otros grupos a los que el usuario será añadido.
  - `-s shell`: Shell de conexión para el usuario.

#### `usermod`
- **Descripción**: Modifica cuentas de usuario existentes.
- **Ejemplo**: `usermod -s /bin/bash usuario`
- **Opciones**:
  - `-c comentario`: Modifica o añade un comentario.
  - `-d directorio`: Cambia el directorio home del usuario.
  - `-g grupo`: Cambia el grupo principal del usuario.
  - `-G grupo1,grupo2`: Modifica otros grupos a los que el usuario pertenece.
  - `-s shell`: Cambia el shell de conexión.
  - `-l nuevo_nombre`: Cambia el nombre de usuario.

#### `userdel`
- **Descripción**: Elimina cuentas de usuario.
- **Ejemplo**: `userdel usuario`
- **Opciones**:
  - `-r`: Elimina el directorio home del usuario y su correo.

#### `passwd`
- **Descripción**: Cambia o administra contraseñas.
- **Ejemplo**: `passwd usuario`
- **Opciones**:
  - `-d`: Borra la contraseña del usuario, permitiendo acceso sin contraseña.
  - `-f`: Fuerza al usuario a cambiar la contraseña en el próximo inicio de sesión.
  - `-n días`: Establece el mínimo de días antes de permitir un cambio de contraseña.
  - `-x días`: Establece el máximo de días antes de que la contraseña expire.
  - `-w días`: Establece una advertencia de días antes de la expiración de la contraseña.
  - `-i días`: Inhabilita la cuenta después de ciertos días de expirada la contraseña.

#### `groupadd`
- **Descripción**: Crea un grupo nuevo.
- **Ejemplo**: `groupadd desarrolladores`
- **Opciones**:
  - Sin opciones específicas relevantes.

#### `groupmod`
- **Descripción**: Modifica grupos existentes.
- **Ejemplo**: `groupmod -n desarrolladores_nuevo desarrolladores`
- **Opciones**:
  - `-n nuevo_nombre`: Cambia el nombre del grupo.

#### `groupdel`
- **Descripción**: Elimina un grupo.
- **Ejemplo**: `groupdel desarrolladores`
- **Opciones**:
  - Sin opciones específicas relevantes.

## Gestión de procesos

#### `ps`
- **Descripción**: Muestra información sobre los procesos activos.
- **Ejemplo**: `ps -e` muestra todos los procesos del sistema.

#### `top`
- **Descripción**: Muestra una vista dinámica de los procesos en ejecución.
- **Ejemplo**: `top` muestra procesos y su uso de recursos en tiempo real.

#### `kill`
- **Descripción**: Envía señales a los procesos para controlar su ejecución.
- **Ejemplo**: `kill -9 [PID]` termina un proceso de forma forzosa.

#### `jobs`
- **Descripción**: Lista los trabajos en la sesión actual de la terminal.
- **Ejemplo**: `jobs` muestra todos los trabajos activos.

#### `bg`
- **Descripción**: Reanuda la ejecución de un trabajo detenido en segundo plano.
- **Ejemplo**: `bg %1` continúa con el primer trabajo listado por `jobs` en segundo plano.

#### `fg`
- **Descripción**: Mueve trabajos al primer plano.
- **Ejemplo**: `fg %1` lleva el primer trabajo al primer plano.

#### `nohup`
- **Descripción**: Ejecuta comandos que permanecen activos tras cerrar la terminal.
- **Ejemplo**: `nohup ./script &` ejecuta un script en segundo plano que no se termina al cerrar la terminal.

## Utilidades de Monitorización

#### `htop`
- **Descripción**: Alternativa interactiva a `top` con una interfaz más rica.
- **Ejemplo**: `htop` muestra una visión interactiva y colorida de los procesos en ejecución.

#### `pstree`
- **Descripción**: Muestra los procesos en forma de árbol.
- **Ejemplo**: `pstree` visualiza la jerarquía de procesos del sistema.

## Gestión de la Prioridad de Procesos

#### `nice`
- **Descripción**: Inicia un proceso con una prioridad dada.
- **Ejemplo**: `nice -n 10 ./script` ejecuta `script` con una prioridad baja.

#### `renice`
- **Descripción**: Cambia la prioridad de procesos en ejecución.
- **Ejemplo**: `renice 10 -p [PID]` cambia la prioridad de un proceso existente a 10.

## Información del Sistema

#### `/proc`
- **Descripción**: Directorio virtual que contiene información detallada del sistema y los procesos.
- **Ejemplo**: `cat /proc/cpuinfo` muestra información sobre el CPU.

#### `dmesg`
- **Descripción**: Muestra mensajes del kernel, útil para diagnosticar problemas.
- **Ejemplo**: `dmesg | grep usb` muestra mensajes del kernel relacionados con dispositivos USB.

## Gestión de Tareas Programadas

#### `cron`
- **Descripción**: Programa tareas para ejecutarlas automáticamente en horarios predefinidos.
- **Ejemplo**: Editar `/etc/crontab` para añadir una tarea cronizada.

#### `at`
- **Descripción**: Programa comandos para ejecutarse una sola vez en un momento específico.
- **Ejemplo**: `echo "sh backup.sh" | at 23:00` programa un script de respaldo para ejecutarse a las 11 PM.

## Uso de Señales

- **SIGKILL (`kill -9`)**: Termina procesos de manera inmediata.
  - **Ejemplo**: `kill -9 [PID]` 
- **SIGTERM (`kill -15`)**: Termina procesos de manera suave, permitiendo la limpieza.
  - **Ejemplo**: `kill -15 [PID]`
- **SIGSTOP**: Detiene temporalmente un proceso.
  - **Ejemlo**: `kill -STOP [PID]`
- **SIGCONT**: Continúa con un proceso previamente detenido.
  - **Ejemlo**: `kill -CONT [PID]`

## Ejecución en Segundo Plano

- **Descripción**: Permite ejecutar procesos sin bloquear la terminal.
- **Ejemplo**: `command &` ejecuta `command` en segundo plano.




