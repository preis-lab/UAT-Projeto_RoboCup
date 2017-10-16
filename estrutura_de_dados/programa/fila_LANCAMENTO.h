/* declaracao do no */
struct lancamento {
		char nome[30];
       	int n_componentes;
       	float distanciaDoAlvo;
       	float altitude;
       	struct lancamento *prox;
};
/*Definição do tipo de dado fila */
typedef struct lancamento* tipofila;

/*Inicia a fila */
void INITfila (tipofila *inicio,tipofila *fim)
{
*inicio=NULL;
*fim=NULL;
}

/*Insere o elemento no final da fila */
void ENQUEUE(tipofila *inicio, tipofila *fim, char nome[30],int n_componentes, float distanciaDoAlvo, float altitude)
{

tipofila novo;
novo=(tipofila) malloc (sizeof(struct lancamento));
if (novo==NULL)
   printf("Fila Cheia \n");
else  {
	 strcpy(novo->nome,nome);
	 novo->n_componentes=n_componentes;
	 novo->distanciaDoAlvo=distanciaDoAlvo;
	 novo->altitude=altitude;
	 novo->prox=NULL;

	if (Fila_IsEmpty(*inicio,*fim)==1){
	     *inicio = novo;
	     }
	else{
	     (*fim)->prox= novo;
	}
    *fim=novo;
	}
}

/*Verifica se a fila está vazia */

int Fila_IsEmpty(tipofila ini, tipofila fim)
{
	if ((ini == NULL) && (fim==NULL)){
		return 1;
	}
	else{
        return 0;
	}
}

/*Lê o elemento que está no inicio da fila e armazena na variável v */
int FIRST(tipofila inicio, tipofila fim, char *elem)
{
	if(!Fila_IsEmpty(inicio,fim))	{
        strcpy(&*elem,inicio->nome);
		*elem = inicio->n_componentes;
		*elem = inicio->distanciaDoAlvo;
		*elem = inicio->altitude;
		return 1;
		}
	else
		return 0;
}

/*Remove o elemento do inicio da fila */
int DEQUEUE(tipofila *inicio, tipofila *fim, char *elem)
{
	tipofila aux = *inicio;
	if(!Fila_IsEmpty(inicio,fim))	{
		*elem = (*inicio)->nome;
		*elem = (*inicio)->n_componentes;
		*elem = (*inicio)->distanciaDoAlvo;
		*elem = (*inicio)->altitude;
		(*inicio) = (*inicio)->prox;
		free (aux);
		if (*inicio == NULL)
			*fim = NULL;
		return 1;
		}
	else
		return 0;
}
