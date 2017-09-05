/************************************************************************/
/* Nome do Arq : serv-seq.c                                             */
/* Funcao      : servidor sequencial                                    */
/* Autor       : Jorge Lopes de Souza Leao                              */
/************************************************************************/
/* Data Inicio : 26 abr 01                                              */
/* Ult Modif   : 30 mai 03                                              */
/************************************************************************/
#include <unistd.h>
#include <sys/time.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <stdio.h>
#include <netinet/in.h> // --- DIFERE DA DOCUMENTACAO !!
#include <netdb.h>
#include <unistd.h>

#define EMPTYLINE "\n"
#define PORTA     3456

//------------------------------------------------------------
int sPassivo,sAtivo;
struct sockaddr_in enderServ1;
struct sockaddr_in enderConex1;
int tamEnderConex;
char linha[80];
int i;
char Nome[64];
struct hostent *ptrDadosDoHost;
int result;

//------------------------------------------------------------
int main(){

    for(i=1;i<5;i++)printf(EMPTYLINE);
    printf("[Servidor] Servidor SEQ-SEQ entrando em funcionamento.\n    Usando a porta %d.\n",PORTA);

    result = gethostname(Nome,sizeof(Nome));
    printf("    gethostname:\n    result = %d , Nome: %s.\n",result,Nome);
    ptrDadosDoHost = (struct hostent *)gethostbyname(Nome);
    printf("Tamanho do nome: %d\n",ptrDadosDoHost->h_length);

    sPassivo = socket(PF_INET,SOCK_STREAM,0);
    if(sPassivo == -1){
       perror("[Servidor] Erro na criacao do sock 1 do servidor: ");
       exit(0);
    }

    enderServ1.sin_family = AF_INET;
    enderServ1.sin_port   = htons(PORTA);
    bcopy(ptrDadosDoHost->h_addr,
          &enderServ1.sin_addr.s_addr, 
          ptrDadosDoHost->h_length);

    //new = accept(sockid, (struct sockaddr *)&clientaddr, &len);

    if(bind(sPassivo,(struct sockaddr *)&enderServ1,sizeof(enderServ1))){
       perror("[Servidor] Erro no bind: ");
       exit(0);
    }
    
    if(listen(sPassivo,10)){
       perror("[Servidor] Erro no listen: ");
       exit(0);
    }

    int pid = 0;
    while(1){
        //Abre o socket para atender a clientes
        sAtivo = accept(sPassivo,&enderConex1,&tamEnderConex);

        printf("[Servidor] (Vai esperar pedido de servico...)\n");
        
        if(sAtivo<0){
        perror("[Servidor] Erro no Accept: ");
        exit(0);
        }
        if(read(sAtivo,linha,80)==-1){
        perror("[Servidor] Erro no read: ");
        }else{
        //Quando a conexao eh recebida deve instanciar um novo fork para atender a outro possivel client

        //http://man7.org/linux/man-pages/man2/fork.2.html
        //Realiza o fork do precesso atual
        if ((pid = fork()) == -1) {//ERROR!
            perror("Erro ao fazer fork!");
            continue;
        }
        else if(pid >= 0) {//Sucesso
            close(sAtivo);
            continue;
        }

        printf("[Servidor] Recebeu: %s\n",linha);
        sleep(200);
        strcpy(linha,"Pois nao. O servico foi prestado.");
        write(sAtivo,linha,strlen(linha));
        }
        shutdown(sAtivo,2);
    }
}













