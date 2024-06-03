# ***PostgreSQL***
### *by: [Anxo Fdez]*
#### *github: [Anx0Fdez](https://github.com/Anx0Fdez)*

---
## `Gestión de Permisos`
Gestión de permisos en PostgreSQL. Es importante tener en cuenta que en PostgreSQL, los permisos se gestionan a nivel de objeto, es decir, se pueden asignar permisos a tablas, vistas, secuencias, funciones, etc.

### ***<u>COMANDOS PRINCIPALES</u>***
```sql
sudo pluma /etc/postgresql/13/main/pg_hba.conf -- Editar archivo de configuración
sudo systemctl reload postgresql -- Reiniciar 
-----------------------------------------------------------------
select user; -- Ver usuario actual
psql dam postgres -- Conectarse a una base de datos con usario postgres
psql dam a -- Conectarse a una base de datos con usario a
\c dam -- Conectarse a una base de datos (cambiar de base de datos)
\dn -- Ver esquemas
\dn+ -- Ver esquemas con descripción y privi
\du -- Ver usuarios
\dt -- Ver tablas
\d tabla -- Ver descripción de una tabla
\dv -- Ver vistas
\dp+ -- Ver permisos de usuarios en tablas
\l -- Ver bases de datos
\z -- Ver permisos de usuarios en vistas y tablas
\dt a.* -- Ver tablas de otro usuario
show search_path; -- Ver en que esquemas por defecto el sistema va a buscar las tablas
CcT -> C: Create Schemas | c: connect
```
```sql
create database dam; -- Crear base de datos
dropdb -U postgres futbol2 -- Eliminar base de datos

create user a with password 'a'; -- Crear usuario
```
#### *CREAR Y ADMINISTRAR ESQUEMAS*
```sql
UC -> U: Usage | C: Create tables 
1.01 create schema a authorization a; -- Crear esquema
1.02 drop schema a; -- Eliminar esquema

alter user u3 in database dam set search_path to es3; -- Cambiar el esquema por defecto de un usuario
[DESPUES DE CAMBIAR EL ESQUEMA POR DEFECTO DE UN USUARIO, DEBEMOS REINICIAR LA SESIÓN]

alter schema es4 owner to u4; -- Cambiar el propietario de un esquema
```
#### *CREAR Y ADMINISTRAR TABLAS*

```sql
crete table t1 (a int); -- Crear tabla
select * from pg_tables where tableowner='u3'; -- Ver tablas de un usuario
select * from a.t1; -- Ver tabla
delete from t1; -- Eliminar contenido de la tabla
drop table t1; -- Eliminar tabla entera

insert into t1 values (1); -- Insertar valores
```
#### *CREAR Y ADMINISTRAR PERMISOS*
```sql
a -- Añadir (insert)
r -- Leer (select)
w -- Escribir (update)
d -- Borrar (delete)
```

|    Tipo    | Abreviatura |
|------------|-------------|
| Insert     | a           |
| Select     | r           |
| Update     | w           |
| Delete     | d           |
| Truncate   | D           |
| References | x           |
| Trigger    | t           |
| Usage      | U           |
| Create     | C           |
| Connect    | c           |
| Database   | CTc         |
```sql
VER PERMISOS DE UN USUARIO [SELECT]
select * from information_schema.table_privileges where grantee = 'u3'; -- Ver permisos de un usuario
select * from information_schema.table_privileges where table_name = 'equipo'; -- Ver permisos de una tabla
\z es3.* -- Ver permisos de un esquema
```
```sql
DAR PERMISOS ENTRE USUARIOS [GRANT]
-- Debes estar conectado con el usuario a ("psql dam a")
-> grant select on t1 to b; -- Dar permisos a b en la tabla t1
-> grant USAGE on schema a to b; -- Dar permisos a b en el esquema a
-> alter default privileges in schema a grant select on tables to b; -- Dar permisos por defecto a b
-> grant insert on es3.equipo to u4 with grant option; -- Dar permisos a u4 con opcion de dar el mismo permiso a otros
-> grant select (codx, nomx) on xogador to u4; -- Dar permisos a u4 en las columnas codx y nomx de la tabla xogador

grant update (campo) on tabla to usuario; -- Dar permiso editar un capo especifico de una tabla
```
```sql
QUITAR PERMISOS ENTRE USUARIOS [REVOKE]
-- Debes estar conectado con el usuario a ("psql dam a")
-> revoke insert on t4 from b; -- Quitar permisos a b en la tabla t4
-> revoke insert on t4 from b cascade; -- Quitar permisos a b en la tabla t4 y a los objetos que dependen de ella
-> revoke all on t4 from b; -- Quitar todos los permisos a b en la tabla t4
-> revoke connect on database dam from b; -- Quitar permisos a b en la base de datos dam
```

