#!/bin/bash

# $1 almacena el directorio de un codigo fuente de java
# Por cada archivo cuenta cuantas clases e interfaces hay

contInterface=0
contClass=0

for line in $( find $1/src -name *.java );
do
	auxI=$(grep -l interface $line)
	auxC=$(grep -l class $line)
	
	if [ -n "$auxI" ];
	then
		let contInterface++
	fi
	
	if [ -n "$auxC" ];
	then
		let contClass++
	fi
done

echo "Cantidad de clases: " $contClass
echo "Cantidad de interfaces: " $contInterface
