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
```
```sql
select user; -- Ver usuario actual
psql dam postgres -- Conectarse a una base de datos con usario postgres
psql dam a -- Conectarse a una base de datos con usario a
\c dam -- Conectarse a una base de datos (cambiar de base de datos)
\dn -- Ver esquemas
\du -- Ver usuarios
\dt -- Ver tablas
\dv -- Ver vistas
\dp -- Ver permisos de usuarios en tablas
\l -- Ver bases de datos
\z -- Ver permisos de usuarios en vistas y tablas
\dt a.* -- Ver tablas de otro usuario
show search_path; -- Ver en que esquemas por defecto el sistema va a buscar las tablas
```
```sql
create database dam; -- Crear base de datos
create user a with password 'a'; -- Crear usuario
```
#### *CREAR Y ADMINISTRAR ESQUEMAS*
```sql
1.01 create schema a authorization a; -- Crear esquema
1.02 drop schema a; -- Eliminar esquema

alter user u3 in database dam set search_path to es3; -- Cambiar el esquema por defecto de un usuario
alter schema es4 owner to u4; -- Cambiar el propietario de un esquema
```
#### *CREAR Y ADMINISTRAR TABLAS*

```sql
crete table t1 (a int); -- Crear tabla
select * from pg_tables where tableowner='u3'; -- Ver tablas de un usuario
select * from a.t1; -- Ver tabla

insert into t1 values (1); -- Insertar valores
```
#### *CREAR Y ADMINISTRAR PERMISOS*
```sql
VER PERMISOS DE UN USUARIO [SELECT]
select * from information_schema.table_privileges where grantee = 'u3'; -- Ver permisos de un usuario
select * from information_schema.table_privileges where table_name = 'equipo'; -- Ver permisos de una tabla
```

```sql
DAR PERMISOS ENTRE USUARIOS [GRANT]
-- Debes estar conectado con el usuario a ("psql dam a")
-> grant select on t1 to b; -- Dar permisos a b en la tabla t1
-> grant USAGE on schema a to b; -- Dar permisos a b en el esquema a
-> alter default privileges in schema a grant select on tables to b; -- Dar permisos por defecto a b
-> grant insert on es3.equipo to u4 with grant option; -- Dar permisos a u4 con opcion de dar el mismo permiso a otros
```
```sql
QUITAR PERMISOS ENTRE USUARIOS [REVOKE]
-- Debes estar conectado con el usuario a ("psql dam a")
-> revoke insert on t4 from b; -- Quitar permisos a b en la tabla t4
-> revoke insert on t4 from b cascade; -- Quitar permisos a b en la tabla t4 y a los objetos que dependen de ella
```
#### *VISTAS*
```sql
-- Una vista es una tabla virtual que se crea a partir de una consulta
1.1 create view v as select nomx, codequ from xogador; -- Crear vista
1.2 create or replace view v2 as select codx, nomx, xogador.codequ, nomequ from xogador, equipo where xogador.codequ = equipo.codequ and xogador.codequ='e1'; -- Crear vista con de dos tablas
2. select * from v; -- Ver vista
3. drop view v; -- Eliminar vista
```

### ***<u>ERRORES FRECUENTES</u>***
```sql
-- Errores frecuentes en PostgreSQL
ERROR: permission denied for relation t1 -- No tienes permisos para ver la tabla t1
ERROR: permission denied for schema a -- No tienes permisos para ver el esquema a
ERROR: permission denied for database dam -- No tienes permisos para ver la base de datos dam
ERROR:  null value in column "codx" of relation "xogador" violates not-null constraint -- No exiate la clave primaria en la vista
ERROR: cannot insert into v2 values('x41', 'luis', 'e9', 'laso'); -- No se puede insertar en una vista con dos tablas
```

