#include <stdlib.h>



struct no { 

       int dado;

       struct no *prox;

};



typedef struct no* tipofila;



void INIT (tipofila *inicio,tipofila *fim)

{

*inicio=NULL;

*fim=NULL;

}



void ENQUEUE(tipofila *inicio, tipofila *fim, int v)

{

tipofila novo;

novo=(tipofila) malloc (sizeof(struct no));

if (novo==NULL) 

   printf("Fila Cheia \n");

else  {

	 novo->dado=v;

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



int IsEmpty(tipofila ini, tipofila fim)

{

	if ( (ini == NULL) && (fim==NULL))

		return 1;

	else

		return 0;

}



int FIRST(tipofila inicio, tipofila fim, int *v)

{

	if(!IsEmpty(inicio,fim))	{	

		*v = inicio->dado;

		return 1;

		}	

	else

		return 0;

}		



int DEQUEUE(tipofila *inicio, tipofila *fim, int *v)

{

	tipofila aux = *inicio;

	if(!IsEmpty(*inicio,*fim))	{	

		*v = (*inicio)->dado;

		(*inicio) = (*inicio)->prox;

		free (aux);

		if (*inicio == NULL)

			*fim = NULL;

		return 1;

		}	

	else

		return 0;

}	
