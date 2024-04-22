# ***JAVA DAM1***
## *1ª EVALUACIÓN*
### *by: [Anxo Fdez]*
#### *github: [Anx0Fdez](https://github.com/Anx0Fdez)*

---

# **INDICE**
1. [**MODIFICADORES DE ACCESO**](#modificadores-de-acceso)
2. [**Extends**](#extends)
3. [**Constructor**](#constructor)
4. [**Métodos**](#métodos)
5. [**Crear y llamar objetos**](#crear-y-llamar-objetos)
6. [**Condicionales**](#condicionales)
7. [**Bucles**](#bucles)
8. [**Metodos static**](#metodos-static)
9. [**Constantes**](#constantes)
10. [**Variables y tipos de datos**](#variables-y-tipos-de-datos)
11. [**Clases**](#clases)
---
## ***Boletines | Ejercícios***
- [***Boletines 1ª Evaluación***](https://github.com/Anx0Fdez/DAM/tree/afcad6763d2251e768409ac5b289edf4fee1c301/PROGRAMACION/PROG-EJERC/1Trimestre)

---
## *MODIFICADORES DE ACCESO*
### `public` *El acceso a la clase, método o variable es ilimitado.*
### `private` *El acceso a la clase, método o variable es limitado.*
### `protected` *El acceso a la clase, método o variable es limitado, pero también se puede acceder a través de clases hijas.*
### `default` *El acceso a la clase, método o variable es limitado, pero también se puede acceder a través de clases del mismo paquete.*


## *Extends*
```java
public class Car extends Vehicle {
    private int espejos;
    // constructor con super
    public Car(String color, int maxSpeed, int espejos) {
        super(color, maxSpeed);
        this.espejos = espejos;
    }
}
```
## *Constructor*
### Constructor por defecto
- *Se utiliza para llamar metodos o atributos de la clase*
```java
//
public class Car {
    public Car() {
    }
}
```
### Constructor con parametrizado
- *Sirve crear un objeto con parametros o atributos*
- *Se utiliza para crear objetos*
```java
public class Car {
    private String color;
    private int maxSpeed;

    public Car(String color, int maxSpeed) {
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
```
##  *Métodos*
```java
//void: retorna nada
//() : no recibe parámetros
public class Car {
    public void drive() {
        System.out.println("Car is moving");
    }
}
```
##  *Crear y llamar objetos*
```java
public class Main {
    public static void main(String[] args) {
        // Crear un objeto
        Car car = new Car();
        // Llamar a un método
        car.drive();
    }
}
```

##  *Condicionales*
###  `If else`
```java
if (a > b) {
    System.out.println("a es mayor que b");
} else if (a < b) {
    System.out.println("a es menor que b");
} else {
    System.out.println("a es igual a b");
}
```
###  `Switch`
- *El valor que va despues del case es le valor que tenemos que meter por teclado para que se ejecute*
```java
switch (a) {
    case 1:
        System.out.println("a es 1");
        break;
    case 2:
        System.out.println("a es 2");
        break;
    default:
        System.out.println("a no es ni 1 ni 2");
        break;
}
```
##  *Bucles*
### `while` Mientras se cumpla la condición  (true/false)
- *No se ejecuta si la condición es falsa*
- *Se ejecuta 0 o más veces*
```java
while (int a = 0, a < 10) {
    System.out.println(a);
    a++;
}
```
### `do while` Haz esto mientras se cumpla la condición (true/false)
- *Se ejecuta al menos una vez*
- *Se ejecuta 1 o más veces*
```java
do {
    System.out.println(a);
    a++;
} while (a < 10);
```
### `for`
- *El bucle for se ejecuta un número específico de veces establecido en el limite*
```java
for (int a = 0; a < 10; a++) {
    System.out.println(a);
}
```

## *Metodos static*
Sirve para llamar a un método sin tener que crear un objeto. (Se llama a través de la clase.)
```java
public class Car {
    public static void honk() {
        System.out.println("Honk honk!");
    }
}
```

##  *Constantes*
Las constantes se declaran con la palabra reservada `final` y en mayúsculas.
```java
final int NUM = 10;
```


##  *Variables y tipos de datos*
```java
int a = 10;
float b = 10.5f;
double c = 10.5;
char d = 'A';
String e = "Hello";
boolean f = true;
```
##  *Clases*

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```