#coding: utf-8

import os

lista = open('tipoLogradouro.txt','r')
linha = ''
i =0
while(i<45):
    linha = lista.readline()
    sql = "INSERT INTO ""\`logradouro\`(\`logradouro_id\`, \`tipo\`) VALUES (NULL,'"+linha+"');"
    os.system ("echo \""+sql+"\" >> carga.sql")
    i+=1
