# ***Bash***
### *por: [Anxo Fdez]*
#### *github: [Anx0Fdez](https://github.com/Anx0Fdez)* 
###### *@Autor:* [Ana Valladares](https://github.com/anavalladaares)

---
# Comandos Linux

Este documento contiene una lista de comandos de Linux útiles para administrar usuarios, archivos, procesos y más. Los comandos se dividen en categorías para facilitar su uso y comprensión.

### ÍNDICE
  - [Comandos Generales](#comandos-generales)
  - [Gestión de Archivos y Directorios](#gestión-de-archivos-y-directorios)
  - [Permisos e Enlaces](#permisos-e-enlaces)
  - [Documentación e Axuda](#documentación-e-axuda)
  - [Xestión de usuarios](#xestión-de-usuarios)
  - [Xestión de procesos](#xestión-de-procesos)
  - [Utilidades de Monitorización](#utilidades-de-monitorización)
  - [Xestión da Prioridade de Procesos](#xestión-da-prioridade-de-procesos)
  - [Información do Sistema](#información-do-sistema)
  - [Xestión de Tarefas Programadas](#xestión-de-tarefas-programadas)
  - [Uso de Sinais](#uso-de-sinais)
  - [Execución en Segundo Plano](#execución-en-segundo-plano)
  - [Examen Comados](#examen-comandos)

---

## Comandos Generales

#### `uname`
- **Descripción**: Obtiene el nombre del sistema operativo.
- **Ejemplo**: `uname -a`
- **Opciones**:
    - `-X` para información extendida (dependiendo del sistema).
    - `-a` para mostrar toda la información.
    - `-r` para mostrar la versión del kernel.

#### `logname`
- **Descripción**: Muestra el nombre de usuario con el que se inició la sesión.
- **Ejemplo**: `logname`
- **Opciones**:
    - Sin opciones adicionales.

#### `id`
- **Descripción**: Muestra el UID y GID del usuario.
- **Ejemplo**: `id`
- **Opciones**:
    - `-u` para mostrar solo el UID.
    - `-g` para mostrar solo el GID.
    - `-G` para mostrar los grupos a los que pertenece el usuario.
    - `-n` para mostrar nombres de usuario y grupo en lugar de números.
    - `-r` para mostrar el nombre real y efectivo del usuario.
    - `-Z` para mostrar el contexto de seguridad del usuario.
    - `-a` para mostrar todos los valores.
    - `-F` para mostrar todos los valores en formato JSON.
  - **Nota**: El UID es el identificador único del usuario y el GID es el identificador único del grupo.
- **Ejemplo**: `id -u` | `id -g` | `id -G` | `id -n` | `id -r` | `id -Z` | `id -a` | `id -F`

#### `date`
- **Descripción**: Muestra o establece la fecha y hora del sistema.
- **Ejemplo**: `date`
- **Opciones**:
    - `+formato` para mostrar la fecha en un formato específico.

#### `who`
- **Descripción**: Muestra quién está conectado al sistema.
- **Ejemplo**: `who`
- **Opciones**:
    - `-H` para incluir encabezados.
    - `-u` para mostrar información detallada.
    - `-q` para mostrar solo los nombres y el total de usuarios.

#### `mount`
- **Descripción**: Muestra los sistemas de archivos montados.
- **Ejemplo**: `mount`
- **Opciones**:
  - `-t tipo` para mostrar solo sistemas de archivos de un tipo específico.
  - `-l` para mostrar solo los sistemas de archivos montados.
  - `-a` para montar todos los sistemas de archivos especificados en `/etc/fstab`.

#### `umount`
- **Descripción**: Desmonta sistemas de archivos.
- **Ejemplo**: `umount /mnt`
- **Opciones**:
  - `-f` para forzar el desmontaje.
  - `-l` para desmontar de forma segura.

#### `jobs`
- **Descripción**: Muestra los trabajos en segundo plano.
- **Ejemplo**: `jobs`
- **Opciones**:
  - Sin opciones adicionales.
  - `-l` para mostrar información detallada.
  - `-p` para mostrar los PIDs de los trabajos.
  - `-r` para mostrar solo los trabajos en ejecución.
  - `-s` para mostrar solo los trabajos suspendidos.
  - `-n` para mostrar solo los trabajos que cambiaron recientemente de estado.
  - **Nota**: Los trabajos son procesos que se ejecutan en segundo plano.

## Gestión de Archivos y Directorios

#### `pwd`
- **Descripción**: Muestra el directorio actual de trabajo.
- **Ejemplo**: `pwd`
- **Opciones**:
  - Sin opciones adicionales.

#### `ls`
- **Descripción**: Lista el contenido de un directorio.
- **Ejemplo**: `ls /home/user/documentos`
- **Opciones**:
  - `-l` para formato detallado.
  - `-a` para incluir archivos ocultos.
  - `-R` para listado recursivo (recursivo: muestra ese directorio, y también el contenido de los subdirectorios y así sucesivamente).
  - `-t` para ordenar por fecha de modificación.
  - `-S` para ordenar por tamaño.
  - `-r` para ordenar en orden inverso.
  - `-h` para mostrar tamaños de archivos legibles para humanos.
  - `-1` para mostrar un archivo por línea.
  - `-d` para mostrar solo directorios.
  - `-i` para mostrar el número de inode de cada archivo.
  - `-g` para
  - `-o` para amosar sen información do grupo.
  - `-F` para amosar un carácter especial ao final de cada ficheiro.
  - `-A` para amosar todos os ficheiros, excepto `.` e `..`.
  - `-m` para amosar os ficheiros separados por comas.
  - `-U` para amosar sen ordenar.
  - `-X` para amosar ordenado por extensión.
  - `-N` para amosar sen ordenar.
  - `-v` para amosar en orde natural.
  - `-q` para amosar os nomes de ficheiros con caracteres non imprimibles como `?`.

#### `[especificación de busca]`
- **Descrición**: Busca ficheiros e directorios que cumpran certas normas.
- **Exemplo**: ``ls comand?` ` amosa todos os ficheiros con extensión `.txt`.
- **Opcións**:
  - `*` para cero ou máis caracteres.
  - `o*` para ficheiros que comecen con `o`.
  - `*o`: para ficheiros que rematen con `o`.
  - `*o*` para ficheiros que conteñan a letra `o`.
  - `*.txt` para ficheiros con extensión `.txt`.
  - `?` para un só carácter.
  - `??` para dous caracteres.
  - `o[1-9]` para ficheiros que comecen con `o` seguido dun só díxito.
  - `[1-9]` para un só carácter do rango.
  - `[!1-9]` para un só carácter que non estea no rango.
  - `[a-z]` para un só carácter no rango.
  - `[!a-z]` para un só carácter que non estea no rango.
  - `[a,e,i,o,u]` para un só carácter na lista.

#### `cd`
- **Descrición**: Cambia o directorio actual.
- **Exemplo**: `cd /home/user/documents`
- **Opcións**:
  - Sen argumentos volve ao directorio home.

#### `cat`
- **Descrición**: Amosa o contido dun ficheiro.
- **Exemplo**: `cat ficheiro`
- **Opcións**:
  - Sen opcións adicionais.

#### `touch`
- **Descrición**: Crea un ficheiro baleiro ou actualiza o tempo de acceso e modificación dun ficheiro existente.
- **Exemplo**: `touch /home/user/novoficheiro.txt` | `touch -t 202401010000 ficheiro` <-- Exemplo de cambio de data
- **Opcións**:
  - `-t` para cambiar a data de creación dun ficheiro previamente creado.
  - `-c`: Non crea un ficheiro se xa existe.
  - `-m`: Cambia só o tempo de modificación.

#### `mkdir`
- **Descrición**: Crea directorios.
- **Exemplo**: `mkdir ~/proyecto/codigo`
- **Opcións**:
  - `-p` para crear directorios pais necesarios.
  - `-m` para especificar permisos.
  - `-v` para amosar mensaxes detalladas.

#### `rmdir`
- **Descrición**: Elimina directorios baleiros.
- **Exemplo**: `rmdir ~/proyecto/codigo`
- **Opcións**:
  - `-p` para eliminar directorios pais se tamén están baleiros.

#### `mv`
- **Descrición**: Move ou renomea ficheiros ou directorios.
- **Exemplo** para mover ficheiros: `mv orixe destino` | `mv ~/cartafol1 /tmp/cartafol1`
- **Exemplo** para renomear ficheiros: `mv ficheiro novo_nome` | `mv ~/ficheiro1.txt ~/ficheiro2.txt`
- **Opcións**:
  - `-i` para preguntar antes de sobrescribir.

#### `cp`
- **Descrición**: Copia ficheiros ou directorios. A opción `-R` é necesaria para copiar directorios. 
- **Exemplo**: `cp orixe destino`
- **Opcións**:
  - `-i` para preguntar antes de sobrescribir.
  - `-R` para copiar directorios de forma recursiva.
  - `-p` para preservar o tempo de modificación, acceso e permisos.

#### `rm`
- **Descrición**: Elimina ficheiros ou directorios.
- **Exemplo**: `rm -rf temp`
- **Opcións**:
  - `-i` para confirmación antes de cada eliminación.
  - `-r` para eliminación recursiva.
  - `-f` para forzar a eliminación sen confirmación.

#### `stat`
- **Descrición**: Amosa información detallada sobre un ficheiro ou directorio.
- **Exemplo**: `stat ficheiro`
- **Opcións**:
  - Sen opcións adicionais.

## Permisos e Enlaces

#### `chmod`
- **Descrición**: Cambia os permisos de ficheiros ou directorios.
- **Exemplo** forma simbólica: `chmod u+r ficheiro`
- **Exemplo** forma octal: `chmod 755 ficheiro` --> Propietario (1º num): rwx, Grupo (2º num): r-x, Outros (3º num): r-x
- **Forma octal**: 
  - 4: Lectura (r).
  - 2: Escritura (w).
  - 1: Execución (x).
  - 0: Sen permisos.
  Hai que sumar os valores dos permisos que se queren dar.
- **Opcións**:
  - Utiliza unha notación simbólica ou numérica para especificar permisos.
  - Permisos:
    - `r` para lectura.
    - `w` para escritura.
    - `x` para execución.
    - `a` para todos os usuarios.
    - `u` para o propietario.
    - `g` para o grupo.
    - `o` para outros.
    - `+` para engadir permisos.
    - `-` para quitar permisos.
    - `=` para establecer permisos.
    - `X` para establecer permisos de execución se o ficheiro é un directorio ou xa ten permisos de execución.
    - `u+r` para engadir permiso de lectura ao propietario.
    - `g-w` para quitar permiso de escritura ao grupo.
    - `o=x` para establecer permiso de execución a outros.
    - `a=rw` para establecer permisos de lectura e escritura a todos os usuarios.
    - `755` para establecer permisos de lectura, escritura e execución ao propietario, e só lectura e execución ao grupo e outros.

#### `chown`
- **Descrición**: Cambia o propietario dun ficheiro ou directorio.
  - `chown user2 carpeta1` --> Cambia o propietario da carpeta1 a user2.
- **Exemplo**: `chown juan:desenvolvedores ficheiro.txt` --> Establece ao usuario propietario como "juan" e ao grupo propietario como "desenvolvedores".
- **Opcións**:
  - Sen opcións adicionais.

#### `ln`
- **Descrición**: Crea enlaces físicos ou simbólicos.
- **Exemplo**: `ln ficheiro enlace`
- **Opcións**:
  - `-s` para crear un enlace simbólico.

#### `umask`
- **Descrición**: Establece a máscara de permisos predeterminada para novos ficheiros e directorios.
- **Exemplo**: `umask 022` -> directorios: rwxr-xr-x, ficheiros: rw-r--r--
- **Opcións**: Non hai opcións adicionais.
- **Explicación**: A máscara de permisos réstase dos permisos máximos para determinar os permisos reais. Por exemplo, se a máscara é 022, os permisos máximos son 777 e os permisos reais son 755 para directorios e 644 para ficheiros.

#### `sort`
- **Descrición**: Ordena liñas de texto nun ficheiro.
- **Exemplo**: `sort -n notas.txt`
- **Opcións**:
  - `-r` para ordenar en orde inversa.
  - `-n` para ordenar numericamente.
  - `-f` para ordenar sen distinguir maiúsculas e minúsculas.
  - `-k` para especificar un campo de ordenación.

#### `wc`
- **Descrición**: Conta liñas, palabras e caracteres nun ficheiro.
- **Exemplo**: `wc ficheiro`
- **Opcións**:
  - `-l` para contar liñas.
  - `-w` para contar palabras.
  - `-c` para contar caracteres.

#### `>`, `>>`
- **Descrición**: Redirixe a saída estándar a un ficheiro.
- **Exemplo**: `ls > ficheiros.txt` | `ls >> ficheiros.txt`
- **Opcións**:
  - `>` sobrescribe o ficheiro.
  - `>>` engade ao ficheiro sen sobrescribilo.

## Documentación e Axuda

#### `man`
- **Descrición**: Amosa a páxina do manual para comandos.
- **Exemplo**: `man comando`
- **Opcións**:
  - `-k` para buscar páxinas de manual que conteñen unha palabra clave.
  - `-e` para atopar seccións con unha descrición específica.


## Xestión de usuarios

#### `useradd`
- **Descrición**: Crea contas de usuario.
- **Exemplo**: `useradd "usuario"`
- **Opcións**:
  - `-c comentario`: Engade un comentario sobre o usuario.
  - `-d directorio`: Directorio home do usuario.
  - `-m`: Crea o directorio home se non existe.
  - `-g grupo`: Grupo principal do usuario.
  - `-G grupo1,grupo2`: Outros grupos aos que o usuario será engadido.
  - `-s shell`: Shell de conexión para o usuario.

#### `usermod`
- **Descrición**: Modifica contas de usuario existentes.
- **Exemplo**: `usermod [opcións] usuario`
- **Opcións**:
  - `-c comentario`: Modifica ou engade un comentario.
  - `-d directorio`: Cambia o directorio home do usuario.
  - `-g grupo`: Cambia o grupo principal do usuario.
  - `-G grupo1,grupo2`: Modifica outros grupos aos que o usuario pertence.
  - `-s shell (/bin/bash x ex)`: Cambia o shell de conexión.
  - `-l novo_nome`: Cambia o nome de usuario.
  - `-L usuario`: Bloquea a conta de usuario.
  - `-U usuario`: Desbloquea a conta de usuario.
  - `-e data`: Establece a data de expiración da conta.
  - `-f días`: Número de días nos que a conta pode permanecer inactiva antes de eliminarse.

#### `userdel`
- **Descrición**: Elimina contas de usuario.
- **Exemplo**: `userdel usuario`
- **Opcións**:
  - `-r`: Elimina o directorio home do usuario e o seu correo.

#### `passwd`
- **Descrición**: Cambia ou administra contrasinais.
- **Exemplo**: `passwd -d usuario`
- **Opcións**:
  - `-d`: Borra a contrasinal do usuario, permitindo acceso sen contrasinal.
  - `-f`: Forza ao usuario a cambiar a contrasinal no próximo inicio de sesión.
  - `-w`: Establece o número de días antes de que un usuario deba cambiar a súa contrasinal.
  - `-i`: Establece o número de días despois de que a contrasinal expire antes de que a conta se bloquee.
  - `-s`: Amosa información sobre a contrasinal do usuario. (Bloqueado: LK, Ten contrasinal: PS, Inactivo: NP)
  - `-r número`: Número de intentos permitidos para cambiar unha contrasinal e poñela correcta.
  - `-n días`: Establece o mínimo de días antes de permitir un cambio de contrasinal.
  - `-x días`: Establece o máximo de días antes de que a contrasinal expire.
  - `-w días`: Establece unha advertencia de días antes da expiración da contrasinal.
  - `-i días`: Inhabilita a conta despois de certos días de expirada a contrasinal.

#### `groupadd`
- **Descrición**: Crea un grupo novo.
- **Exemplo**: `groupadd desenvolvedores`
- **Opcións**:
  - `-g`: GID do grupo.
  - `-r`: Crea un grupo de sistema.

#### `groupmod`
- **Descrición**: Modifica grupos existentes.
- **Exemplo**: `groupmod -n desenvolvedores_novo desenvolvedores`
- **Opcións**:
  - `-n novo_nome`: Cambia o nome do grupo.

#### `groupdel`
- **Descrición**: Elimina un grupo.
- **Exemplo**: `groupdel desenvolvedores`
- **Opcións**:
  - Sen opcións específicas relevantes.


## Xestión de procesos

#### `ps`
- **Descrición**: Amosa información sobre os procesos activos.
- **Exemplo**: `ps -e`
- **Opcións**:
  - `aux` para amosar procesos para todos os usuarios.
  - `forest` para amosar procesos en forma de árbore.
  - `-e` para amosar todos os procesos.
  - `-f` para amosar información detallada.
  - `-u` para amosar procesos dun usuario.
  - `-x` para amosar procesos sen terminal asociada.

#### `top`
- **Descrición**: Amosa unha vista dinámica dos procesos en execución.
- **Exemplo**: `top` amosa procesos e o seu uso de recursos en tempo real.
- **Opcións**:
  - `q` para saír de `top`.
  - `P` para ordenar por uso de CPU.
  - `M` para ordenar por uso de memoria.
  - `u` para filtrar por usuario.
  - `k` para matar un proceso.
  - `r` para renicear un proceso.

#### `kill`
- **Descrición**: Envia sinais aos procesos para controlar a súa execución.
- **Exemplo**: `kill -9 [PID]` termina un proceso de forma forzosa.
- **Opcións**:
  - `-l` para amosar unha lista de sinais.
  - `-9` para enviar a sinal SIGKILL (SIGKILL: termina inmediatamente).
  - `-15` para enviar a sinal SIGTERM (SIGTERM: termina "amablemente").

#### `jobs`
- **Descrición**: Lista os traballos na sesión actual da terminal.
- **Exemplo**: `jobs` amosa todos os traballos activos.

#### `bg`
- **Descrición**: Reanuda a execución dun traballo detido en segundo plano.
- **Exemplo**: `bg %1` continúa co primeiro traballo listado por `jobs` en segundo plano.

#### `fg`
- **Descrición**: Move traballos ao primeiro plano.
- **Exemplo**: `fg %1` leva o primeiro traballo ao primeiro plano.

#### `nohup`
- **Descrición**: Executa comandos que permanecen activos despois de pechar a terminal.
- **Exemplo**: `nohup ./script &` executa un script en segundo plano que non se termina ao pechar a terminal.
- 
#### `grep`
- **Descrición**: Filtra texto con expresións regulares.
- **Exemplo**: `ps aux | grep firefox` amosa procesos relacionados con Firefox.
- **Opcións**:
  - `-i` para ignorar maiúsculas e minúsculas.
  - `-v` para invertir a busca.
  - `-c` para amosar o número de coincidencias.
  - `-n` para amosar o número de liña de cada coincidencia.

## Utilidades de Monitorización

#### `htop`
- **Descrición**: Alternativa interactiva a `top` cunha interface máis rica.
- **Exemplo**: `htop` amosa unha vista interactiva e colorida dos procesos en execución.
- **Opcións**:
  - `F2` para configurar `htop`.
  - `F3` para buscar procesos.
  - `F4` para filtrar procesos.
  - `F5` para ordenar procesos.
  - `F6` para seleccionar columnas.
  - `F9` para enviar sinais a procesos.
  - `F10` para saír de `htop`.

#### `pstree`
- **Descrición**: Amosa os procesos en forma de árbore.
- **Exemplo**: `pstree` visualiza a xerarquía de procesos do sistema.
- **Opcións**:
  - `-p` para amosar os PIDs dos procesos.
  - `-u` para amosar o usuario que iniciou cada proceso.


## Xestión da Prioridade de Procesos

#### `nice`
- **Descrición**: Inicia un proceso cunha prioridade dada.
- **Exemplo**: `nice -n 10 ./script` executa `script` cunha prioridade baixa.
- **Opcións**:
  - `-n` para especificar a nova prioridade.
  - `-20` para a prioridade máis alta.
  - `19` para a prioridade máis baixa.

#### `renice`
- **Descrición**: Cambia a prioridade de procesos en execución.
- **Exemplo**: `renice 10 -p [PID]` cambia a prioridade dun proceso existente a 10.
- **Opcións**:
  - `-n` para especificar a nova prioridade.
  - `-g` para cambiar a prioridade dun grupo.
  - `-u` para cambiar a prioridade dun usuario.
  - `-p` para especificar o PID do proceso.
  - `-g` para especificar o GID do grupo.

## Información do Sistema

#### `/proc`
- **Descrición**: Directorio virtual que contén información detallada do sistema e dos procesos.
- **Exemplo**: `cat /proc/cpuinfo` amosa información sobre a CPU.
- **Nota**: `/proc` non contén arquivos reais, senón información do sistema en tempo real.

#### `dmesg`
- **Descrición**: Amosa mensaxes do kernel, útil para diagnosticar problemas.
- **Exemplo**: `dmesg | grep usb` amosa mensaxes do kernel relacionadas con dispositivos USB.


## Xestión de Tarefas Programadas

#### `cron`
- **Descrición**: Programa tarefas para executalas automaticamente en horarios predefinidos.
- **Exemplo**: Editar `/etc/crontab` para engadir unha tarefa cronizada.

#### `at`
- **Descrición**: Programa comandos para executarse unha soa vez nun momento específico.
- **Exemplo**: `echo "sh backup.sh" | at 23:00` programa un script de copia de seguridade para executarse ás 23:00.


## Uso de Sinais

- **SIGKILL (`kill -9`)**: Termina procesos de forma inmediata.
  - **Exemplo**: `kill -9 [PID]` 
- **SIGTERM (`kill -15`)**: Termina procesos de forma suave, permitindo a limpeza.
  - **Exemplo**: `kill -15 [PID]`
- **SIGSTOP**: Detén temporalmente un proceso.
  - **Exemplo**: `kill -STOP [PID]`
- **SIGCONT**: Continúa con un proceso previamente detido.
  - **Exemplo**: `kill -CONT [PID]`


## Execución en Segundo Plano

- **Descripción**: Permite executar procesos sen bloquear a terminal.
- **Exemplo**: `command &` executa `command` en segundo plano.

---

# Examen Comandos
1. Cales son os permisos do cartafol "contabilidade" contido en exame? Podes escribir nesa carpeta co teu usuario actual?

`ls -l`

2. Como hai que facer para poder mudar os permisos de "contabilidade" para que, membros do grupo do usuario actual, poidan ler o contido do cartafol e traballar cos seus ficheiros?

`chmod 750 contabilidade/`

3. Como se pode comprobar quen é o dono do cartafol "contabilidade"? Como se pode mudar o dono para que sexa agora o usuario "comercial1"?

`ls -l`

`chown -R comercial1 contabilidade/`

4. Como se pode realizar a operación do punto 2 a tódolo contido no cartafol de unha soa vez? Como se pode facer a operación do punto 3 a tódolo contido do cartafol de unha soa vez?

`chmod -R 750 contabilidade/`

`chown -R comercial1 contabilidade/`

5. Mudar os permisos do cartafol compras de forma que se retire o permiso de paso para tódolos demais usuarios que non sexan o dono, nin pertencentes ao grupo definido para o cartafol.

`ls -l`

`chmod 754 compras/`

6. Como mostrar por pantalla o listado dos ficheiros de dentro de ventas que comecen por ventas e o ano sexa entre o 1990 e 1999?

`ls ventas199[0-9]`

7. Como se pode mover o ficheiro clientes.txt a compras? Como tes que facer para que iso sexa posible?

`mv ventas/clientes.txt compras/`

8. Como se crea un enlace ao ficheiro clientes.txt, chamado enlaceClientes, que está situado actualmente no cartafol compras? Utilizando o enlace enlaceClientes visualiza por pantalla o contido do ficheiro. Que ten de contido?

`ln compras/clientes.txt enlaceClientes`

`cat enlaceClientes`

9. Como se crea un enlace simbólico o cartafol norte (ventas/zoas) no cartafol exame? Como se pode facer para que siga sendo funcional si o movemos de cartafol?

`ln -s ventas/zoas/norte`

10. Tes un proceso activo chamado "gnome-terminal-server"? Cal é o seu PID? Copia e pega a parte do listado que permita corroborar iso.

`ps -e --> 2480`

11. Que significa a columna do listado que pon "links"?

`Enlaces a directorios ou ficheiros`

12. Elimina o proceso "gnome-terminal-server" desde a consola. Cal é o comando?

`ps -ef | grep nautilus-dekstop`
`pstree -ps 7329`


14. Borrar o contido de ventas e tódolo seu contido cunha soa instrucción.

`rm -rf ventas/*`