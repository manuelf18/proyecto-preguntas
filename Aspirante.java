public class Aspirante{
    private String nombre;
    private String cedula;
    private String[] respuestas;

    public void asignar(String nombre, String cedula, String[] respuestas){
        /* this funciona para referirse a los atributos del objeto que llama el metodo
            entonces simplemente se estan asignando los parametros a los atributos privados. */
        this.nombre = nombre;
        this.cedula = cedula;
        this.respuestas = respuestas;
    }

    public int evaluar(String[] correctas, int[] puntos){
        int i, puntaje=0;
        for(i=0; i<respuestas.length; i++){
            /* Como declaramos el arreglo de respuestas como tamaño 11, pero en la mayoria de los casos no se van a realizar 11 preguntas
             es probable que el arreglo de respuestas quede por ejemplo como: 
             respuestas = [si, no, si, no, si, null, null, null, null...]
             entonces lo correcto es detener el ciclo cuando respuesta[i] sea null.
             */
            if(respuestas[i] == null){
                break; // si respuestas[i] = null se rompe el ciclo
            }
            if(respuestas[i].equalsIgnoreCase(correctas[i]))
                puntaje += puntos[i]; // esto es lo mismo que decir puntaje = puntaje + puntos[i]
        }
        return puntaje;
    }

    public double promediar(int puntaje, int puntos_posibles){
        /* simple division entre los puntos que saco / los puntos posibles 
            se multiplica por *1.0 para que resultado se de en decimales. 
            en java si se divide int / int la respuesta sera int. 
            Asi que hay que convertir a double
        */
        return ( (puntaje * 1.0 / puntos_posibles) * 100 );
    }

    public String traerN(){
        return nombre;
    }
    public String traerC(){
        return cedula;
    }
    public String[] traerR(){
        return respuestas;
    }
}