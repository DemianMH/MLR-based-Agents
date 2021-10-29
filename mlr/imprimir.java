package mlr;

public class imprimir {
 
//Metodo Para Imprimir
public void Imprimir(double x[][]){
    double fila= x.length;
    double columna= x[0].length;
    
    for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){
                System.out.print(x[i][j]+" ");
            }
            System.out.print("\n");
        }
}











}

