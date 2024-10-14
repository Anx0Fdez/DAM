 # ***XPath***
### *by: [Anxo Fdez]*
#### *github: [Anx0Fdez](https://github.com/Anx0Fdez)*

---
# **INDICE**
1. [**¿Qué es XPath?**](#Qué-es-XPath)
2. [**Uso de XPath**](#Uso-de-XPath)

---
## `Qué es XPath?`
Xpath es un lenguaje de consulta que se utiliza para seleccionar nodos de un documento XML. XPath es una parte fundamental de XSLT y XQuery, que son tecnologías utilizadas para transformar y consultar documentos XML.


### ***Uso de XPath***
```xml
<bookstore>
  <book>
    <title lang="en">Harry Potter</title>
    <price>29.99</price>
  </book>
  <book>
    <title lang="en">Learning XML</title>
    <price>39.95</price>
  </book>
</bookstore>
```
- **/bookstore/book[1]/title** selecciona el primer título de libro en el documento.
- **/bookstore/book[last()]/title** selecciona el último título de libro en el documento.
- **/bookstore/book[position()<3]/title** selecciona los dos primeros títulos de libro en el documento.
- **//title[@lang]** selecciona todos los títulos de libro que tienen un atributo lang.
- **//title[@lang='en']** selecciona todos los títulos de libro que tienen un atributo lang con un valor de 'en'.
- **/bookstore/book[price>35.00]/title** selecciona los títulos de libro de los libros que cuestan más de 35.00.
- **/bookstore/book[price>35.00]/title | //title[@lang='en']** selecciona los títulos de libro de los libros que cuestan más de 35.00 y los títulos de libro en inglés.

## `Código Ejemplo XML`
<details>
<summary> <u>Click para ver el codigo</u></summary>
<br>

```xml
<universidade>
    <nome>Universidade de Vichocuntín</nome>
    <pais>Cerdedo</pais>

    
    <<[CARREIRAS]>>

     
    <carreiras>
        <carreira id="c01">
            <Nome>I.T. Informática</Nome>
            <plan>2003</plan>
            <creditos>250</creditos>
            <centro>Escola de Informática</centro>
        </carreira>
        <carreira id="c02">
            <Nome>Dipl. Empresariales</Nome>
            <plan>2001</plan>
            <creditos>275</creditos>
            <centro>Facultade de Ciencias Sociais</centro>
        </carreira>
        <carreira id="c03">
            <Nome>Dipl. Relacións Laborais</Nome>
            <plan>2001</plan>
            <creditos>280</creditos>
            <centro>Facultade de Ciencias Sociais</centro>
            <subdirector>Alfonso Martín Luque</subdirector>
        </carreira>
        <carreira id="c04">
            <nome>Lic. Quimica</nome>
            <plan>2003</plan>
            <creditos>175</creditos>
            <centro>Facultade de Ciencias Experimentais</centro>
        </carreira>
        <carreira id="c05">
            <nome>Lic. Biología</nome>
            <plan>2001</plan>
            <creditos>175</creditos>
            <centro>Facultade de Ciencias Experimentais</centro>
        </carreira>
        <carreira id="c06">
            <nome>Lic. Humanidades</nome>
            <plan>1980</plan>
            <creditos>475</creditos>
            <centro>Facultade de Humanidades</centro>
        </carreira>
    </carreiras>


    <<[ASIGNATURAS]>>


    <asignaturas>
        <asignatura id="a01" titulacion="c01">
            <Nome>Ofimática</Nome>
            <creditos_teoricos>3</creditos_teoricos>
            <creditos_practicos>1.5</creditos_practicos>
            <trimestre>1</trimestre>
        </asignatura>
        <asignatura id="a02" titulacion="c01">
            <nome>Inxeñería do Software</nome>
            <creditos_teoricos>6</creditos_teoricos>
            <creditos_practicos>1.5</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>
        <asignatura id="a03" titulacion="c02">
            <Nome>Administración de Empresas</Nome>
            <creditos_teoricos>4</creditos_teoricos>
            <creditos_practicos>1.5</creditos_practicos>
            <trimestre>1</trimestre>
        </asignatura>
        <asignatura id="a04" titulacion="c02">
            <nome>Dereito Internacional</nome>
            <creditos_teoricos>4</creditos_teoricos>
            <creditos_practicos>5</creditos_practicos>
            <trimestre>1</trimestre>
        </asignatura>
        <asignatura id="a05" titulacion="c04">
            <nome>Pedagoxía</nome>
            <creditos_teoricos>4</creditos_teoricos>
            <creditos_practicos>1.5</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>
        <asignatura id="a06" titulacion="c03">
            <Nome>Didáctica</Nome>
            <creditos_teoricos>4</creditos_teoricos>
            <creditos_practicos>3</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>
        <asignatura id="a07" titulacion="c04">
            <Nome>Tecnoloxía dlos Alimentos</Nome>
            <creditos_teoricos>1.5</creditos_teoricos>
            <creditos_practicos>7.5</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>
        <asignatura id="a08" titulacion="c01">
            <Nome>Bases de Datos</Nome>
            <creditos_teoricos>4.5</creditos_teoricos>
            <creditos_practicos>5.5</creditos_practicos>
            <trimestre>1</trimestre>
        </asignatura>
        <asignatura id="a09" titulacion="c06">
            <Nome>Historia do Pensamento</Nome>
            <creditos_teoricos>6</creditos_teoricos>
            <creditos_practicos>0</creditos_practicos>
            <trimestre>2</trimestre>
        </asignatura>
    </asignaturas>
     
    
    <<[ALUMNOS]>>


    <alumnos>
        <alumno id="e01">
            <apelido1>Rivas</apelido1>
            <apelido2>Santos</apelido2>
            <nome>Víctor Manuel</nome>
            <sexo>Home</sexo>
            <estudos>
                <carreira codigo="c01"/>
                <asignaturas>
                    <asignatura codigo="a01"/>
                    <asignatura codigo="a03"/>
                    <asignatura codigo="a05"/>
                    <asignatura codigo="a09"/>
                </asignaturas>
            </estudos>
        </alumno>
        <alumno id="e02">
            <apelido1>Pérez</apelido1>
            <apelido2>García</apelido2>
            <Nome>Luisa</Nome>
            <sexo>Muller</sexo>
            <estudos>
                <carreira codigo="c02"/>
                <asignaturas>
                    <asignatura codigo="a02"/>
                    <asignatura codigo="a01"/>
                </asignaturas>
                <proxecto>Web de IBM</proxecto>
            </estudos>
        </alumno>
        <alumno id="e03" beca="si">
            <apelido1>Pérez</apelido1>
            <apelido2>Romero</apelido2>
            <Nome>Fernando</Nome>
            <sexo>Home</sexo>
            <estudos>
                <carreira codigo="c02"/>
                <asignaturas>
                    <asignatura codigo="a02"/>
                    <asignatura codigo="a01"/>
                    <asignatura codigo="a04"/>
                    <asignatura codigo="a09"/>
                </asignaturas>
            </estudos>
        </alumno>
        <alumno id="e04">
            <apelido1>Avalón</apelido1>
            <apelido2>Jiménez</apelido2>
            <Nome>María</Nome>
            <sexo>Muller</sexo>
            <estudos>
                <carreira codigo="c01"/>
                <asignaturas>
                    <asignatura codigo="a02"/>
                    <asignatura codigo="a01"/>
                    <asignatura codigo="a07"/>
                </asignaturas>
                <proyecto>
                Estudio de Salinidade da Xunqueira do Lagares
                </proyecto>
            </estudos>
        </alumno>
    </alumnos>
</universidade>
```
</details>

### *Consultas XPath*

1. Nome da universidade.
XPath Query: /universidade/nome
2. País da universidade.
XPath Query: /universidade/pais
3. Nomes das carreiras
XPath Query: //carreira/nome
4. Anos do plan de estudo das carreiras
XPath Query: //carreira/plan
5. Nomes e apelidos de todos os alumnos
XPath Query: //alumno/nome
6. Identificadores de todas as carreiras
XPath Query: //carreira/@codigo
7. Datos de la carreira cuxo id é c01
XPath Query: //carreira [@id="c01"]
8. Centro no que se estudia a carreira cuxo id é c02
XPath Query: //carreira [@id="c02"]/centro
9. Nome das carreiras que teñan subdirector
XPath Query: //carreira/subdirector/../nome
10. Nome dos alumnos que estén facendo proxecto
XPath Query: //proxecto/../../nome
11. Códigos de las carreiras en las que hay algún alumno matriculado
XPath Query: //alumno/estudos/carreira/@codigo
12. Apelidos e nome dos alumnos con beca
//alumno[@beca="si"]/nome |  //alumno[@beca="si"]/apelido1 |  //alumno[@beca="si"]/apelido2
13. Nome das asignaturas da titulación c04
XPath Query: //asignatura[@titulacion="c04"]/nome
14. Nome das asignaturas do segundo trimestre

15. Nome das asignaturas que non teñen 4 créditos teóricos
16. Código da carreira que estudia o último alumno
17. Código das asignaturas que estudian mulleres
18. Nome dos alumnos matriculados na asignatura a02
19. Códigos das carreiras que estudian os alumnos matriculados nalguna asignatura.
20. Apelidos de todos os homes
21. Nome da carreira que estudia Víctor Manuel
22. Nome das asignaturas que estudia Luisa
23. Primeiro apelido dos alumnos matriculados en Enxeñería do Software
24. Nome das carreiras que estudian os alumnos matriculados na asignatura
Tecnoloxía dos Alimentos
25. Nome dos alumnos matriculados en carreiras que non teñen subdirector
26. Nome dos alumnos matriculados en asignaturas con 0 créditos prácticos e que
estudien a carreira de I.T. Informática
27. Nome dos alumnos que estudian carreiras cuxos plans son anteriores a 2002
28. Nome carreira que cursou o alumno cuxo código es e04.
