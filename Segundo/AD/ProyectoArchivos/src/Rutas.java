import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * La clase Rutas proporciona métodos para interactuar con el sistema de archivos.
 * Incluye métodos para verificar si un directorio o archivo existe, crear nuevos directorios y archivos,
 * cambiar permisos de archivos, eliminar archivos y directorios, y mostrar el contenido de directorios.
 */
public class Rutas {

    /**
     * Solicita al usuario que introduzca una ruta de directorio y verifica si el directorio existe.
     * Imprime un mensaje indicando si el directorio existe o no.
     */
    public void eDirectorio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio: ");
        String ruta = sc.nextLine();
        File directorio = new File(ruta);
        if (directorio.exists()) {
            System.out.println("El directorio existe");
        } else {
            System.out.println("El directorio no existe");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de archivo y verifica si la ruta corresponde a un archivo.
     * Imprime un mensaje indicando si la ruta es de un archivo o no.
     */
    public void eFicheiro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce a ruta correspondente a un ficheiro:");
        String ruta = sc.nextLine();
        File ficheiro = new File(ruta);
        if (ficheiro.isFile()) {
            System.out.println("La ruta es de un fichero");
        } else {
            System.out.println("La ruta no es de un fichero");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de directorio y crea el directorio si no existe.
     * Imprime un mensaje indicando si el directorio fue creado o si ya existía.
     */
    public void crearDirectorio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio: ");
        String ruta = sc.nextLine();
        File directorio = new File(ruta);
        if (directorio.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            directorio.mkdir();
            System.out.println("Creando directorio...");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de directorio y un nombre de archivo, y crea el archivo en el directorio especificado.
     * Imprime un mensaje indicando si el archivo fue creado o si el directorio ya existía.
     */
    public void crearFicheiro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio en la que quieres crear el fichero: ");
        String ruta = sc.nextLine();
        System.out.println("Introduce el nombre del fichero nuevo:");
        String nombre = sc.nextLine();

        File novoFicheiro = new File(ruta, nombre);

        if (novoFicheiro.exists()) {
            System.out.println("El directorio ya existe");
        } else {
            try {
                System.out.println("Creando directorio...");
                novoFicheiro.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo");
            }
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de directorio y un nombre de archivo, y muestra los permisos de lectura y escritura del archivo.
     * Imprime un mensaje indicando si el archivo se puede leer y escribir.
     */
    public void modoAcceso() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio del archivo que quieres ver sus permisos: ");
        String ruta = sc.nextLine();
        System.out.println("Introduce el nombre del directorio del archivo que quieres ver sus permisos:");
        String nombre = sc.nextLine();

        File novoFicheiro = new File(ruta, nombre);

        if (novoFicheiro.exists()) {
            System.out.println("Se puede leer el archivo: " + novoFicheiro.canRead());
            System.out.println("Se puede escribir en el archivo: " + novoFicheiro.canWrite());
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de directorio y un nombre de archivo, y calcula el tamaño del archivo en bytes.
     * Imprime un mensaje indicando el tamaño del archivo en bytes.
     */
    public void calculaLonxitude() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio del archivo que quieres calcular su peso en bytes: ");
        String ruta = sc.nextLine();
        System.out.println("Introduce el nombre del directorio del archivo que quieres calcular su peso en bytes:");
        String nombre = sc.nextLine();

        File novoFicheiro = new File(ruta, nombre);
        if (novoFicheiro.exists()) {
            System.out.println("El archivo tiene una longitud de: " + novoFicheiro.length() + " bytes");
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de directorio y un nombre de archivo, y cambia el permiso de lectura del archivo a solo lectura.
     * Imprime un mensaje indicando que los permisos han sido cambiados.
     */
    public void mLectura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio del archivo que quieres cambiar su permiso de lectura: ");
        String ruta = sc.nextLine();
        System.out.println("Introduce el nombre del directorio del archivo que quieres cambiar su permiso de lectura:");
        String nombre = sc.nextLine();

        File novoFicheiro = new File(ruta, nombre);
        if (novoFicheiro.exists()) {
            System.out.println("Cambiando permisos... ");
            novoFicheiro.setReadOnly();
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de directorio y un nombre de archivo, y cambia el permiso de escritura del archivo a solo lectura.
     * Imprime un mensaje indicando que los permisos han sido cambiados.
     */
    public void mEscritura() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio del archivo que quieres cambiar su permiso de escritura: ");
        String ruta = sc.nextLine();
        System.out.println("Introduce el nombre del directorio del archivo que quieres cambiar su permiso de escritura:");
        String nombre = sc.nextLine();

        File novoFicheiro = new File(ruta, nombre);
        if (novoFicheiro.exists()) {
            System.out.println("Cambiando permisos... ");
            novoFicheiro.setWritable(true);
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de archivo y un nombre de archivo, y elimina el archivo especificado.
     * Imprime un mensaje indicando si el archivo fue eliminado o si no existía.
     */
    public void borraFicheiro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo del archivo que quieres eliminar: ");
        String ruta = sc.nextLine();
        System.out.println("Introduce el nombre del archivo del archivo que quieres eliminar:");
        String nombre = sc.nextLine();

        File novoFicheiro = new File(ruta, nombre);
        if (novoFicheiro.exists()) {
            System.out.println("Eliminando archivo... ");
            novoFicheiro.delete();
        } else {
            System.out.println("El archivo no existe");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de directorio y elimina el directorio especificado.
     * Imprime un mensaje indicando si el directorio fue eliminado o si no existía.
     */
    public void borraDirectorio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio: ");
        String ruta = sc.nextLine();
        File directorio = new File(ruta);
        if (directorio.exists()) {
            System.out.println("Borrando directorio...");
            directorio.delete();
        } else {
            System.out.println("El directorio no existe");
        }
    }

    /**
     * Solicita al usuario que introduzca una ruta de directorio y muestra el contenido del directorio.
     * Imprime un mensaje indicando el contenido del directorio o si el directorio no existe.
     */
    public void mContido() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del directorio del que quieres ver su contenido: ");
        String ruta = sc.nextLine();
        File directorio = new File(ruta);
        if (directorio.exists()) {
            System.out.println("El contenido del directorio es:");
            String[] contenido = directorio.list();
            if (contenido != null) {
                for (String item : contenido) {
                    System.out.println(item);
                }
            } else {
                System.out.println("El directorio está vacío o no se puede leer.");
            }
        } else {
            System.out.println("El directorio no existe");
        }
    }
}