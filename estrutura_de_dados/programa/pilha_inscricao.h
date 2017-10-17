struct equipe_inscricao {
    char nome[30];
    int n_componentes;
    struct equipe_inscricao *prox;
};

typedef struct equipe_inscricao* tipopilha;

void INIT (tipopilha *topo){
    *topo = NULL;
}

int IsEmpty(tipopilha topo){
    if (topo == NULL){
        return(1);
    } else {
        return(0);
    }
}


void PUSH (tipopilha *topo, tipopilha elem){
    tipopilha novo;
    novo = (tipopilha) malloc (sizeof(struct equipe_inscricao));

    if (novo != NULL){
        strcpy(&novo->nome, elem->nome);
        novo->n_componentes = elem->n_componentes;
        novo->prox=*topo;
        *topo = novo;
    } else {
        printf("Pilha cheia \n");
    }
}

int POP (tipopilha *topo,tipopilha *elem){
    tipopilha aux;
    aux = *topo;
    if (!IsEmpty(*topo)){
        strcpy((*elem)->nome,aux->nome);
        (*elem)->n_componentes = aux->n_componentes;
        *topo=aux->prox;
        free(aux);
        return(1);
    } else {
        printf("\nPilha vazia \n ");
        return(0);
    }
}

int TOP (tipopilha topo,tipopilha *elem) {
    if (!IsEmpty(topo))   {
        *elem = topo;
        return(1);
    } else {
        printf("pilha vazia \n ");
        return(0);
    }
}

