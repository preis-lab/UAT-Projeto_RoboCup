#coding: utf-8

import os

lista = open('bairrosSP.txt','r')
linha = ''
i =0
while(i<1734):
    linha = lista.readline()
    sql = "INSERT INTO bairro(\`bairro_id\`, \`nome\`,\`cidade_cidade_id\`) VALUES (NULL,\'"+linha+"\',565);"
    os.system ("echo \""+sql+"\" >> carga.sql")
    i+=1