#### *VISTAS*
```sql
-- Una vista es una tabla virtual que se crea a partir de una consulta
1.1 create view v as select nomx, codequ from xogador; -- Crear vista
1.2 create or replace view v2 as select codx, nomx, xogador.codequ, nomequ from xogador, equipo where xogador.codequ = equipo.codequ and xogador.codequ='e1'; -- Crear vista con de dos tablas
2. select * from v; -- Ver vista
3. drop view v; -- Eliminar vista
```
#### *ROLES*
```sql
create role readonly; -- Crear rol
grant connect on database dam to readonly; -- Dar permisos a un rol
grant insert on es3.xogador to readonly; -- Dar permisos a un rol
grant readonly to u4; -- Dar rol a un usuario
```

#### *PERMISOS A NIVEL DE FILA*
```sql
alter table factura enable row level security; -- Habilitar permisos a nivel de fila

'POLITICAS PERMISIVAS'
1. create policy solo_finalizada on facturas to contabilidad using (finalizada=TRUE); -- Crear política forma 1
2. create policy todas_as_filas on facturas to vwntas using (TRUE); -- Crear política forma 2

'POLITICAS RESTRICTIVAS'
create polity non_borrar on facturas as restrictive for delete to public using (finalizada=FALSE); -- Crear política restrictiva

'ELIMINAR POLÍTICAS'
drop policy solo_finalizada on facturas; -- Eliminar política

-- Postgres aplica primeiro a suma (OR) das politicas permisivas, a logo, sobre as filas que quedan aplica a multiplicación (AND) das politicas restrictivas.

rollback; -- Deshacer cambios

-- As politicas restrictivas seleccionan para a operacion espacificada as filas que cumplan as espresions Using utilizada
```

##  <u>*Copias de seguridade e restauración*</u>
### `EXPORTAR E IMPORTAR BASE DE DATOS`
#### `PGDUMP`

```sql
-> pg_dump -U postgres -Fp futbol2 > f2.dump -- Exportar base de datos a un fichero llamado `f2.dump`
    ->> \i f2.dump -- Importar base de datos desde un fichero llamado `f2.dump`
-> pg_dump -U postgres -Fc futbol2 > f2c.dump -- Exportar base de datos a un fichero comprimido llamado `f2c.dump`
    ->> pg_restore -U postgres -C -d postgres f2c.dump -- Importar base de datos desde un fichero comprimido llamado `f2c.dump`

    pg_dump -U postgres -a --inserts -Fp futbol2 > f.dump

    pg_dump -U postgres -a --column-inserts -Fp futbol2 > f.dump
    create table fa.equipo; -- Crear tabla

-> pg_dump -U postgres -n 'fa' -Fp futbol2 > f.dump -- Exportar esquema fa a un fichero llamado `f.dump`
-> pg_dump -U postgres -N 'fa' -Fp futbol2 > f.dump -- Exportar todo menos el esquema fa a un fichero llamado `f.dump`
-> pg_dump -U postgres -N 'fu' -N 'public' -Fp futbol2 > f.dump  -- Exportar todo menos los esquemas fu y public a un fichero llamado `f.dump`
-> pg_dump -U postgres -N 'fu' -T 'equipo' -Fp futbol2 > f.dump -- Exportar todo menos el esquema fu y la tabla equipo a un fichero llamado `f.dump`
-> pg_dump -U postgres -c -Fp futbol2 > f.dump -- Exportar base de datos con la estructura de la base de datos
-> pg_dump -U postgres --table='fu.x*' -Fp futbol2 > fup.dump -- Exportar tablas que empiecen por 'fu.x' a un fichero llamado `f2.dump`
-> pg_dump -U postgres -s -d futbol2 > f2.dump -- Exportar solo la estructura de la base de datos a un fichero llamado `f2.dump`


pg_dump -U postgres --table='fu.x' -Fp futbol2'* - Exporta solo las tablas del esquema fu que empiecen por x.
pg_dump -U postgres --table='fu.x' --table='fu.interven' --table='fu.adestra' -Fp futbol2 > fup2.dump* - Exporta solo las tablas del esquema fu que empiecen por x, y que contengan interven e adestra, y se copia en el fichero fup2.dump.
pg_dump -U postgres -a --table='fu.x' --table='fu.interven' --table='fu.adestra' -Fp futbol2 > fup2.dump* - Si se le añade -a solo va a exportar los datos de las tablas, no las tablas enteras (no podrá volver a crear las tablas). Algunos de los parámetros más útiles para la creación de copias de seguridad:
pg_dump -U postgres -s -t fu.x -t fu.interven -Fp futbol2 > f2.dump -- exportar la estructura de dos tablas de la base de datos futbol2 a un fichero llamado f2.dump
pg_dump -U postgres -t fu.xogador -Fp futbol2 > f2.dump -- exportar en un archivo de texto la tabla xogador de la base de datos futbol2 
```

