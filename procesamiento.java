/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.fierros;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author axel
 */
public class procesamiento {
    Timer timer = new Timer();
    int ID=1;
    memoria aux;
    memoria inicio=new memoria();
    memoria fin= new memoria();
    proceso nada= new proceso();
    int memtotal,memactual=0, memmax,tiempomax,tiempolibre;
    memoria initialF, initialW, initialB;
    int veces;
    int vel=1000;
    int eliminadosF, eliminadosB, eliminadosW;
    public procesamiento(int mem, int maxm, int tiempo, int maxt){
    	memtotal=mem;
    	memmax=maxm;
    	tiempolibre=tiempo;
        veces=tiempo;
    	tiempomax=maxt;
    	initialF=new memoria(memtotal);
        
        inicio.setSig(initialF);
        initialF.setAnt(inicio);
        initialF.setSig(fin);
        fin.setAnt(initialF);
        memactual=memtotal;       
    }

    /*public static void main(String[] args) { 
        first holi= new first();
    }*/
    
    public void paginacion(){
        
    }
    
    public void segmentacion(){
        timer.schedule(new TimerTask() {
            public void run() {
              // Your database code here
                veces--;
                ID++;
                proceso nuevo= new proceso(ID , tiempomax, memmax);
                first (nuevo);
                
                
                if(veces ==0){
                     timer.cancel();
                }
            }
        }, vel, vel);
    }
    public void change_vel(boolean masmenos){//boton mas true boton menos false 
       if(masmenos==true){
           vel=(int)(vel * 1.5);
       }
       else{
          vel=(int)(vel/1.5);
       }
    }
    public void first(proceso nuevo ){
        boolean bandera, seencontro=false;
        proceso actual= new proceso();
        //actual = initialF;
        if (nuevo.tiempo<veces){
                bandera=true;
        }
        else{
                bandera=false;
        }
        actual = initialF;
        while(actual.sig!=null){
            actual=actual.sig;
            if(actual.proceso.getTime>0){
                actual.proceso.time--;
                if(actual.proceso.getTime()==0){
                        actual.proceso.changeState();
                        memactual=memactual+actual.proceso.tamanio;
                }
            }
            do{
                if(actual.sig.proceso.getState==0 || actual.sig.proceso.getTime()==1){//SE CONDENSAN ESPACIOS VACIOS CONJUNTOS
                        memactual=memactual+actual.sig.proceso.tamanio;
                        actual.proceso.tamanio=actual.proceso.tamanio+actual.sig.proceso.tamanio;
                        actual.fin=actual.inicio+actual.proceso.tamanio;
                        actual.sig.sig.ant=actual;
                        actual.sig=actual.sig.sig;
                }
            }while(actual.sig.proceso.getState()==0 || actual.sig.proceso.getTime()==1);

            if(actual.proceso.getState==0 && seencontro==false){

                if(actual.proceso.tamanio==nuevo.tamanio){
                        actual.proceso=nuevo;
                        memactual=memactual-actual.proces.tamanio;
                        seencontro=true;
                }
                else if (actual.procedimiento.getMem() > nuevo.getMem()) {
                    memoria libre = new memoria(actual, actual.sig, (actual.procedimiento.getMem() - nuevo.getMem()), 0);
                    actual.procedimiento.tamanio = nuevo.tamanio;
                    actual.sig = libre;
                    actual.fin = actual.inicio + nuevo.tamanio;
                    libre.inicio = actual.fin + 1;
                    memactual = memactual - actual.procedimiento.tamanio;
                    seencontro = true;
                }

            }

        }

        if(seencontro==false){
                eliminadosF++;
        }
        //Pasar el segundo en el timer
	mostra_estadisticas();
    }
    
    public void mostra_estadisticas(){

    }


}



class first{
    int veces;
    public first(){
        veces=10;
        segmentacion();
    }
    Timer timer = new Timer();
    public void segmentacion(){
        timer.schedule(new TimerTask() {
            public void run() {
              // Your database code here
                veces--;
                System.out.println("holi");
                if(veces ==0){
                     timer.cancel();
                }
            }
        }, 1*1000, 1*1000);
        
    }
}
