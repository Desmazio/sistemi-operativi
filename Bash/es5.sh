#!/bin/bash

if [ -z $1 ]
then
echo "Errore"
fi

tr a-z A-Z < $1
exit 0
