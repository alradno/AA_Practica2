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
                //System.out.println(i);
                //System.out.println("Servidor reiniciado");
                indice = 0;
            }
        }
        return resultado;
    }

 //---------------------------------------------------------------------------------------------

    public static int procesar2 (int[] ds, int[] cs){

        int resultado = 0;
        int indice = 0;
        int media = 0;

        //Media del array ds
        for(int i = 0; i < ds.length; i++){
            media += ds[i];
        }
        media = media / ds.length;
        //System.out.println(media);

        for(int i = 0; i < ds.length; i++){
            //Si no reinicia
            if(cs[indice] > ds[i]){
                resultado += ds[i];
                indice++;
            }
            //Si reinicia
            else{
                if(ds[i] > media && cs[indice] > media){
                    resultado += cs[indice];
                }
                else{
                    indice = 0;
                }
            }
        }
        return resultado;
    }
}