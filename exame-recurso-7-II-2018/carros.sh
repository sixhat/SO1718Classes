#!/bin/bash

cat carros.txt | while read line
do
	echo $line
	read -p 'Y or N (default N)' inp < /dev/tty
	if [[   $inp = 'y'  || $inp = 'Y' ]]; then
		echo $line >> selected.txt
	fi
done 

echo
echo "Your Selected Cars Are:"
cat selected.txt