---
layout: post
title:  "Proyecto #1 - Bmp Image Handler"
date:   
category: Proyecto
description: >
    ATENCION: Este proyecto consume tiempo, asi que empiece lo mas temprano que pueda. Esta es una asignacion individual, usted no puede compartir codigo con ningun otro grupo ni estudiante.
---

### Especificaciones Generales

El proyecto Bmp Image Handler trata de que usted aplique los conceptos aprendidos en clase de listas encadenadas y arreglos (bidimensionales) en el manejo de imagenes. Usted estara trabajando con imagenes originales con formato BMP en 32 bits, para despues pasarlas a un formato comprimido utilizando un algoritmo llamado Run Length Encoding.

### Parte I: Rojo - Verde - Azul

En la primera parte del proyecto, usted entendera como estan formados los colores en cada pixel. Su objetivo es separar su imagen original en sus tres tonos, rojo, verde y azul.

Imagen:
Usted va a trabajar inicialmente con una imagen en formato BMP no comprimida. Las imagenes estan divididas en pixels, en cada uno de los cuales se guarda un color especifico dependiendo de su posicion en la imagen. Este color, se forma por tonalidades de rojo, verde y azul. La tonalidad (cantidad de color) es un numero del 0 al 255. Por ejemplo si un pixel fuera a guardar el rojo puro, este se codificaria como R=255 - V=0 - A=0, que significa que el color se representa por 255 de rojo, 0 de verde y 0 de azul.

Supongamos los siguientes pixeles, cada uno tiene un color, y al lado mostramos las intensidades de rojo, verde y azul que se utilizan para poder formar ese color especifico :


```
IMAGEN NO DISPONIBLE
```

Su primera tarea, es leer del formato bmp de la imagen, la matriz de pixels, guardando los datos de tal forma que separe la matriz de rojo, verde y azul. Tome en cuenta que el tamao de dicha matriz ser el numero de pixels en la imagen, y por lo tanto debe leer el tamaño de la imagen en el header. Para esta parte, debe utilizar lo anterior para generar las siguientes imagenes:

    (1) Tres imagenes sacadas de la imagen original, una que contenga solo las tonalidades de rojo, otra las tonalidades de verde, y otra las tonalidades de azul.

    Por ejemplo tenemos la siguiente imagen:

<img style="padding-top:30px;" src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/img/original.jpg" alt="original">

Usted deberia generar las siguientes imagenes:

<table style="text-align: center;">
  <tr>
    <th>Rojo</th>
    <th>Verde</th>
    <th>Azul</th>
  </tr>
    <tr>
    <th rowspan="5"><img style="padding-top:30px;" src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/img/red.jpg" alt="rojo"></th>
  </tr>
    <tr>
    <th rowspan="5"><img style="padding-top:30px;" src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/img/green.jpg" alt="verde"></th>
  </tr>
    <tr>
    <th rowspan="5"><img style="padding-top:30px;"src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/img/blue.jpg"  alt="azul"></th>
  </tr>
</table>

(2) Una imagen en tonalidad sepia, resultante de la imagen original. La cual se veria algo parecido a esto:

<img style="padding-top:30px;" src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/img/sepia.jpg" alt="sepia">

Entonces, para esta parte usted tiene que leer una imagen BMP y generar solamente 4 imagenes a partir de esa. Si el nombre del archivo de la imagen fuera Image.bmp, las imagenes para esta fase deben tener los siguientes nombres respectivamente:

    (1) ImageRed.bmp,ImageGreen.bmp,ImageBlue.bmp
    (2) ImageSepia.bmp

### Parte II - Modificar Imagen

Para la segunda parte del proyecto, tiene que generar las siguientes imagenes a partir de la imagen original.

  . (1) Imagen al revez de la original, rotando la imagen 180 grados sobre la linea horizontal de en medio. (ImageHRotation.bmp)

  <img style="padding-top:30px;" src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/img/HRotation.jpg" alt="HRotation">

  . 2) Al reves de la imagen original, pero rotando 180 grados en el eje vertical (ImageVRotation.bmp)

   <img style="padding-top:30px;" src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/img/VRotation.jpg" alt="sepia">


  (3) Minimizar la imagen o "aplastarla" en un 50% de su ancho , y minimizar la imagen o "aplastarla" en 50% de su alto (ImageThin.bmp, ImageFlat.bmp)


<table style="text-align: center;">
  <tr>
    <th>Thin</th>
    <th>Flat</th>
  </tr>
    <tr>
    <th rowspan="5"><img style="padding-top:30px;" src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/pj1/img/Thin.jpg" alt="thin"></th>
  </tr>
    <tr>
    <th rowspan="5"><img style="padding-top:30px;" src="https://github.com/santoslopez/cc-2/tree/santoslopez/2016/an/pj-1/img/Flat.jpg" alt="flat"></th>
  </tr>
</table>

