#!/bin/bash

for line in $(find /home -size +1k -type f);do
	echo "Presione 1 si desea eliminar o presione 2 si desea comprimir el archivo" $line
	read opcion
	
	if [ $opcion -eq 1 ];then
		echo $line $(ls -sort -t Prueba3 | cut -d" " -f8) >> LogEliminados.txt
	elif [ $opcion -eq 2 ];then
		gzip $line
	else
		echo "Por favor, ingrese una opcion valida."
	fi
	
done
