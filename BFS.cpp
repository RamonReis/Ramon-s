#include<stdio.h>
#include<stdlib.h>
#include <algorithm>
#include <iostream>
#include <list>

#define NUMVERTICES 4
 
struct vertice {
	int valor;
	int visitado;//n sera necessario para o BFS
	struct vertice* verticesAdjacentes[10];//10 sera o numero maximo de arestas para cada vertice
};

void BFS(struct vertice* grafo[], int indexVerticeInicial){ 
	//coloca todos os vertices na fila (os indexes do vetor correspondem aos vertices)
	int visitados[NUMVERTICES] = {0,0,0,0};
	std::list<vertice> lista;
	
	lista.push_front(*grafo[indexVerticeInicial]);
	visitados[indexVerticeInicial] = 1;
	
	
	while(!lista.empty()) {
		lista.remove(*grafo[indexVerticeInicial]);
		int i;
		for (i = 0; i < (*grafo[indexVerticeInicial]).verticesAdjacentes.size() ; i++){
			
		}
	}
	
}

int main() {
	
	struct vertice vetorVertices[NUMVERTICES] = {
		{.valor = 0, .visitado = 0},
		{.valor = 1, .visitado = 0},
		{.valor = 2, .visitado = 0},
		{.valor = 3, .visitado = 0}
	};
	
	struct vertice* grafo[NUMVERTICES] = {
		&vetorVertices[0],
		&vetorVertices[1],
		&vetorVertices[2],
		&vetorVertices[3]
	};
	
	printf("a");
	//faz as arestas entre eles
	vetorVertices[0].verticesAdjacentes[0] = &vetorVertices[1];
	vetorVertices[0].verticesAdjacentes[1] = &vetorVertices[2];
		
	vetorVertices[1].verticesAdjacentes[0] = &vetorVertices[0];
	vetorVertices[1].verticesAdjacentes[1] = &vetorVertices[3];
	
	vetorVertices[2].verticesAdjacentes[0] = &vetorVertices[0];
	vetorVertices[2].verticesAdjacentes[1] = &vetorVertices[3];
	
	vetorVertices[3].verticesAdjacentes[0] = &vetorVertices[1];
	vetorVertices[3].verticesAdjacentes[1] = &vetorVertices[2];
	printf("a");
	
	
	
	return 0;
}



/*
void BFS(struct vertice vertInicial){
	if(vertInicial.visitado == 0) {
		vertInicial.visitado = 1;
		int i;
		while(vertInicial.verticesAdjacentes[i] )  {
			printf("%d", vertInicial.visitado);
			BFS(*vertInicial.verticesAdjacentes[i]);
			i++;
		}
	} 
		
}

void bfsGeral(struct vertice* vertis[], struct *vertice vertInicial) {
	int a = 0;
	while((*vertis[a]).visitado == 0){
		BFS(*vertis[a]);
		
		a++;
	}
}
 
int main(){
	//instancia os vertices
	struct vertice vetorVertices[NUMVETORES] = {
		{.valor = 1, .visitado = 0},
		{.valor = 3, .visitado = 0},
		{.valor = 9, .visitado = 0},
		{.valor = 7, .visitado = 0}
	};
	
	struct vertice* pntVetorVertices[NUMVETORES] = {
		&vetorVertices[0],
		&vetorVertices[1],
		&vetorVertices[2],
		&vetorVertices[3]
	};
	
	printf("a");
	//faz as arestas entre eles
	vetorVertices[0].verticesAdjacentes[0] = &vetorVertices[1];
	vetorVertices[0].verticesAdjacentes[1] = &vetorVertices[2];
		
	vetorVertices[1].verticesAdjacentes[0] = &vetorVertices[0];
	vetorVertices[1].verticesAdjacentes[1] = &vetorVertices[3];
	
	vetorVertices[2].verticesAdjacentes[0] = &vetorVertices[0];
	vetorVertices[2].verticesAdjacentes[1] = &vetorVertices[3];
	
	vetorVertices[3].verticesAdjacentes[0] = &vetorVertices[1];
	vetorVertices[3].verticesAdjacentes[1] = &vetorVertices[2];
	printf("a");
	bfsGeral(pntVetorVertices, pntVetorVertices[0]);
	
	return 0;
}*/
