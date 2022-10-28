#!/bin/bash

cat $1 | tr [a-z] [A-Z] > aux.txt
mv aux.txt $1
