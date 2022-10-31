#!/bin/bash

# El primer parametro debe ser un archivo .txt donde se encuentren los 
# archivos que queremos renombrar y el script se debe ejecutar en el mismo
# directorio donde se encuentran los archivos

IFS='
'

count=0

for line in $(cat $1);
do
	aux=$(echo $line | tr [A-Z] [a-z] | tr ' ' _)
	
	if [[ $line != $aux ]];
	then
		let count=count+1
		mv $line $aux
	fi
	
	echo "Se han renombrado: " $count " archivos."
done
