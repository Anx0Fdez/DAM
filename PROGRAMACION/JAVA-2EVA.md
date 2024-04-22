# ***JAVA DAM1***
## *2ª EVALUACIÓN*
### *by: [Anxo Fdez]*
#### *github: [Anx0Fdez](https://github.com/Anx0Fdez)*

---

# **INDICE**

1. [**Serialización**](#serialización)
2. [**Escritura y lectura de ficheros**](#escritura-y-lectura-de-ficheros)
3. [**Genéricos**](#genéricos)
4. [**Colecciones**](#colecciones)
5. [**ArrayList**](#arraylist)
6. [**For each**](#for-each)
7. [**Interfaces**](#interfaces)
8. [**Clases abstractas**](#clases-abstractas)
9. [**Exceptions [try cach]**](#exceptions-try-cach)
10. [**Arrays**](#arrays)

---

## *Serialización*
Imagina que la serialización en Java es como guardar un dibujo en un sobre para enviarlo por correo. Para hacerlo:

- Tienes un dibujo (objeto) que quieres guardar.
- Pones ese dibujo dentro de un sobre (serialización).
- Cierras el sobre y lo envías por correo.
- Cuando llega al destinatario, abren el sobre (deserialización) y sacan el dibujo.

```java
import java.io.Serializable;

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }
}
``` 
Ahora vamos a ver cómo serializar y deserializar un objeto de esta clase:
```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Creamos un objeto Persona
        Persona persona = new Persona("Juan", 25);

        // Serializamos el objeto
        try {
            FileOutputStream fileOut = new FileOutputStream("persona.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(persona);
            out.close();
            fileOut.close();
            System.out.println("Objeto Persona serializado correctamente en persona.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserializamos el objeto
        Persona personaDeserializada = null;
        try {
            FileInputStream fileIn = new FileInputStream("persona.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            personaDeserializada = (Persona) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Clase Persona no encontrada");
            c.printStackTrace();
            return;
        }

        // Mostramos la información del objeto deserializado
        System.out.println("Objeto Persona deserializado:");
        System.out.println(personaDeserializada);
    }
}
```
En este ejemplo, creamos un objeto Persona con nombre "Juan" y edad 25. Luego, lo serializamos escribiéndolo en un archivo llamado persona.ser. Después, deserializamos este archivo para obtener de nuevo el objeto Persona y mostramos su información por pantalla.
## *Escritura y lectura de ficheros*
### `Escritura`
1. Crear el Archivo: Si el archivo no existe, Java lo creará. Si ya existe, puedes elegir entre sobreescribir o añadir los datos.
```java
import java.io.BufferedWriter;
import java.io.FileWriter;

String nombreArchivo = "tareas.txt";
FileWritter fr = new FileWritter(nombreArchivo);
```
2. Escribir el Contenido: Se usa un objeto FileWriter o BufferedWriter para escribir el texto en el archivo. (Vamos a hacerlo con fw, pero lo envolveremos en un bf para mayor eficiencia).
```java
BufferedWritter br = new BufferedWritter(fr);
```
3. Cerrar el Archivo: Es importante cerrar el archivo después de la lectura para liberar recursos y evitar problemas de acceso.
```java
br.close();
```
4. Buena Práctica: Crear una excepción por si hay algún problema a la hora de leer o abrir el archivo.
```java
try {
    // Código que puede lanzar una excepción
} catch (Exception e) {
    // Código que se ejecuta si se lanza una excepción
    System.out.println("Error leyendo el archivo: " + e.getMessage());
}
```

### `Lectura`
1. Abrir el Archivo: Se especifica la ubicación y el propósito de uso del archivo, creando un objeto File.

```java
String nombreArchivo = "tareas.txt";
FileReader fr = new FileReader(rutaArchivo);
```
2. Leer el Contenido: Se utiliza un objeto BufferedReader para leer el texto del archivo, ya sea línea por línea o todo de una vez.

```java
BufferedReader br = new BufferedReader(fr);
```
3. Cerrar el Archivo: Es importante cerrar el archivo después de la lectura para liberar recursos y evitar problemas de acceso.
```java
br.close();
```
4. Buena Práctica: Crear una excepción por si hay algún problema a la hora de leer o abrir el archivo.
```java
try {
    // Código que puede lanzar una excepción
} catch (Exception e) {
    // Código que se ejecuta si se lanza una excepción
    System.out.println("Error leyendo el archivo: " + e.getMessage());
}
```

## *Genéricos*
*Te permite engloar todos los tipos de datos mediante el dato genérico `T`*
```java
public class Box<T> {
    private T t;
    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}
```
```java
ArrayList<T> a = new ArrayList<>();
```


## *Colecciones*
### `HashSet`
Un HashSet es una colección de elementos únicos. No puede haber elementos duplicados.
```java
HashSet<String> set = new HashSet<String>();
set.add("Apple");
set.add("Banana");
set.add("Mango");
```
### `TreeSet`
Un TreeSet es una colección de elementos únicos. Los elementos se almacenan en orden ascendente.
```java
TreeSet<String> set = new TreeSet<String>();
set.add("Apple");
set.add("Banana");
set.add("Mango");
```
### `HashMap`
Un HashMap es una colección de pares clave-valor. Cada clave es única y no puede repetirse. Cada clave está asociada a un valor.
```java
HashMap<String, String> map = new HashMap<String, String>();
map.put("Spain", "Madrid");
map.put("France", "Paris");
map.put("England", "London");
```
### `TreeMap`
Un TreeMap es una colección de pares clave-valor. Las claves se almacenan en orden ascendente.
```java
TreeMap<String, String> map = new TreeMap<String, String>();
map.put("Spain", "Madrid");
map.put("France", "Paris");
map.put("England", "London");
```


## *ArrayList*
*Es una lista que almacena objetos o tipos de datos primitivos.*
```java
ArrayList<Coche> list = new ArrayList<>();

Coche audi = new Coche("Audi", "A3", 2000);
Coche mercedes = new Coche("Mercedes", "Clase A", 2000);
list.add(audi);
list.add(mercedes);
```
## *For each*
*El bucle for-each se utiliza para recorrer una colección de elementos.*
```java
for (String fruit : list) {
    System.out.println(fruit);
}
```
## *Interfaces*
`Una interfaz es una colección de métodos abstractos. Una clase implementa una interfaz, lo que significa que la clase proporciona una implementación para todos los métodos definidos en la interfaz.`
## *Clases abstractas*
`Una clase abstracta es una clase que no se puede instanciar. Se utiliza para definir clases que comparten algunas características comunes.`

## *Exceptions [try cach]*
```java
try {
    // código que puede lanzar una excepción
} catch (Exception e) {
    // código que se ejecuta si se lanza una excepción
} finally {
    // código que se ejecuta siempre
}
```

## *Arrays*
### *Array*
```java
//array de 5 elementos
int[] a = new int[5];
//array de 5 elementos inicializado
int[] b = {1, 2, 3, 4, 5};

//introducir un valor en un array
a[0] = 1;
a[1] = 21;
a[2] = 13;
```
### *Array multidimensional*
```java
//array de 5 elementos
int[][] a = new int[2][3];
//array de 5 elementos inicializado
int[][] b = {{1, 2, 3}, {4, 5, 6}};
//introducir un valor en un array
a[0][0] = 1;
a[0][1] = 2;
a[0][2] = 3;
```
---
### `Recorrer un array`
```java
for (int i = 0; i < a.length; i++) {
    System.out.println(a[i]);
}
```
### `Ordenar un array`
```java
Arrays.sort(a);
```
### `Buscar un elemento en un array`
```java
Arrays.binarySearch(3);
```
