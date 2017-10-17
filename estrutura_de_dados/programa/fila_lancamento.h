struct competicao {
    char nome[30];
    int n_componentes;
    int tentativas;
    float distancia;
    float altura;
    struct competicao *prox;
};

typedef struct competicao* tipofila;

void INIT_fila (tipofila *inicio,tipofila *fim){
    *inicio=NULL;
    *fim=NULL;
}

void ENQUEUE(tipofila *inicio, tipofila *fim, tipofila elem){

    tipofila novo;

    novo=(tipofila) malloc (sizeof(struct competicao));
    if (novo==NULL)
        printf("Fila Cheia \n");
    else  {
        novo->altura = elem->altura;
        novo->distancia = elem->distancia;
        novo->n_componentes = elem->n_componentes;
        novo->tentativas = elem->tentativas;
        strcpy(&novo->nome, elem->nome);
        novo->prox=NULL;

	if (IsEmpty_fila(*inicio,*fim)){
	     *inicio = novo;
    }

	else{
        (*fim)->prox= novo;
    }
    *fim=novo;
	}
}

int IsEmpty_fila(tipofila ini, tipofila fim){
	if ( (ini == NULL) && (fim==NULL))
		return 1;
	else
		return 0;
}

int FIRST(tipofila inicio, tipofila fim,  tipofila *elem){
	if(!IsEmpty_fila(inicio,fim))	{

        strcpy((*elem)->nome, inicio->nome);
		(*elem)->n_componentes = inicio->n_componentes;
		(*elem)->altura = inicio->altura;
		(*elem)->distancia = inicio->distancia;
		(*elem)->tentativas = inicio->tentativas;

		return 1;
    }
	else
        return 0;
}

int DEQUEUE(tipofila *inicio, tipofila *fim,tipofila *elem){
	tipofila aux = *inicio;
	if(!IsEmpty_fila(*inicio,*fim))	{
		strcpy((*elem)->nome, (*inicio)->nome);
		(*elem)->n_componentes = (*inicio)->n_componentes;
		(*elem)->altura = (*inicio)->altura;
		(*elem)->distancia = (*inicio)->distancia;
		(*elem)->tentativas = (*inicio)->tentativas;
		(*inicio) = (*inicio)->prox;
		free (aux);

		if (*inicio == NULL)
			*fim = NULL;
		return 1;
    }
	else
		return 0;
}
