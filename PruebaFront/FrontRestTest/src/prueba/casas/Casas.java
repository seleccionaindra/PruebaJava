package prueba.casas;

import java.util.ArrayList;
import java.util.List;

public class Casas {
    
   	public List<Integer> estadoCasas(List<Integer> estadoActual, int dias){
		List<Integer> estadoSiguiente = new ArrayList<Integer>();
		List<Integer> estadoFinal = new ArrayList<Integer>();
		
		for(int  i = 0 ; i < estadoActual.size() ; i ++) {
			int value = 0; 
			if(i == 0 && estadoActual.get(i+1) == 0) {
				value = estadoActual.get(i) == 1 ? 0 : 1;
				estadoSiguiente.add(value);
			} else {
				if (i == estadoActual.size()-1 && estadoActual.get(i+1) == 0) {
					value = estadoActual.get(i) == 1 ? 0 : 1;
					estadoSiguiente.add(value);
				} else {
					if(i > 0 && i < estadoActual.size()-1 && estadoActual.get(i-1) == 0 && estadoActual.get(i+1) == 0) {
						value = estadoActual.get(i) == 1 ? 0 : 1;
						estadoSiguiente.add(value);
					}
				}
			}
		}
		if(dias > 0) {
			estadoFinal = estadoCasas(estadoSiguiente,dias-1);
		}
		return estadoFinal;
    	
   	}
    
}
