/* declaracao do no */
	struct no {
		char nome[30];
		int n_componentes;
		struct no *prox;
	};

/*Definição do tipo de dado pilha */
	typedef struct no* tipopilha;

void INIT (tipopilha *topo)
{
*topo = NULL;
}

int IsEmpty(tipopilha topo)
{
if (topo == NULL)
   return(1);
else
  return(0);
}


void PUSH (tipopilha *topo, char nome[30],int n_componentes)
{
tipopilha novo;
novo = (tipopilha) malloc (sizeof(struct no));
if (novo != NULL)
	{
	strcpy(novo->nome,nome);
	novo->n_componentes = n_componentes;
	novo->prox=*topo;
	*topo = novo;
	}
else
	printf("pilha cheia \n");
}

int POP (tipopilha *topo,tipopilha *elem)
{
tipopilha aux;
aux = *topo;
if (!IsEmpty(*topo))   {
     //strcpy(&*elem,aux->nome);
     *elem = &aux;
     *topo=aux->prox;
     free(aux);
     return(1);
     }
else {
	printf("pilha vazia \n ");
    return(0);
    }
}


int TOP (tipopilha topo,tipopilha *elem)
{
if (!IsEmpty(topo))   {
     *elem = topo;
     return(1);
     }
else {
       printf("pilha vazia \n ");
       return(0);
       }
}


