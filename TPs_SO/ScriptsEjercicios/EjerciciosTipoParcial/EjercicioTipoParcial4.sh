#!/bin/bash
OLDIF=$IFS
IFS='
'

if [ -n $2 ];
then
	cat $1 | grep "$2" | grep -v "00:[0-2].:.."
else
	for line in $(grep $2 $1);
	do
		time=$(echo $line | cut -d" " -f2 | tr -d ":")
		id=$(echo $line | cut -d" " -f3)
		if [[ 10#"003000" -lt 10#"$time" ]]
		then
			echo $line
		fi
	done
fi
IFS=$OLDIF
