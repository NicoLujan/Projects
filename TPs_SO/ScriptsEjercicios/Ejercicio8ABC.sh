#!/bin/bash

#Ejercicio A

DIR=$1
for ruta in $(find $1 -type d | tail -n +2)
do
   profundidad=$(echo $ruta | grep -o '/' | wc -l)        
   nombre_dir=$(basename $ruta)                           
   for i in $(seq $profundidad); do echo -n '    '; done  
   echo -n '*' $nombre_dir && echo ' '                             
done
#comments
DIR=$1
#Leo todas rutas skipeando la primera linea que es un '.')
do
   #cantidad de barras en la ruta --> profundidad
   #basename me da el nombre del directorio --> $(basename /a/b/c = c)
   #Agrego un TAB profundidad veces
   #Muestro el asterisco y el nombre del directorio
   #Salto de linea para pasar el siguiente dir
done

#Ejercicio B

#!/bin/bash
DIR=$1
for ruta in $(find $1 | tail -n +2)                
do
   profundidad=$(echo $ruta | grep -o '/' | wc -l)        
   nombre_dir=$(basename $ruta)                           
   for i in $(seq $profundidad); do echo -n '    '; done
   echo -n '*' $nombre_dir && echo ' '                                                                          
done

#Ejercicio C

#!/bin/bash
DIR=$1
for ruta in $(find $1 -maxdepth $2 | tail -n +2)                
do
   profundidad=$(echo $ruta | grep -o '/' | wc -l)        
   nombre_dir=$(basename $ruta)                           
   for i in $(seq $profundidad); do echo -n '    '; done
   echo -n '*' $nombre_dir && echo ' '                                                                          
done


