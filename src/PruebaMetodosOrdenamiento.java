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
	
	
	
	static class Radix{
		
		public static void orden(int[]numeros) {
		      if(numeros.length == 0)
		          return;
		          int[][] np = new int[numeros.length][2];
		          int[] q = new int[0x100];
		          int i,j,k,l,f = 0;
		          for(k=0;k<4;k++) {
		             for(i=0;i<(np.length-1);i++)
		             np[i][1] = i+1;
		             np[i][1] = -1;
		             for(i=0;i<q.length;i++)
		             q[i] = -1;
		             for(f=i=0;i<numeros.length;i++) {
		                j = ((0xFF<<(k<<3))&numeros[i])>>(k<<3);
		                if(q[j] == -1)
		                l = q[j] = f;
		             else {
		                l = q[j];
		                while(np[l][1] != -1)
		                l = np[l][1];
		                np[l][1] = f;
		                l = np[l][1];
		             }
		             f = np[f][1];
		             np[l][0] = numeros[i];
		             np[l][1] = -1;
		          }
		          for(l=q[i=j=0];i<0x100;i++)
		          for(l=q[i];l!=-1;l=np[l][1])
		        	  numeros[j++] = np[l][0];
		       }//for
		}//orden
		
	}//class Radix
	
	
	static class Intercalacion{
		
		public static int []ordenar(int primero[], int segundo[]){
			
			int arrayOrdenado[] = new int[primero.length+segundo.length];
			
			int i=0, j=0, k=0;
			
			while(i<primero.length && j<segundo.length) {
				if(primero[i]<segundo[j]) {
					arrayOrdenado[k] = primero[i];
					k++;
					i++;
				}else {
					arrayOrdenado[k] = segundo[j];
					j++;
					k++;
					
				}
			}
			while(j<segundo.length) {
				arrayOrdenado[k] = segundo[j];
				j++;
				k++;
			}
			while(i<primero.length) {
				arrayOrdenado[k] = segundo[i];
				i++;
				k++;
			}
			
			return arrayOrdenado;
			
		}
	}
	
	
	
	static class MezclaDirecta{
		
		public static int[] ordenar(int numeros[]) {
			int i,j,k;
			if(numeros.length>1) {
				int numElementosIzq = numeros.length/2;
				int numElementosDer = numeros.length-numElementosIzq;
				
				int arregloIzquierdo[] = new int[numElementosIzq];
				int arregloDerecho[] = new int[numElementosDer];
				
				for (i=0; i<numElementosIzq; i++) {
					arregloIzquierdo[i] = numeros[i];
				}
				
				for (i=numElementosIzq; i<numElementosIzq+numElementosDer; i++) {
					arregloDerecho[i-numElementosIzq]=numeros[i];
				}
				
				arregloIzquierdo = ordenar(arregloIzquierdo);
				arregloDerecho = ordenar(arregloDerecho);
				i=j=k=0;
				
				while(arregloIzquierdo.length!=j && arregloDerecho.length!=k) {
					if(arregloIzquierdo[j]<arregloDerecho[k]) {
						numeros[i] = arregloIzquierdo[j];
						i++;
						j++;
					}else {
						numeros[i] = arregloDerecho[k];
						i++;
						k++;
						
					}

				}
				
				while(arregloIzquierdo.length!=j) {
					numeros[i]=arregloIzquierdo[j];
					i++;
					j++;
				}
				while(arregloDerecho.length!=k) {
					numeros[i]=arregloDerecho[k];
					i++;
					k++;
				}
			}
			return numeros;
		}
	}

	
	
	public static void mostrarVector(int [] numeros) {
		System.out.println("Vector ordenado: "+Arrays.toString(numeros) + "\n\n");
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
            System.out.println("6. Radix");
            System.out.println("7. Intercalaci�n");
            System.out.println("8. MezclaDirecta");
            System.out.println("9. Salir");
           
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
                    	MetodosOrdenamiento.Radix.orden(numeros);
                    	MetodosOrdenamiento.mostrarVector(numeros);
                    	break;
                    case 7:
                    	int segundo[] = {5,50};
                    	System.out.println("Vector 2: "+Arrays.toString(segundo));
                    	MetodosOrdenamiento.Quicksort.ordenar(numeros, 0, numeros.length-1);
                    	MetodosOrdenamiento.mostrarVector(MetodosOrdenamiento.Intercalacion.ordenar(numeros, segundo));
                    case 8:
                    	int vector2[];
                		vector2=MetodosOrdenamiento.MezclaDirecta.ordenar(numeros);
                		MetodosOrdenamiento.mostrarVector(vector2);
                		break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Debes ingresar n�meros entre 1 y 9");
                }
				
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un n�mero");
                ent.next();
				
			}
            
			
		}while (!salir);//while
		
		
		
		


	}

}
