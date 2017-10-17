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
    tipopilha new;
    new = (tipopilha) malloc (sizeof(struct equipe_inscricao));

    if (new != NULL){
        new = elem;
        new->prox=*topo;
        *topo = new;
    } else {
        printf("Pilha cheia \n");
    }
}

int POP (tipopilha *topo,tipopilha *elem){
    tipopilha aux;
    aux = *topo;
    *elem = NULL;
    if (!IsEmpty(*topo)){
        *elem = topo;
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

