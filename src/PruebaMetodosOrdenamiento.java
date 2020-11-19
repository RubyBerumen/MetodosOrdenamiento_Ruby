import java.util.Arrays;

class MetodosOrdenamiento{
	
	static class Burbuja{
		
		static long tInicio, tFin;
		
		public static void ordenacionBurbuja1(int [] numeros) {
			
			for (int i=1; i<=numeros.length-1; i++) {
				for (int j=0; j<=numeros.length-i-1; j++) {
					if (numeros[j]>numeros[j+1]) {
						int aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
			tFin = System.currentTimeMillis();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja:"+(tFin-tInicio));
		}// Burbuja1
		
		public void ordenacionBurbuja2(int [] numeros) {}
		
		public void ordenacionBurbuja3(int [] numeros) {}
		
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
		
		
		
		


	}

}
