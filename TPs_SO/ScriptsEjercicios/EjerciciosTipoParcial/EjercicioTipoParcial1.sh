#!/bin/bash

FILE=$1

MAYOR_OCURRENCIA=-1;

for palabra in $(cat $1 | tr [A-Z] [a-z] | tr ' ' '\n' | sort | uniq);
do
	ocurrencia=$(grep -o -i $palabra $1 | wc -l)
	
	if [ $ocurrencia -ge $MAYOR_OCURRENCIA ];
	then
		MAYOR_OCURRENCIA=$ocurrencia
	fi 
	
	if [ $ocurrencia -eq 1 ] 
	then
		echo "La palabra: " $palabra " aparece " $ocurrencia " vez."
	else
		echo "La palabra: " $palabra " aparece " $ocurrencia " veces."
	fi
done

echo "La palabra con mayor ocurrencia es de: " $MAYOR_OCURRENCIA
