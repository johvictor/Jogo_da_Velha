
package Velha;


public class Campo {
    
   private char simbolo;
   private boolean marcado;

    public Campo(char simbolo, boolean marcado) {
        this.simbolo = simbolo;
        this.marcado = marcado;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public void setMarcado(boolean marcado) {
        if(this.marcado==true){
            System.out.println("\n CAMPO MARCADO\n");
        }else{
            this.marcado = marcado;
        }
    }
    
   
   
}
