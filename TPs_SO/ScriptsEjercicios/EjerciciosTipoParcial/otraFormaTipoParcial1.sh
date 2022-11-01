#!/bin/bash
#Esta mal, hace cualquier cosa

cantPalabrasTotales=$(wc -w < $1)

echo cantPalabrasTotales: $cantPalabrasTotales

resultado='Resultado'

for word in $(tr ' ' '\n' < $1 | sort | uniq)
do
	ocurrencias=$(tr ' ' '\n' < $1 | grep -wc $word)
done
echo "$word: 0$(echo "scale=2 ; $ocurrencias / $cantPalabrasTotales" | bc) "
