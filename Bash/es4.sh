#!/bin/bash

n=$#

if [ $n -gt 2 ]
then
echo "Errore, ci sono piu parametri"
exit 65
fi

if [ -z $2 ]
then
echo "Inserisci esattamente due parametri"
exit 65
fi

((sum=$1+$2))
echo $sum

if [ $sum -gt 10 ]
then
echo "Grande"
else
echo "Piccolo"
fi
