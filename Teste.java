
package Velha;

import java.util.Random;
import java.util.Scanner;


public class Teste {
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        Campo [][] tabuleiro = new Campo [3][3];
        
        boolean game = true;
        
        DistribuirCampos(tabuleiro);
        int[]posicao= new int [2];
       while(game){
          
                Desenhar(tabuleiro);
             do{System.out.println("Linha:");
                posicao[0]=input.nextInt();
                System.out.println("Coluna:");
                posicao[1]=input.nextInt();
                }while(!Marcar(tabuleiro, posicao));
               JogadaInimiga(tabuleiro);
                
                
        }
    }
    
    
    public static void JogadaInimiga(Campo tabu[][]){
        Random gerador = new Random ();
        int i;
        int j;
       do{i= gerador.nextInt(3);
          j= gerador.nextInt(3);
        }while(!tabu[i][j].isMarcado());
            tabu[i][j].setSimbolo('O');
            tabu[i][j].setMarcado(true);
    }
    
    
    public static boolean Marcar(Campo tabu[][], int p[]){
        int num1=p[0];
        int num2=p[1];
        if(num1>=3 || num2>=3){
            System.out.println("\nCOORDENADA INVALIDA\n\n");
            return false;
        }
        if(!tabu[num1][num2].isMarcado()){
            tabu[num1][num2].setSimbolo('X');
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
