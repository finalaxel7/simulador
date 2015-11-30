/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_procesos;
import java.util.Random;
/**
 *
 * @author Wendy
 */
public class proceso {
    int id;
    int tiempo;
    int tamanio;
    int estado;
    
    public proceso()
    {
        id=0;
        tiempo=0;
        tamanio=0;
        estado=0;
    }
    
    public proceso(int idt, int maxt,int maxm){
        id=idt;
        tiempo=getrand(maxt);
        tamanio=getrand(maxm);
        estado=0;
    }
    
    public proceso(int memory, int state){
	tamanio=memory;
	id=0;
	estado=state;
    }
    
    
    private int getrand(int maxi){
        Random rnd = new Random();
        int numero;
        numero=(int)(rnd.nextDouble() * maxi + 1);
        return numero;
    }
    
    private void changeState(){
        if(this.estado==0){
            this.estado=1;
        }
        else if(this.estado==1)
        {
            this.estado=0;
        }
    }
}
