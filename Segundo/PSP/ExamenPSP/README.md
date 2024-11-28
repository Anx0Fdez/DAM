# Preguntas teóricas Examen PSP

## Exercicio 4
**Este programa sacaria por pantalla:**

- Primeiro: Executarase o "Hio Alta Prioridad" xa que mediante `thread.MAX_PRIORITY` damos a prioridad maxima a execución de dito fio.

- Segundo: Executarase o fio "Hlio Baja Priroridad" xa este ten `MIN_PRIORITY` o que da a minima prioridad ao fio, polo que se executara antes os fios con maior prioridad.


### Saida do Programa:

```java
Hilo Alta Prioridad está ejecutandose.
Hilo Baja Prioridad está ejecutandose.

Process finished with exit code 0
```
---

## Exercicio 5

O código ten un problema de concorrencia debido ao acceso non sincronizado á variable estática **"contador"**. Isto pode causar resultados erroneos cando múltiples fíos intentan modificar este.

Para solucionar isto, temos que **sincronizar** o bloque de código que incrementa contador. Para isto imos facer uso dun bloque `synchronized` para asegurar que só un fío á vez poida acceder e modificar a variable contador. Isto prevén condicións de carreira polo que se asegura que o resultado de cada fio sexa o correcto.


---
## Exercicio 6

Non se require ninguna modificación para o seu funcionamiento básico xa que utiliza a sincronización e os métodos `wait()` e `notifyAll()` para coordinar o acceso ao recurso compartido `CubbyHole`. 
