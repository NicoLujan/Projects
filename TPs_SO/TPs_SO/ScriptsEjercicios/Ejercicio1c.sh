#!/bin/bash

for line in $( cat $1 );do
	tail -1 $1 >> Aux1.txt
	sed '$d' $1 > Aux2.txt
	mv Aux2.txt $1	
done

mv Aux1.txt $1