### Parte III - Escala de grises

Para la tercera parte del proyecto, debe pasar la imagen a escala de grises. Para esta parte necesita las matrices que saco para la primera parte.

Para sacar el valor de un pixel en escala de grises, debe hacer una ponderacion entre las 3 tonalidades (rojo, verde y azul). Le dejamos de tarea investigar que ponderacion es la que debe utilizar para que la imagen en grises le salga como es (No es el promedio, no lo puede hacer asi). Recuerde que las tonalidades van desde 0-255, esto quiere decir, que al operarlos, la tonalidad de gris quedar en este rango y ser entera.

El numero que obtenga de la operacion representara que tan gris es el pixel. Si tenemos una escala en grises de 0 a 255, tomaremos el 0 como negro (puro), y el 255 como blanco (puro).

Por ejemplo, tendriamos la imagen anterior en grayscale: 	

```
IMAGEN NO DISPONIBLE
```

Despues de sacar la matriz correspondiente con tonalidades de grises, debe pasar eso a un archivo BMP para que se pueda ver la imagen en gray-scale. El formato BMP para grayscale cambia un poco(debe de investigar esto) y su imagen ya no tiene que estar escrita en formato de 24 bits, sino que la tiene que escribir en formato de 8 bits.

Para esta parte, su programa solo debe general la imagen en grayscale. El archivo que debe generarse en esta parte debe llamarse ImageGrayscale.bmp si Image.bmp fuera el nombre de la imagen recibida.

###  Parte IV: Run Length Encoding - Grayscale

La ultima parte de el proyecto, trata de comprimir la imagen en grayscale generada en la Parte III para que su tamao en bytes sea menor.

Run Length Encoding:
El algoritmo que tiene que utilizar para comprimir su imagen es el Run Length Encoding. Este algoritmo es utilizado en formatos como .GIF para poder comprimir un poco la imagen, y que el archivo no ocupe tanta memoria. Run Length Encoding aplicado a una imagen trata de unir las casillas consecutivas que tienen el mismo color, en una sola a la que le llamaremos corrida o run. Una corrida esta compuesta por dos datos, el numero de casillas consecutivas con el mismo color, y el color que guardan esas casillas. Por ejemplo:

Si tenemos la siguiente cadena de "pixels":

```
IMAGEN NO DISPONIBLE
```

En Run Length Encoding quedaria asi:

```
IMAGEN NO DISPONIBLE
```

El Run Length Encoding que debe hacer ud es sobre una imagen blanco y negro generada en la primera parte. Entonces, si la matriz quedara en una linea de pixels, por ejemplo esta:

```
IMAGEN NO DISPONIBLE
```

En Run Length Encoding quedaria asi:

```
IMAGEN NO DISPONIBLE
```

Entonces, para esta parte lo que usted va a hacer es comprimir la imagen en grayscale y la va a escribir en formato BMP pero con compresion RLE de 8 bits. Lea detenidamente el formato BMP para ver que debe de cambiar en el header para esto. Lo importante es que la imagen original en grayscale, debe ocupar mas "memoria" que la imagen .bmp utilizando compresion RLE, pero tienen que verse igual. Es obligatorio que en su aplicacion del algoritmo RLE utiliza lista encadenadas, especificamente la clase LinkedList de Java (no otra), si no lo hace, esta parte no le valdra para su nota.
Para esta parte entonces recibira una imagen original en colores, generara la imagen en grayscale a partir de esa (es decir ejecutara la parte III) y despues generara la imagen grayscale con compresion RLE a partir de la imagen grayscale generada. El archivo .bmp generado debe llamarse ImageRLE.bmp, si Image.bmp fuera el nombre del archivo original.

### Parte V - Kernel

Para la quinta parte del proyecto, debe pasar un kernel a la imagen, esto es un arreglo que le debe aplicar a cada pixel de la imagen. Para la tercera parte del proyecto, debe pasar la imagen a escala de grises. Para esta parte necesita las matrices que saco para la primera parte.

Un kernel es una matriz de numeros cuyos elementos dictan como se operara cada pixel, dicha matriz se aplica a cada pixel de la imagen. Esto se hace situando cada pixel en el elemento central de la matriz y los demas elementos se operan con los pixeles adyacentes.

Por ejemplo, al tener el siguiente kernel y la siguiente imagen:

```
AQUI VA SU IMAGEN
```

 Para mas informacion y ejemplos de como se implementa un kernel, puede visitar la pagina image-kernels, el kernel estara en un archivo txt el cual contentra 1 kernel en el cual los numeros estaran separados por espacios y las filas por nuevas lineas. Todos los numeros seran tipo float.
Por ejemplo asi vendra el archivo
```
0.1 -1 0.1
-1 5 -1
0.1 -1 0.1
```

### Estructura del Proyecto