#### `PGRESTORE`
```sql
-> pg_restore -U postgres -a -d futbol2 f2.dump -- Restaurar base de datos desde un fichero llamado `f2.dump`
    -- Opciones a la hora de exportar una base de datos:
    -a --> datos
    -s --> estructura

-> pg_restore -U postgres -C -d postgres f2c.dump -- Restaurar base de datos desde un fichero comprimido llamado `f2c.dump`
-> pg_restore -U postgres -d futbol2 f2.dump -- Restaurar base de datos desde un fichero llamado `f2.dump`


```

### `CREAR BASE DE DATOS A PARTIR DE UNA PLANTILLA`
```sql
-> createdb -U postgres -T template0 futbolrestaurada -- Crear base de datos a partir de una plantilla
-> pg_restore -U postgres -d futbolrestaurada f2.dump -- Restaurar base de datos desde un fichero llamado `f2.dump`

pg_dump -U postgres --table='fu.x*' -Fp futbol2 > fup.dump -- Exportar tablas que empiecen por 'fu.x' a un fichero llamado `f2.dump`
```

### `TRANSCIONES`
```sql
begin; -- Iniciar transacción
    insert into t1 values (1); -- Insertar valores
    insert into t1 values (2);

commit; -- Confirmar transacción
rollback; -- Deshacer transacción
```

### `DEPENDENCIAS DE PERMISOS DE TABLAS` 
```sql

---
### ***[ERRORES FRECUENTES]***
```sql
-- Errores frecuentes en PostgreSQL
ERROR: permission denied for relation t1 -- No tienes permisos para ver la tabla t1
ERROR: permission denied for schema a -- No tienes permisos para ver el esquema a
ERROR: permission denied for database dam -- No tienes permisos para ver la base de datos dam
ERROR:  null value in column "codx" of relation "xogador" violates not-null constraint -- No exiate la clave primaria en la vista
ERROR: cannot insert into v2 values('x41', 'luis', 'e9', 'laso'); -- No se puede insertar en una vista con dos tablas
```

## *`EXAMEN`*
<details>
  <summary></summary>

  ```sql
QUÉ ENTRA EN EL EXAMEN:
-- Crear bases, usuarios, esquemas, vistas, roles (de privilexios, de usuarios)
-- Borrar bases, usuarios, esquemas, vistas, roles
-- Privilexios para todo lo anterior
Privilexios sobre obxectos a nivel de tabla y de columna --> ACL (Access Control List) 
         - Tabla: insert, delete, update, select 
         - Columna: select, update
         - Con posibilidade de darllo a outros: with grant option
Privilexios a nivel de fila --> RLS (Row Level Security)
         - Permisivas
         - Restrictivas
Diccionario de datos (vistas con información del sistema)
         - Comandos abreviados
         - Vistas
         - Vistas con información do sistema
Copias de seguridade e restauración
         - pg_dump
         - pg_restore
Transacciones
         Begin;
            operaciones
         commit; (se confirma) / rollback; (se deshace)
```



