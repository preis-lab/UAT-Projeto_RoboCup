#include <stdlib.h>
#include <stdlib.h>
#include <string.h>

#include "pilha_INSCRICAO.h"
//#include "fila_LANCAMENTO.h"

int main(){
    tipopilha topo,novo;
    //tipofila inicio, fim;
    int opcao;

    topo = malloc(sizeof(tipopilha));
    novo = malloc(sizeof(tipopilha));
    
    INIT(&topo);
    //INITfila(inicio,fim);

	do{
		printf("\t ============= Competicao de lancamento de foguetes ================\t\n\n");
		printf("Digite: \n1. Para cadastrar nova equipe \n2. Para cadastrar novo lancamento \n3. Para Encerrar o programa\n");
		scanf("%d", &opcao);
		printf("\n");
		if(opcao < 1 || opcao > 3) {
		printf("Opcao Incorreta!\n");
	}
		switch(opcao) {
			
			case 1: 
				printf("\t ===== Cadastro de nova equipe =====\n");
				printf("Digite o nome da equipe: \n");
				fflush(stdin);
				gets(novo->nome);
				printf("Digite a quantidade de integrantes da equipe: \n");
				scanf("%d", novo->n_componentes); 
				
				PUSH(&topo, novo->nome, novo->n_componentes);
				
			break;
			
			case 2:
				if (POP(&topo, &novo->nome)==1) {
				printf("Cadastrando novo lancamento da equipe %c :", novo->nome);
			}
			break;
			
			case 3:
				exit(0);
			break;
		}	
	}while (opcao != 3);
    
}
