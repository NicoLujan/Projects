#!/bin/bash

find "$1" -name "*.java" | while read -r ARCHIVO

do

	echo File: "$ARCHIVO" tiene $(grep -c import* $ARCHIVO) clase/interfaz importada
	
	echo " "
	
done
