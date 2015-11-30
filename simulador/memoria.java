package simulador_procesos;

public class memoria {
    int inicio;
    int fin;
    memoria ant;
    memoria sig;
    proceso procedimiento;
    
    public memoria(){
        ant=null;
        sig=null;
        procedimiento=null;
        inicio=0;
        fin=0;
    }
    
    public memoria(memoria prev,memoria siguiente, proceso actual, int ini, int finale){
        ant=prev;
        sig=siguiente;
        procedimiento=actual;
        inicio=ini;
        fin=finale;
    }
    
    public memoria(int x)
    {
        ant=null;
	sig=null;
	procedimiento=new proceso();
	inicio=0;
	fin=0;
    }
    
    public void setAnt(memoria prev){
	ant=prev;
    }

    public void setSig(memoria next){
	sig=next;
    }

    public memoria getAnt(){
	return ant;
    }

    public memoria getSig(){
    	return sig;
    }
    
    public void setInicio(int init){
        inicio=init;
    }
    
    public int getInicio(){
        return inicio;
    }
    
    public void setFin(int finale){
        fin=finale;
    }
    
    public int getFin(){
        return fin;
    } 
}
