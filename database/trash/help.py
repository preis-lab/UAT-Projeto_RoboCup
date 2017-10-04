#coding: utf-8

lista = open('tipoLogradouro.txt','r')
linha = ''
i =0
while(i<47):
    linha = lista.readline()
    sql = "INSERT INTO logradouro('logradouro_id', 'tipo') VALUES (NULL,'"+linha+"');"
    print(sql)
    i+=1
