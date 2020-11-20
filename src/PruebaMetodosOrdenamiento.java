import java.util.Arrays;

class MetodosOrdenamiento{
	
	static class Burbuja{
		
		static long tInicio, tFin;
		
		public static void ordenacionBurbuja1(int [] numeros) {
			tInicio=System.nanoTime();
			for (int i=1; i<=numeros.length-1; i++) {
				for (int j=0; j<=numeros.length-i-1; j++) {
					if (numeros[j]>numeros[j+1]) {
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja1:"+(tFin-tInicio));
		}// Burbuja1
		
		public static void ordenacionBurbuja2(int [] numeros) {
			tInicio = System.nanoTime();
            for(int i=1; i<numeros.length; i++) {
				
				for(int j=0; j<numeros.length-i; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
            tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja2: " + (tFin-tInicio));
		}// Burbuja2
		
		public static void ordenacionBurbuja3(int [] numeros) {
			 tInicio = System.nanoTime();
	           int i=1;
	     	   do {
	     		   
	     		   for(int j=0; j<numeros.length-i; j++) {
	 					
	 					if(numeros[j]>numeros[j+1]) {
	 						int aux = numeros[j];
	 						numeros[j] = numeros[j+1];
	 						numeros[j+1] = aux;
	 					}
	 				}
	     		   
	     		   i=1+i;
	     	   }while(i<numeros.length);
	     	    tFin = System.nanoTime();
				System.out.println("Tiempo de ejecucion en ordenamiento por burbuja3: " + (tFin-tInicio));
		}// Burbuja3
		
		public static void mostrarVector(int [] numeros) {
			System.out.println(Arrays.toString(numeros));
		}
		
	}//class Burbuja
	
}//class MetodosOrdenamiento

public class PruebaMetodosOrdenamiento {

	public static void main(String[] args) {
		
		int numeros [] = {6,2,9,7,1,0,4};
		
		MetodosOrdenamiento.Burbuja.mostrarVector(numeros);
		
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(numeros);
		
		MetodosOrdenamiento.Burbuja.mostrarVector(numeros);
		
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(numeros);
		
		MetodosOrdenamiento.Burbuja.mostrarVector(numeros);
		
		MetodosOrdenamiento.Burbuja.ordenacionBurbuja3(numeros);
		
		MetodosOrdenamiento.Burbuja.mostrarVector(numeros);
		
		
		
		


	}

}
