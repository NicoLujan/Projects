#!/bin/bash

# El primer parametro debe ser un archivo .txt donde se encuentren los 
# archivos que queremos renombrar y el script se debe ejecutar en el mismo
# directorio donde se encuentran los archivos

OLDIFS=$IFS
IFS='
'

count=0

for line in $(cat $1);
do
	aux=$(echo $line | tr [A-Z] [a-z] | tr ' ' '_')
	
	if [ $line != $aux ];
	then
		let count++
		mv $line $aux
	fi
done

echo "Se han renombrado: " $count " archivos."

IFS=$OLDIFS