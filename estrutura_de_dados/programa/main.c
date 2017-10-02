#include <stdlib.h>
#include <stdlib.h>
#include <string.h>

#include "fila_INT.h"
#include "pilha_INT.h"

struct equipe_inscricao{
    char nome[25];
    int numero_componentes;

    struct equipe_inscricao *prox;
};
typedef struct equipe_inscricao *Equipe;

struct equipe_lancamento{
    char nome[25];
    int numero_componentes;
    float distancia_alvo;
    float altitude;

    struct equipe_lancamento *prox;
};
typedef struct equipe_lancamento *Lancamento;

int main(){

    Equipe fila_equipe;
    Lancamento fila_lancamento;

    do {




    } while (1);
}
