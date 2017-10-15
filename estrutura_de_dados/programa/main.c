#include <stdlib.h>
#include <stdlib.h>
#include <string.h>

#include "pilha_INSCRICAO.h"

int main(){
    tipopilha topo,novo;

    topo = malloc(sizeof(tipopilha));
    novo = malloc(sizeof(tipopilha));

    int op = 1;

    INIT(&topo);
    PUSH(&topo,"UAT",1);
    printf("Nome da equipe: %s Qnt: %d\n",topo->nome, topo->n_componentes);

    PUSH(&topo,"UAT",2);
    printf("Nome da equipe: %s Qnt: %d\n",topo->nome, topo->n_componentes);

    PUSH(&topo,"UAT",3);
    printf("Nome da equipe: %s Qnt: %d\n",topo->nome, topo->n_componentes);

    PUSH(&topo,"UAT",4);
    printf("Nome da equipe: %s Qnt: %d\n",topo->nome, topo->n_componentes);

    PUSH(&topo,"UAT",5);
    printf("Nome da equipe: %s Qnt: %d\n",topo->nome, topo->n_componentes);

    PUSH(&topo,"UAT",6);
    printf("Nome da equipe: %s Qnt: %d\n",topo->nome, topo->n_componentes);


}
