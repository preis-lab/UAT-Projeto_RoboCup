#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "pilha_inscricao.h"
#include "fila_lancamento.h"

/*
    PAULO HENRIQUE P. REIS RM 76729
    VITOR HUGO             RM 76287
    JEAN REIS              RM 75681
    DANIEL PRATES          RM 77316
*/
int main() {
    //define variaveis para pilha
    tipopilha topo, novo;

    //define variaveis para fila
    tipofila inicio, fim, aux, campea;

    //aloca memoria para pilha
    novo = (tipopilha) malloc(sizeof(struct equipe_inscricao));
    topo = (tipopilha) malloc(sizeof(struct equipe_inscricao));

    //aloca memoria para fila
    inicio = (tipofila) malloc(sizeof(struct competicao));
    fim = (tipofila) malloc(sizeof(struct competicao));
    aux = (tipofila) malloc(sizeof(struct competicao));
    campea = (tipofila) malloc(sizeof(struct competicao));

    //incia pilha com null
    INIT(&topo);

    //inicia fila com null
    INIT_fila(&inicio, &fim);

    int opcao=0,continua=1;
    float auxDistancia;

    printf("\n ============= Competicao de lancamento de foguetes ================\t\n\n");
    //loop para cadastro das equipes
    do {
        printf("\n ===== Cadastro de nova equipe =====\n");
        printf("Nome da equipe: ");

        scanf("%s",&novo->nome);
        printf("Quantidade de integrantes da equipe: ");
        scanf("%d", &novo->n_componentes);

        //adiciona na pilha a nova equipe
        PUSH(&topo, novo);

        printf("\n Equipe: %s com %d integrantes cadastrada!",topo->nome,topo->n_componentes);
        printf("\n\nDeseja cadastrar mais uma equipe? [1/0]: ");
        scanf("%d",&opcao);
    } while (opcao == 1);

    //Esvazia a pilha
    while(!IsEmpty(topo)){

        printf("\n ============= Lançamento da equipe %s ================\n\n",topo->nome);

        POP(&topo, &novo);

        //copia os dados da equipe para o lancamento e adiciona 1 na quantidade de tentativas
        strcpy(aux->nome, novo->nome);
        aux->n_componentes = novo->n_componentes;
        aux->tentativas=1;
        //verifica se o lancamento foi efetuado
        printf("\nA equipe realizou o lancamento?: [1/0]");
        scanf("%d",&opcao);

        //se sim, coleta os dados
        if(opcao == 1){
            printf("\nDistancia do alvo: ");
            scanf("%f",&aux->distancia);

            printf("Altura: ");
            scanf("%f",&aux->altura);

        } else {
            aux->distancia = 9999;
            aux->altura = 0;
        }

        ENQUEUE(&inicio,&fim,aux);
    }

    //recebe o topo para iniciar o loop
    FIRST(inicio,fim,&aux);

    //realiza a segunda tentativa das equipes
    while(continua){
        FIRST(inicio,fim,&aux);

        //se a equipe ja realizou 2 lancamentos para o fluxo
        if(aux->tentativas>=2){
            continua = 1;
            break;
        }

        DEQUEUE(&inicio,&fim,&aux);
        aux->tentativas++;
        printf("\n ============= 2º Lançamento da equipe %s ================\n\n", aux->nome);

        printf("\nA equipe realizou o lancamento?: [1/0]");
        scanf("%d",&opcao);

        //se sim, coleta os dados
        if(opcao == 1){
            opcao=0;
            printf("\nNova distancia do alvo: ");
            scanf("%f",&auxDistancia);

            //se a nova distancia for menor, registrar
            if(auxDistancia < aux->distancia){
                aux->distancia = auxDistancia;

                printf("Altura: ");
                scanf("%f",&aux->altura);
            } else {
                printf("\nA distancia anterior era menor");
            }
        }
        //coloca de volta o lancamento na fila
        ENQUEUE(&inicio, &fim, aux);
    }

    //GERA O RANKING
    while(strcmp(campea->nome,aux->nome)!=0){
        DEQUEUE(&inicio,&fim,&aux);

        if(aux->distancia == campea->distancia){
            if(aux->altura > campea->altura){
                strcpy(&campea->nome,aux->nome);
                campea->distancia = aux->distancia;
                campea->altura = aux->altura;
                campea->n_componentes = campea->n_componentes;
            }
        } else if (aux->distancia > campea->distancia){
            strcpy(&campea->nome,aux->nome);
            campea->distancia = aux->distancia;
            campea->altura = aux->altura;
            campea->n_componentes = campea->n_componentes;
        }
        ENQUEUE(&inicio,&fim,aux);
    }

    //exibe todas as equipes e esvazia a fila
    while(!IsEmpty_fila(inicio,fim)){
        DEQUEUE(&inicio,&fim,&aux);

        printf("\n|=====================");
        printf("\n|Nome da equipe: %s",aux->nome);
        printf("\n|Nº componentes: %d",aux->n_componentes);
        printf("\n|Nº tentativas: %d",aux->tentativas);
        printf("\n|Altura: %f",aux->altura);
        printf("\n|Distancia: %f", aux->distancia);
        printf("\n|=====================");
    }

    printf("\n\nCAMPEA: %s com a distancia de: %d",campea->nome, campea->distancia);
    printf("\n\n\n ============= FIM DO PROGRAMA :D ================\n\n");

}