Su proyecto debe estar dividido en las siguientes clases:
```
    Clase BMPCore, la cual se encargue de generar las imagenes especificadas en la parte I del proyecto.
    Clase BMPRotations, la cual se encargue de generar las imagenes especificadas en la parte II del proyecto, que tengan que ver con rotaciones.
    Clase BMPResize, la cual se encargue de generar las imagenes especificadas en la parte II del proyecto, que tengan que ver con cambiar la imagen en ancho y alto
    Clase BMPGrayscale, la cual se encargue de generar la imagen especificada para la parte III del proyecto.
    Clase BMPRunLengthEncoding, la cual se encargue de generar la imagen especificada para la parte IV del proyecto.
    Clase BMPRunKernerFilter, la cual se encargue de generar la imagen especificada para la parte V del proyecto.
    Clase principal llamada BMPImageHandler, la cual unicamente se debe encargar de mandar a llamar a las clases anteriores para ejecutar las clases que se les especifiquen.
```

### Forma de ejecutarlo

Como se habia dicho antes, la clase principal con la que se ejecutara su proyecto debe llamarse BMPImageHandler.
El programa debe ejecutarse como BMPImageHandler seguido de, generalmente, una bandera y el nombre del archivo. La bandera
indicara que parte del proyecto se va a ejecutar. Si la bandera es -basics su programa solo debe ejecutar la Parte I de este proyecto.

    		java BMPImageHandler -core imagen.bmp         

    Si la bandera es -rotate su programa debe ejecutar las rotaciones (no aclarar, oscurecer, agrandar y apalastar) de la Parte II de este proyecto.

    		java BMPImageHandler -rotate imagen.bmp

    Si la bandera es -resize su programa debe crear las imagenes thin y flat de la Parte II de este proyecto.

    		java BMPImageHandler -resize imagen.bmp

    Si la bandera es -grayscale su programa debe ejecutar la Parte III de este proyecto.

    		java BMPImageHandler -grayscale imagen.bmp

    Si la bandera es -rle su programa debe ejecutar la Parte IV de este proyecto.

    		java BMPImageHandler -rle imagen.bmp

    Si la bandera es -kernel su programa debe ejecutar la Parte V de este proyecto.

    		java BMPImageHandler -kernel kernel.txt imagen.bmp

    Si la bandera es -all su programa debe ejecutar todas las partes de este proyecto.

    		java BMPImageHandler -all kernel.txt imagen.bmp

    Si la bandera es -help, usted debe listar las opciones de como se debe ejecutar el BmpImageHandler

    		java BMPImagehandler -help

Si usted no cumple con estos modos de ejecucion, tendra CERO en su proyecto.

Al mandar a ejecutar el programa, se deben generar las imagenes y ser guardadas en el mismo directorio en que se ejecuto (No en directorios adicionales). Su programa debe mostrar en un Frame, la imagen que se utilizo para ejecutar el programa, y debe dar opcion, mediante botones, de "cargar" cualquiera de las imagenes generadas en la ultima ejecucion. Para esto debe utilizar JFrames. Cada vez que se precione un boton, la imagen asociada (generada al ejecutar el programa).

### Observaciones:

Para realizar su proyecto debe tomar en cuenta lo siguiente y cumplir con las siguientes restricciones:

Trabajaremos SOLO con imagenes de 640X480 en formato de 24 bits (esto significa que por cada pixel tienen 3 bytes)
Puede utilizar la clase Scanner y el metodo nextFloat para cargar el archivo kernel
Las unicas estructuras de datos que puede utilizar son: Arreglos, ArrayList y LinkedList .
Su algoritmo de compresion RLE debe ser trabajado con listas encadenadas, especificamente LinkedList de Java.
La parte grafica de su proyecto es un 25% de su nota, sin embargo, lo mas importante es generar las imagenes.
Recuerdese que el formato va al reves, es decir que BMP empieza a contar desde el pixel inferior izquierdo.
La informacion de las imagenes BMP en escala de grises comienzan en el byte 1078, no en el 54 como en las de color. Investigue porque es, porque le servira para la parte III.
Recuerde que en el formato BMP tiene dos bytes reservados (con valor cero) al final.

### IMPORTANTE:
NO PUEDE UTILIZAR CLASES EN JAVA (NI OTROS PROGRAMAS/LIBRERIAS YA HECHAS) QUE HAGAN ESTE TRABAJO POR USTED. NO PUEDE UTILIZAR CLASES EN JAVA QUE MANEJEN IMAGENES (lean atributos o modifiquen). Como por ejemplo la libreria: java.awt.Image (que incluye clases como BufferedImage), javax.imageIO, o la clase imageIO. Si hace esto, se le pondra cero en el proyecto. La lectura, manipulacion y generacion de la imagen debe estar programada por usted. En lo unico que puede utilizar algo como esto, es en la parte de JFrames cuando ya generada la imagen, solo la quiera desplegar el Frame. Si tiene alguna duda, mejor pregunte.
