#!/bin/bash

# $1: Parametro del numero de fibonacci a calcular

PATH_HOME=home

fibant=0
fibact=1

#Esta mal porque el script debe usar los valores presentes
# en el archivo para recalcular el fibbonacci
# esto se hace con un cut y tail sobre el archivo

for (( i=0 ; i<$1 ; i++ ));
do
	echo "$((i+1))."$fibant >> $PATH_HOME/Computed
	fn=$(( fibant + fibact ))
	fibant=$fibact
	fibact=$fn
done
