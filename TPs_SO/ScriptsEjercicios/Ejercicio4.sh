#!/bin/bash

for line in $(cat $1);
do
	if [[ $line == *.gz ]];
	then
		gunzip $line
	elif [[ $line == *.bz2 ]];
	then
		bunzip2 $line
	elif [[ $line == *.zip ]];
	then
		unzip $line
	elif [[ $line == *.tar ]];
	then
		tar $line
	else
		echo "El archivo: " $line " no esta comprimido"
	fi
done
