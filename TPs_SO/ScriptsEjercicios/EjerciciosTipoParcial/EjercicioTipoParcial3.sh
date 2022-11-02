#!/bin/bash

PATH_EJEMPLO="CarpetaPruebas/PruebaEjercicioTipoParcial3"

# $1: Archivo pasado como parametro
# $2: Numero de impresora
# $3: Tipo de pagina
# Resultado cantidad paginas para imprimir el archivo
# 1:a2:24:80

cantLineasArchivo=$(cat $1 | wc -l)

filasImpresora=$(grep $2:$3 $PATH_EJEMPLO | cut -d":" -f3)
caractImpresora=$(grep $2:$3 $PATH_EJEMPLO | cut -d":" -f4)

for line in $(cat $1);
do
	aux=$(wc -m $line)
	
	if [ $aux -gt $caractImpresora ];
	then
		aux2=$aux/$caractImpresora
		let cantLineasArchivo = cantLineasArchivo+$aux2
	fi
done

echo "La cantidad de hojas que se necesitan son: " techo( $cantLineasArchivo/$caractImpresora )

