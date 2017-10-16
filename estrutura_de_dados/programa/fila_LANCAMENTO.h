/* declaracao do no */
struct competicao {
        tipopilha equipe;
       	float distanciaDoAlvo;
       	float altitude;
       	struct competicao *prox;
};
/*Definição do tipo de dado fila */
typedef struct competicao* tipofila;

/*Inicia a fila */
void INITfila (tipofila *inicio,tipofila *fim)
{
*inicio=NULL;
*fim=NULL;
}

/*Insere o elemento no final da fila */
void ENQUEUE(tipofila *inicio, tipofila *fim, tipofila elem)
{

tipofila novo;
novo=(tipofila) malloc (sizeof(struct competicao));
if (novo==NULL)
   printf("Fila Cheia \n");
else  {
    novo = elem;
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
int FIRST(tipofila inicio, tipofila fim, tipofila *elem)
{
	if(!Fila_IsEmpty(inicio,fim))	{
        *elem = inicio;
		return 1;
		}
	else
		return 0;
}

/*Remove o elemento do inicio da fila */
int DEQUEUE(tipofila *inicio, tipofila *fim, tipofila *elem)
{
	tipofila aux = *inicio;
	if(!Fila_IsEmpty(inicio,fim))	{
        *elem = &inicio;
		(*inicio) = (*inicio)->prox;
		free (aux);
		if (*inicio == NULL)
			*fim = NULL;
		return 1;
		}
	else
		return 0;
}
