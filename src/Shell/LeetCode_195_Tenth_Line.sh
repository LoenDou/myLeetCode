nums=$(awk 'END{print NR}' file.txt)
if [ $nums -ge 10 ];
    then awk '{if(NR==10){print $0}}' file.txt
else
    echo ''
fi