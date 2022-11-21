#!/bin/bash
ERROR_CODE=1

echo "Inserire opzione:"
read op

if ! uname -$op 2>/dev/null
  then
  echo "Errore: Opzione inserita non valida!"
fi

exit 0
