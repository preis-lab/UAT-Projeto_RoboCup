#include <stdlib.h>
#include <string.h>

#include "pilha_INSCRICAO.h"
#include "fila_LANCAMENTO.h"

int main(){
    //define os tipos de dados
    tipopilha topo,novo;
    tipofila inicio, fim, auxFila;
    int opcao;

    //aloca memoria para pilha
    topo = malloc(sizeof(tipopilha));
    novo = malloc(sizeof(tipopilha));

    //aloca memoria para fila
    inicio = malloc(sizeof(tipofila));
    fim = malloc(sizeof(tipofila));

    //iniciar as duas estruturas com null
    INIT(&topo);
    INITfila(&inicio,&fim);


    //menu para selecao da funcao
    printf("\n ============= Competicao de lancamento de foguetes ================\t\n\n");

    printf("\nCadastro das equipes");

    //loop para cadastro de todas as equipes
    do {
        printf("\n ===== Cadastro de nova equipe =====\n");
        printf("Nome da equipe: ");
        gets(novo->nome);
        //scanf("%s",&novo->nome);
        printf("Quantidade de integrantes da equipe: ");
        scanf("%d", &novo->n_componentes);

        //adiciona na pilha a nova equipe
        PUSH(&topo, novo);

        printf("\n Equipe: %s com %d integrantes cadastrada!",topo->nome,topo->n_componentes);
        printf("\n\nDeseja cadastrar mais uma equipe? [0 - para cadastrar lancamentos]: ");
        scanf("%d",&opcao);
    } while (opcao != 0);


    do{
        topo->n_tentativas++;

        POP(&topo, &novo);

        printf("\n\n\nCadastrando novo lancamento da equipe %s integrantes %d:", novo->nome, novo->n_componentes);
        printf("\nA equipe conseguiu efeturar o lançamento?: [1/0]");
        scanf("%d",&opcao);

        if (opcao==1){
            printf("\nDistancia do alvo: ");
            scanf("%f,",&auxFila->distanciaDoAlvo);
            printf("Altitude: ");
            scanf("%f",&auxFila->altitude);

            auxFila->equipe = novo;

            ENQUEUE(&inicio,&fim,auxFila);


        } else {
            auxFila->distanciaDoAlvo = 9999;
            auxFila->altitude = 0;
        }
    } while(!Fila_IsEmpty(inicio,fim) && topo->n_tentativas < 2);
}



