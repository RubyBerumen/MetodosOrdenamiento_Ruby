import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

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
	
	
	
	static class Insercion{
		
		public static void ordenar(int[]numeros) {
			int aux;
			
			for (int i = 0; i < numeros.length; i++) {
				aux = numeros[i];
				
				for (int j = i-1; j > 0 && numeros[j]>aux; j--) {
					numeros[j+1]=numeros[j];
					numeros[j]=aux;
				}
				
			}
			
		}
	}//class insercion
	
	
	
	static class Seleccion{
		
		public static void ordenamiento(int []numeros) {
			for (int i = 0; i < numeros.length-1; i++) {
				for (int j = i; j < numeros.length; j++) {
					if(numeros[i]> numeros[j]) {
						int minimo = numeros[i];
						numeros[i]=numeros[j];
						numeros [j] = minimo;
					}
					
				}
			}
		}
		
	}//class Seleccion
	
	
	
	static class Quicksort{
		
		public static int[] ordenar (int[]numeros, int izq, int der) {
			int pivote = numeros[izq];
			int i = izq, j = der;
			int aux;
			
			while (i<j) {
				while(numeros[i]<=pivote && i<j) i++;
				while(numeros[j]>pivote) j--;
				if(i<j) {
					aux = numeros[i];
					numeros[i]=numeros[j];
					numeros[j]=aux;
				}
				
			}
			numeros[izq] = numeros[j];
			numeros[j] = pivote;
			
			if(izq<j-1)
				ordenar(numeros,izq,j-1);
			if(j+1 < der)
				ordenar(numeros,j+1,der);
			
			return numeros;
		}
		
	}//quicksort
	
	
	static class Shellsort{
		
		public static void ordenar(int[] numeros) {
			int intervalo;
			intervalo = numeros.length/2;
			
			while(intervalo>0) {
				for(int i = intervalo; i<numeros.length; i++) {
					int j=i-intervalo;
					while(j>=0) {
						int k=j+intervalo;
						if(numeros[j] <= numeros[k]) {
							j-=1;
						}else {
							int aux = numeros[j];
							numeros[j] = numeros[k];
							numeros[k] = aux;
							j-=intervalo;
						}
					}
				}
				intervalo=intervalo/2;
			}
			
		}//public void ordenar
		
	}//class shellsort
	
	
	public static void mostrarVector(int [] numeros) {
		System.out.println("Vector ordenado: "+Arrays.toString(numeros) + "\n");
	}

}//class MetodosOrdenamiento


public class PruebaMetodosOrdenamiento {

	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);		
		boolean salir = false;
		
		do {
			int numeros [] = {6,2,9,7,1,0,4};
			System.out.println("Vector desordenado: " + Arrays.toString(numeros));
			System.out.println("Ordenar el arreglo por m�todo de:");
			System.out.println("1. Burbuja");
            System.out.println("2. Inserci�n");
            System.out.println("3. Selecci�n ");
            System.out.println("4. Quicksort");
            System.out.println("5. Shellsort");
            System.out.println("6. Salir");
           
            try {
            	System.out.println("Escribe una de las opciones");
                int op = ent.nextInt();
 
                switch (op) {
                    case 1:
                        
                		boolean salir1 = false;
                		
                		do {
                			
                			System.out.println("1. Burbuja1");
                            System.out.println("2. Burbuja2");
                            System.out.println("3. Burbuja3");
                            System.out.println("4. Salir");
                           
                            try {
                            	System.out.println("Escribe una de las opciones");
                                int opc = ent.nextInt();
                 
                                switch (opc) {
                                    case 1:
                                    	MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(numeros);
                                    	MetodosOrdenamiento.mostrarVector(numeros);
                                        break;
                                    case 2:
                                    	MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(numeros);
                                    	MetodosOrdenamiento.mostrarVector(numeros);
                                        break;
                                    case 3:
                                    	MetodosOrdenamiento.Burbuja.ordenacionBurbuja3(numeros);
                                    	MetodosOrdenamiento.mostrarVector(numeros);
                                        break;
                                    case 4:
                                        salir1 = true;
                                        break;
                                    default:
                                        System.out.println("Debes ingresar n�meros entre 1 y 4");
                                }
                				
                			} catch (InputMismatchException e) {
                				System.out.println("Debes ingresar un n�mero");
                                ent.next();
                				
                			}
                            
                			
                		}while (!salir1);//while

                        break;
                    case 2:
                    	MetodosOrdenamiento.Insercion.ordenar(numeros);
                    	MetodosOrdenamiento.mostrarVector(numeros);
                        break;
                    case 3:
                    	MetodosOrdenamiento.Seleccion.ordenamiento(numeros);
                    	MetodosOrdenamiento.mostrarVector(numeros);
                        break;
                    case 4:
                    	MetodosOrdenamiento.Quicksort.ordenar(numeros, 0, numeros.length-1);
                    	MetodosOrdenamiento.mostrarVector(numeros);
                    	break;
                    case 5:
                    	MetodosOrdenamiento.Shellsort.ordenar(numeros);
                    	MetodosOrdenamiento.mostrarVector(numeros);
                    	break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Debes ingresar n�meros entre 1 y 6");
                }
				
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un n�mero");
                ent.next();
				
			}
            
			
		}while (!salir);//while
		
		
		
		


	}

}
