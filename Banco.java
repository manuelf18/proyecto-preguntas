public class Banco{
    private String[] test = new String[11]; 
    private int[] punta = new int[11]; 
    private String[] correc = new String[11];

    public void asignar(String[] test, int[] punta, String[] correc){
        this.test = test;
        this.punta = punta;
        this.correc = correc;
    }
    /* 
    Se usa polimorfismo: se pueden crear dos funciones con el mismo nombre (traerT) mientras que tengan parametros diferentes
    en este caso traerT sin parametros devuelve el arreglo completo de test mientras que traerT con un parametro (en este caso un int)
    devuelve el elemento especifico del arreglo siendo el parametro el indice.
    */
    public String[] traerT(){
        return test;
    }
    public int[] traerP(){
        return punta;
    }
    public String[] traerC(){
        return correc;
    }
    public String traerT(int index){
        return test[index];
    }
    public int traerP(int index){
        return punta[index];
    }
    public String traerC(int index){
        return correc[index];
    }
}