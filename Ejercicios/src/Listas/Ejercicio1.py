'''
Created on 27 dic. 2020

@author: JuanManuel
'''
"""
Ejercicios de listas
Ejercicio 1
Realizar un programa que inicialice una lista con 10 valores aleatorios (del 1 al 10) y posteriormente muestre en pantalla cada elemento de la lista junto con su cuadrado y su cubo.

Ejercicio 2
Crea una lista e inicializala con 5 cadenas de caracteres le�das por teclado. Copia los elementos de la lista en otra lista pero en orden inverso, y muestra sus elementos por la pantalla.

Ejercicio 3
Se quiere realizar un programa que lea por teclado las 5 notas obtenidas por un alumno (comprendidas entre 0 y 10). A continuaci�n debe mostrar todas las notas, la nota media, la nota m�s alta que ha sacado y la menor.

Ejercicio 4
Programa que declare una lista y la vaya llenando de n�meros hasta que introduzcamos un n�mero negativo. Entonces se debe imprimir el vector (s�lo los elementos introducidos).

Ejercicio 5
Hacer un programa que inicialice una lista de n�meros con valores aleatorios (10 valores), y posterior ordene los elementos de menor a mayor.

Ejercicio 6
Crea un programa que pida un n�mero al usuario un n�mero de mes (por ejemplo, el 4) y diga cu�ntos d�as tiene (por ejemplo, 30) y el nombre del mes. Debes usar listas. Para simplificarlo vamos a suponer que febrero tiene 28 d�as.

Ejercicio 7
Programa que declare tres listas �lista1�, �lista2� y �lista3� de cinco enteros cada uno, pida valores para �lista1� y �lista2� y calcule lista3=lista1+lista2.

Ejercicio 8
Queremos guardar los nombres y la edades de los alumnos de un curso. Realiza un programa que introduzca el nombre y la edad de cada alumno. El proceso de lectura de datos terminar� cuando se introduzca como nombre un asterisco (*) Al finalizar se mostrar� los siguientes datos:

Todos lo alumnos mayores de edad.
Los alumnos mayores (los que tienen m�s edad)
Ejercicio 9
Queremos guardar la temperatura m�nima y m�xima de 5 d�as. Realiza un programa que de la siguiente informaci�n:

La temperatura media de cada d�a
Los d�as con menos temperatura
Se lee una temperatura por teclado y se muestran los d�as cuya temperatura m�xima coincide con ella. si no existe ning�n d�a se muestra un mensaje de informaci�n.
Ejercicio 10
Dise�ar el algoritmo correspondiente a un programa, que:

Crea una tabla (lista con dos dimensiones) de 5x5 enteros.
Carga la tabla con valores num�ricos enteros.
Suma todos los elementos de cada fila y todos los elementos de cada columna visualizando los resultados en pantalla.
Ejercicio 11
Dise�ar el algoritmo correspondiente a un programa, que:

Crea una tabla bidimensional de longitud 5x5 y nombre �diagonal�.
Carga la tabla de forma que los componentes pertenecientes a la diagonal de la matriz tomen el valor 1 y el resto el valor 0.
Muestra el contenido de la tabla en pantalla.
Ejercicio 12
Dise�ar el algoritmo correspondiente a un programa, que:

Crea una tabla bidimensional de longitud 5x15 y nombre �marco�.
Carga la tabla con dos �nicos valores 0 y 1, donde el valor uno ocupar� las posiciones o elementos que delimitan la tabla, es decir, las m�s externas, mientras que el resto de los elementos contendr�n el valor 0.

  111111111111111
  100000000000001
  100000000000001
  100000000000001
  111111111111111
Visualiza el contenido de la matriz en pantalla.

Ejercicio 13
De una empresa de transporte se quiere guardar el nombre de los conductores que tiene, y los kil�metros que conducen cada d�a de la semana.

Para guardar esta informaci�n se van a utilizar dos arreglos:

Nombre: Lista para guardar los nombres de los conductores.
kms: Tabla para guardar los kil�metros que realizan cada d�a de la semana.
Se quiere generar una nueva lista (�total_kms�) con los kil�metros totales que realza cada conductor.

Al finalizar se muestra la lista con los nombres de conductores y los kil�metros que ha realizado.

Ejercicio 14
Crear un programa que lea los precios de 5 art�culos y las cantidades vendidas por una empresa en sus 4 sucursales. Informar:

Las cantidades totales de cada articulo.
La cantidad de art�culos en la sucursal 2.
La cantidad del articulo 3 en la sucursal 1.
La recaudaci�n total de cada sucursal.
La recaudaci�n total de la empresa.
La sucursal de mayor recaudaci�n.
Ejercicio 15
Crear un programa de ordenador para gestionar los resultados de la quiniela de f�tbol. Para ello vamos a utilizar dos tablas:

Equipos: Que es una tabla de cadenas donde guardamos en cada columna el nombre de los equipos de cada partido. En la quiniela se indican 15 partidos.
Resultados: Es una tabla de enteros donde se indica el resultado. Tambi�n tiene dos columnas, en la primera se guarda el n�mero de goles del equipo que est� guardado en la primera columna
de la tabla anterior, y en la segunda los goles del otro equipo.
El programa ira pidiendo los nombres de los equipos de cada partido y el resultado del partido, a continuaci�n se imprimir� la quiniela de esa jornada.

�Qu� modificaci�n habr�a que hacer en las tablas para guardar todos los resultados de todas las jornadas de la temporada?

Ejercicio 16
Vamos a crear un programa que tenga el siguiente men�:

A�adir n�mero a la lista: Me pide un n�mero de la lista y lo a�ade al final de la lista.
A�adir n�mero de la lista en una posici�n: Me pide un n�mero y una posici�n, y si la posici�n existe en la lista lo a�ade a ella (la posici�n se pide a partir de 1).
Longitud de la lista: te muestra el n�mero de elementos de la lista.
Eliminar el �ltimo n�mero: Muestra el �ltimo n�mero de la lista y lo borra.
Eliminar un n�mero: Pide una posici�n, y si la posici�n existe en la lista lo borra de ella (la posici�n se pide a partir de 1).
Contar n�meros: Te pide un n�mero y te dice cuantas apariciones hay en la lista.
Posiciones de un n�mero: Te pide un n�mero y te dice en que posiciones est� (contando desde 1).
Mostrar n�meros: Muestra los n�meros de la lista
Salir
Ejercicio 17
Crear un programa que a�ada n�meros a una lista hasta que introducimos un n�mero negativo. A continuaci�n debe crear una nueva lista igual que la anterior pero eliminando los n�meros duplicados. Muestra esta segunda lista para comprobar que hemos eliminados los duplicados.

Ejercicio 18
Escriba un programa que permita crear una lista de palabras y que, a continuaci�n de tres opciones:

Contar: Me pide una cadena, y me dice cuantas veces aparece en la lista
Modificar: Me pide una cadena, y otra cadena a modificar, y modifica todas alas apariciones de la primera por la segunda en la lista.
Eliminar: Me pide una cadena, y la elimina de la lista.
Mostrar: Muestra la lista de cadenas
Terminar
"""
