
package Velha;

import java.util.Scanner;


public class Teste {
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        Campo [][] tabuleiro = new Campo [3][3];
        
        char jogador ='X';
        boolean game = true;
        
        DistribuirCampos(tabuleiro);
        int[]posicao= new int [2];
        while(game){
           
                QualJogador(jogador);
                Desenhar(tabuleiro);
             do{System.out.println("Linha:");
                posicao[0]=input.nextInt();
                System.out.println("Coluna:");
                posicao[1]=input.nextInt();
                }while(!Marcar(tabuleiro, posicao, jogador));
               if(VerificarVitoria(tabuleiro)){
                   Desenhar(tabuleiro);
                   System.out.println("\nJogador ("+jogador+") ganhou!!!\n\n");
                   game=false;
           
            }else{
                jogador=AlternarJogador(jogador); 
            }    
        }
    }
    
    public static boolean VerificarVitoria(Campo tabu [][]){
        //LINHAS
        if(tabu[0][0].isMarcado() && tabu[0][1].isMarcado() && tabu[0][2].isMarcado()){
            char posicao[]= new char [3];
            posicao[0]=tabu[0][0].getSimbolo();
            posicao[1]=tabu[0][1].getSimbolo();
            posicao[2]=tabu[0][2].getSimbolo();
            if(posicao[0] == posicao[1] && posicao[1] == posicao[2]){
                 return true;
            } 
        }
        if(tabu[1][0].isMarcado() && tabu[1][1].isMarcado() && tabu[1][2].isMarcado()){
           char posicao[]= new char [3];
            posicao[0]=tabu[1][0].getSimbolo();
            posicao[1]=tabu[1][1].getSimbolo();
            posicao[2]=tabu[1][2].getSimbolo();
            if(posicao[0] == posicao[1] && posicao[1] == posicao[2]){
                 return true;
            }
        }
        if(tabu[2][0].isMarcado() && tabu[2][1].isMarcado() && tabu[2][2].isMarcado()){
              char posicao[]= new char [3];
            posicao[0]=tabu[2][0].getSimbolo();
            posicao[1]=tabu[2][1].getSimbolo();
            posicao[2]=tabu[2][2].getSimbolo();
            if(posicao[0] == posicao[1] && posicao[1] == posicao[2]){
                 return true;
            }
        }  
        //COLUNAS
        if(tabu[0][0].isMarcado() && tabu[1][0].isMarcado() && tabu[2][0].isMarcado()){
             char posicao[]= new char [3];
            posicao[0]=tabu[0][0].getSimbolo();
            posicao[1]=tabu[1][0].getSimbolo();
            posicao[2]=tabu[2][0].getSimbolo();
            if(posicao[0] == posicao[1] && posicao[1] == posicao[2]){
                 return true;
            }
        }    
        if(tabu[0][1].isMarcado() && tabu[1][1].isMarcado() && tabu[2][1].isMarcado()){
              char posicao[]= new char [3];
            posicao[0]=tabu[0][1].getSimbolo();
            posicao[1]=tabu[1][1].getSimbolo();
            posicao[2]=tabu[2][1].getSimbolo();
            if(posicao[0] == posicao[1] && posicao[1] == posicao[2]){
                 return true;
            }
        }
        if(tabu[0][2].isMarcado() && tabu[1][2].isMarcado() && tabu[2][2].isMarcado()){
                   char posicao[]= new char [3];
                posicao[0]=tabu[0][2].getSimbolo();
                posicao[1]=tabu[1][2].getSimbolo();
                posicao[2]=tabu[2][2].getSimbolo();
            if(posicao[0] == posicao[1] && posicao[1] == posicao[2]){
                 return true;
            }
        }
        //
        
        if(tabu[0][0].isMarcado() && tabu[1][1].isMarcado() && tabu[2][2].isMarcado()){
                char posicao[]= new char [3];
            posicao[0]=tabu[0][0].getSimbolo();
            posicao[1]=tabu[1][1].getSimbolo();
            posicao[2]=tabu[2][2].getSimbolo();
            if(posicao[0] == posicao[1] && posicao[1] == posicao[2]){
                 return true;
            }
        }    
         if(tabu[0][2].isMarcado() && tabu[1][1].isMarcado() && tabu[2][0].isMarcado()){
                char posicao[]= new char [3];
            posicao[0]=tabu[0][2].getSimbolo();
            posicao[1]=tabu[1][1].getSimbolo();
            posicao[2]=tabu[2][0].getSimbolo();
            if(posicao[0] == posicao[1] && posicao[1] == posicao[2]){
                 return true;
            }
         }    
        return false;
    }

  

    public static void QualJogador(char j){
        if(j=='X'){
            System.out.println("\nJOGADOR 1 ("+j+")\n");
        }else{
         System.out.println("\nJOGADOR 2 ("+j+")\n");
        }
    }
 
    public static char AlternarJogador(char j){
        if(j=='X'){
            return 'O';
        }
        return 'X';
    }
    
    public static boolean Marcar(Campo tabu[][], int p[], char j){
        int num1=p[0];
        int num2=p[1];
        if(num1>=3 || num2>=3){
            System.out.println("\nCOORDENADA INVALIDA\n\n");
            return false;
        }
        if(!tabu[num1][num2].isMarcado()){
            tabu[num1][num2].setSimbolo(j);
            tabu[num1][num2].setMarcado(true);
            return true;
        } 
        System.out.println("\nCAMPO MARCADO\n\n");
        return false;
    }
          
    
    public static void DistribuirCampos(Campo[][]tabu){
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                tabu[i][j]=new Campo(' ', false);
            }
            
        }
    }
    
    public static void Desenhar(Campo [][] tabu){
        
        System.out.println("   0 1 2 ");
        System.out.println("0  "+tabu[0][0].getSimbolo()+"|"+tabu[0][1].getSimbolo()+"|"+tabu[0][2].getSimbolo());
        System.out.println("   ------");
        System.out.println("1  "+tabu[1][0].getSimbolo()+"|"+tabu[1][1].getSimbolo()+"|"+tabu[1][2].getSimbolo());
        System.out.println("   ------");
        System.out.println("2  "+tabu[2][0].getSimbolo()+"|"+tabu[2][1].getSimbolo()+"|"+tabu[2][2].getSimbolo());
        
       
                        
        
       
    }
}
