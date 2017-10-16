
struct competicao {
    tipopilha equipe;
    float distancia;
    float altura;
    struct competicao *prox;
};

typedef struct competicao* tipofila;

void INIT (tipofila *inicio,tipofila *fim){
    *inicio=NULL;
    *fim=NULL;
}

void ENQUEUE(tipofila *inicio, tipofila *fim, tipofila elem){

    tipofila novo;

    novo=(tipofila) malloc (sizeof(struct competicao));
    if (novo==NULL)
        printf("Fila Cheia \n");
    else  {
        novo = elem;
        novo->prox=NULL;

	if (IsEmpty(*inicio,*fim)){
	     *inicio = novo;
    }

	else{
        (*fim)->prox= novo;
    }
    *fim=novo;
	}
}

int IsEmpty(tipofila ini, tipofila fim){
	if ( (ini == NULL) && (fim==NULL))
		return 1;
	else
		return 0;
}

int FIRST(tipofila inicio, tipofila fim,  tipofila *elem){
	if(!IsEmpty(inicio,fim))	{
		*elem = inicio;
		return 1;
    }
	else
        return 0;
}

int DEQUEUE(tipofila *inicio, tipofila *fim,tipofila *elem){
	tipofila aux = *inicio;
	if(!IsEmpty(*inicio,*fim))	{
		*elem = (*inicio);
		(*inicio) = (*inicio)->prox;
		free (aux);

		if (*inicio == NULL)
			*fim = NULL;
		return 1;
    }
	else
		return 0;
}
