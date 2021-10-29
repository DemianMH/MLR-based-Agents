package mlr;
public class xporxt {
  //Matrices
    double x [][]={{1,41.9,29.1},{1,43.9,29.5},{1,43.9,29.5},{1,44.5,29.7},{1,47.3,29.9},{1,47.3,30.3},
               {1,47.9,30.5},{1,50.2,30.7},{1,52.8,30.8},{1,53.2,30.9},{1,56.7,31.5},{1,57,31.7},
               {1,63.5,31.9},{1,65.5,32},{1,71.1,32.1},{1,77,32.5},{1,77.8,32.9}};
    
    double y [][]={{251.3},{251.3},{248.3},{267.5},{273},{276.5},{270.3},{274.9},{285},{290},{297},
               {302.5},{304.5},{309.3},{321.7},{330.7},{349}};//Arreglo Y
double xt [][] = new double [3][17];    
//(X*XT)
public double [][] xmuxt(double[][] x,double[][]xt){
    int fila= x.length;//1er Fila
    int columna=x[0].length;//1er Columna
    
    int fila2 = xt.length;//2da Fila
    int columna2 = xt[0].length;//2da Columna
    
    double[][] aux = new double [fila][columna2];
    
    for(int i=0; i<fila; i++){
        for(int j=0; j<columna2;j++){
            for(int k=0; k<columna;k++){
              //Operacion
                aux[i][j] += x[i][k]*xt[k][j];
            }
        }
    }
    return aux;
}
}
