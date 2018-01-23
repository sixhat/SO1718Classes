#!/bin/sh

read -p "Introduza o nome: " nome
read -p "Introduza o email: " email
read -p "Introduza o telefone: " telefone
dia=`date +%D`

echo $nome $email $telefone $dia >> contactos.txt
echo 
echo Registo introduzido:
tail -1 contactos.txt
