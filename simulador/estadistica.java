package simulador_procesos;

public class estadistica {
    	int sumaTiempo=0;
	int sumaMemoria=0;
	float promedioTiempo=0;
	float promedioMemoria=0;

	public int getnumProcesos(int total, int eliminados){
		return (total-eliminados);
	}

	public void addTiempo(int tiempo){
		sumaTiempo=sumaTiempo+tiempo;
	}

	public void addMemoria(int memoria){
		sumaMemoria=sumaMemoria+memoria;
	}

	public float getPromedioTiempo(int numProcesos){
		promedioTiempo=sumaTiempo/numProcesos;
		return promedioTiempo;
	}

	public float getPromedioMemoria(int numProcesos){
		promedioMemoria=sumaMemoria/numProcesos;
		return promedioMemoria;
	}
}

