public class Main {

    public static void main(String[] args) {
        int[] ds = {10, 1, 7, 7};
        int[] cs = {8, 4, 2, 1};
        int[] ds2 = {10, 4, 3, 6, 9, 4, 4};
        int[] cs2 = {8, 8, 4, 2, 8, 8, 4}; //8+4+3+8+4+4 = 31

        //int resultado = procesar(ds, cs);
       // int resultado2 = procesar(ds2, cs2);
        int resultado3 = procesar2(ds, cs);
        int resultado4 = procesar2(ds2, cs2);

        //System.out.println(resultado);
        //System.out.println(resultado2);
        System.out.println(resultado3);
        System.out.println(resultado4);
    }

    public static int procesar (int[] ds, int[] cs){

        int resultado = 0;
        int indice = 0;

        for(int i = 0; i < ds.length; i++){
            //Si no reinicia
            if(cs[indice] > ds[i]){
                resultado += ds[i];
                indice++;
            }
            //Si reinicia
            else{
                indice = 0;
            }
        }
        return resultado;
    }

 //---------------------------------------------------------------------------------------------

    public static int procesar2 (int[] ds, int[] cs){

        int resultado = 0;
        int indice = 0;
        int mediads = 0;

        //Media del array ds
        for(int i = 0; i < ds.length; i++){
            mediads += ds[i];
        }
        mediads = mediads / ds.length;

        //Media cs
        int mediacs = 0;
        for(int i = 0; i < cs.length; i++){
            mediacs += cs[i];
        }
        mediacs = mediacs / cs.length;

        for(int i = 0; i < ds.length; i++){
            //No reinicia
            if(cs[indice] > ds[i]){
                resultado += ds[i];
                indice++;
            //Si es el ultimo dia no se reinicia(coge lo que puede)
            } else if (i == ds.length - 1) {
                resultado += Math.min(cs[indice], ds[i]);
            }
            else{
                //Si es un día que merece la pena no reiniciar
                if(ds[i] > mediads && cs[indice] > mediacs){
                    resultado += Math.min(ds[i], cs[indice]);
                }
                //Reinicia Servidor (la recompensa es muy baja si no se hace)
                else{
                    indice = 0;
                }
            }
        }
        return resultado;
    }
}