import java.io.*;
import java.util.Random;

public class Principal
{ 	
	
	public static void main(String [] args) throws IOException
	{
		// Declaracion de los Objetos
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Objeto de lectura
		Random rand = new Random(); // Objeto de la clase Random
		Banco banco = new Banco(); // Objeto del banco de preguntas
		Aspirante[] aspirantes = new Aspirante[5]; // Este es un arreglo de la clase aspirantes
												   // el indice describe cuantos aspirantes van a particiar en la prueba
		Aspirante aspirante = new Aspirante(); // Objeto de la clase aspirante
											   // sirve para acceder directamente a los metodos de la clase  
		

		// Declaracion de las Variables locales para preguntas
		// Todos estos arreglos se declaran de tamato 11 porque es el numero maximo de preguntas que se pueden realizar
		String[] preguntas = new String[11]; // este es un arreglo que va a contener las preguntas
		String[] correctas = new String[11]; // este es un arreglo que contiene la respuesta correcta de cada pregunta
		int[] puntajes = new int[11]; // este es un arreglo que contiene la cantidad de puntos de las preguntas
		
		
		// Declaracion de las Variables locales para el Aspirante
		String nombre = ""; // Nombre del aspirante
		String cedula = ""; // Cedula del aspirante
		String[] respuestas = new String[11]; // Arreglo que contiene las respuestas del aspirante
		int puntos_posibles = 0; // estos son los puntos maximos que puede obtener el aspirante
		final int cant_preg = rand.nextInt(6) + 5; /* la cantidad de preguntas que se le van a realizar al apirante
												    como son 5 preguntas minimo y 11 maximo se busca un numero aleatorio
													entre 0 y 6. por ejemplo: en el caso de que el numero aleatorio sea 0
													la cantidad de preguntas va a ser (0 + 5) = 5 y en caso de que sea el maximo 6 sera
													(6 + 5) = 11. 
													Una formula para garantizar un buen rango de aleatoriedad 
													es rand.nextInt(max - min) + min 
													
													es final porque su valor no debe cambiar en ninguno momento
													*/

		final boolean aleatorio = false; // cambia de true a false si quieres que las preguntas sean al azar
		// estas son variables por si las preguntas son al azar
		int[] preguntas_aleatorias = new int[respuestas.length]; // contiene los indeces que ya se usaron
		boolean next; // verifica si el indice esta en el arreglo

		int i, x, index, aux, temp; //estos son simples contadores que se usan en los ciclos de repeticion. 
		// Se crean 11 preguntas para prueba
		preguntas[0] = "¿Se siente usted Feliz?";
		preguntas[1] = "¿Cree usted en la Verdad?";
		preguntas[2] = "¿Se siente bien?";
		preguntas[3] = "¿Pelea a menudo?";
		preguntas[4] = "¿Se siente preocupado?";
		preguntas[5] = "¿Ayuda a la gente?";
		preguntas[6] = "¿Es usted bueno en java?";
		preguntas[7] = "¿Esta seguro de si mismo?";
		preguntas[8] = "¿Le gusta la POO?";
		preguntas[9] = "¿Duerme bien?";
		preguntas[10] = "¿Come seguido?";

		// Las respuestas de las 5 previas preguntas
		correctas[0] = "Si";
		correctas[1] = "Si";
		correctas[2] = "Si";
		correctas[3] = "No";
		correctas[4] = "No";
		correctas[5] = "Si";
		correctas[6] = "Si";
		correctas[7] = "Si";
		correctas[8] = "Si";
		correctas[9] = "Si";
		correctas[10] = "Si";

		// Los puntos de las 5 previas preguntas
		puntajes[0] = 4;
		puntajes[1] = 2;
		puntajes[2] = 3;
		puntajes[3] = 10;
		puntajes[4] = 5;
		puntajes[5] = 6;
		puntajes[6] = 10;
		puntajes[7] = 2;
		puntajes[8] = 10;
		puntajes[9] = 2;
		puntajes[10] = 2;
		
		banco.asignar(preguntas, puntajes, correctas); // Se asignan las preguntas al banco de preguntas

		puntajes = new int[aspirantes.length]; /*recicle la variable puntajes, ahora su proposito es ser un arreglo
											   de los puntajes de cada participante */

		// Se empieza un ciclo de repeticion para todos los aspirantes.
		for(aux=0; aux< aspirantes.length; aux++){
			puntos_posibles = 0; // cada vez se vuelven a iniciar los puntos posibles
			aspirante = new Aspirante(); // se limpia el aspirante
			System.out.println("Bienvenido Aspirante\nPor favor ingrese los siguientes datos personales:");
			do{
				next = true;
				try{

					System.out.println("\nIngrese su Nombre");
					nombre = br.readLine(); // se lee el nombre del aspirante
					if(nombre.equals(""))
						throw new IOException(); // lanzar una propia excepcion sin el usuario deja la cedula en blanco
				}
				catch(IOException ex){
					System.out.println("No puede dejar el nombre en blanco");
					next = false;
				}
			}while(!next);
			do{
				next = true;
				try{
					System.out.println("Ingrese su Cedula");
					cedula = br.readLine(); // se lee la cedula del aspirante
					if(cedula.equals(""))
						throw new IOException(); 
				}
				catch(IOException ex){
					System.out.println("No puede dejar la cedula en blanco");
					next = false;
				}
			}while(!next);

			System.out.println("\nGracias por contestar las preguntas personales, ahora comenzara el cuestionario");
			System.out.println("Por favor conteste las siguientes preguntas con 'si' o 'no' \n");
			// comienza el cuestionario
			for(i=0; i<=cant_preg; i++){
				do{
					next = true;
					index = i;
					if(aleatorio){ // esta condicion es si se quieren preguntas al azar
						do{
							// este ciclo verifica si el arreglo preguntas aleatorias contiene el indice al azar
							next = true;
							index = rand.nextInt(11);
							if(i!=0){
								for(x=0; x<preguntas_aleatorias.length; x++){
									if(preguntas_aleatorias[x] == index)
										next = false;
								}
							}
							preguntas_aleatorias[i] = index; 
						} while(!next);
					}
					//Este es un ciclo de repeticion que se repite mientras la respuesta de las preguntas no sea
					// si, SI, sI, Si, no, No, nO, NO
					try{
						System.out.println(banco.traerT(index)); // se trae la pregunta desde la clase Banco
						respuestas[i] = br.readLine();
						puntos_posibles += banco.traerP(index); // se trae los puntos posibles de dicha pregunta,  +=  se explica en Banco en el metodo evaluar()
						if(!respuestas[i].equalsIgnoreCase("si") && !respuestas[i].equalsIgnoreCase("no"))
							throw new IOException(); // lanzar una excepcion  si el usuario ingresa algo que es si o no
					}
					catch(NullPointerException ex){
						System.out.println("error de entrada");
						next = false;
					}
					catch(IOException ex){
						System.out.println("Solo ingrese si o no");
						next = false;
					}
				}while(!next); // compara las cadenas ignorando las mayusculas
			}
			aspirante.asignar(nombre, cedula, respuestas); // se asignan los datos del aspirante
			puntajes[aux] = aspirante.evaluar(banco.traerC(), banco.traerP()); // el puntaje del aspirante se guarda en el arreglo de puntajes
			aspirantes[aux] = aspirante; // y el objeto del aspirante se guarda en el arreglo de aspirantes
			System.out.println("Fin del Cuestionario");
			System.out.println("Usted obtuvo: "+ puntajes[aux] + " puntos\n");  // un mensaje con la calificacion del aspirante
		}
		/*
		Este es un simple sorting para ordernar el arreglo en base al puntaje. Ahorita mismo hay dos arreglos:
		aspirantes = [ aspirante1 , aspirante2, aspirante3 ]
		puntajes = [puntaje del aspirante 1, aspirante 2, aspirante 3]
		
		Entonces con un BubbleSort podemos ordenar el arreglo de puntajes posicion por posicion, lo interesante es que
		es necesario mover el arreglo de aspirantes para que tambien quede ordernado. 
		 */
		for(i=0; i < aspirantes.length; i++){  
			for(aux=1; aux < (aspirantes.length-i); aux++){
				if(puntajes[aux-1] < puntajes[aux]){
					/*En bubblesort simplemente se hace un cambio de posicion si el siguiente elemeno es mayor que el primero
					P.e si [4,6,3,5] BubbleSort haria [6,4,3,5] => [6,4,5,3] => [6,5,4,3]
					para esto se guarda el valor en una variable temporal para hacer un cambio. */

					// cambio en el arreglo de puntajes
					temp = puntajes[aux-1];  
					puntajes[aux-1] = puntajes[aux];  
					puntajes[aux] = temp;

					// cambio en el arreglo de aspirantes
					aspirante = aspirantes[aux-1];
					aspirantes[aux-1] = aspirantes[aux];
					aspirantes[aux] = aspirante;
				}
			}  
		}
		System.out.println("\n\nAqui esta la lista de los canditatos y su puntuacion\n");
		for(i=0; i < aspirantes.length; i++){
			// ahora que el arreglo esta ordernado solo tenemos que imprimir
			if(i==0)
				System.out.println("Felicidades a los 3 Primeros Candidatos: \n");
			if(i==3)
				System.out.println("\nEl resto de los canditatos son: \n");
			System.out.println(aspirantes[i].traerN() + " cedula: " + aspirantes[i].traerC() + " con " + puntajes[i] + " puntos. De " + puntos_posibles + " posibles, y promedio de: " + aspirante.promediar(puntajes[i], puntos_posibles));
		
		}
	}
}