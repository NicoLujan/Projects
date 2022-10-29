#!/bin/bash

cat $1 | tr [0-9] $2 > aux.txt
mv aux.txt $1 
