#include <stdlib.h>
#include <stdlib.h>
#include <string.h>

#include "pilha_INSCRICAO.h"
#include "fila_LANCAMENTO.h"

int main(){
    tipopilha topo,novo,auxPilha;
    tipofila inicio, fim, auxFila;

    int opcao;

    topo = malloc(sizeof(tipopilha));
    novo = malloc(sizeof(tipopilha));

    inicio = malloc(sizeof(tipofila));
    fim = malloc(sizeof(tipofila));

    INIT(&topo);
    INITfila(&inicio,&fim);

	do{
        //menu para selecao da funcao
		printf("\n ============= Competicao de lancamento de foguetes ================\t\n\n");
		printf("Digite: \n1. Para cadastrar nova equipe \n2. Para cadastrar novo lancamento \n3. Para Encerrar o programa\n");
		printf("Opcao: ");
		scanf("%d", &opcao);
		printf("\n");
		if(opcao < 1 || opcao > 3) {
		printf("Opcao Incorreta!\n");
	}

        //cadastro de uma nova equipe
		switch(opcao) {

			case 1:
				printf("\n ===== Cadastro de nova equipe =====\n");
				printf("Nome da equipe: ");
                scanf("%s",&novo->nome);
				printf("Quantidade de integrantes da equipe: ");
				scanf("%d", &novo->n_componentes);
                PUSH(&topo, novo->nome, novo->n_componentes);

                printf("\n Equipe: %s com %d integrantes cadastrada!",novo->nome,novo->n_componentes);
			break;

			case 2:
			    if(!IsEmpty(topo)){
                    printf("\nCadastrando novo lancamento da equipe %s :", topo->nome);
                    printf("\nDistancia do alvo: ");
                    scanf("%f,",&auxFila->distanciaDoAlvo);
                    printf("Altitude: ");
                    scanf("%f",&auxFila->altitude);

                    ENQUEUE(&inicio,&fim,topo->nome,topo->n_componentes,auxFila->distanciaDoAlvo,auxFila->altitude);
                    POP(&topo, &auxPilha);
			    } else {
                    printf("Pilha Vazia!");
			    }

			break;

			case 3:
				exit(0);
			break;
		}
	}while (opcao != 3);

}
