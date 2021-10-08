package mlr;

public class Mrlope {
    //Matrices
    double x [][]={{1,41.9,29.1},{1,43.9,29.5},{1,43.9,29.5},{1,44.5,29.7},{1,47.3,29.9},{1,47.3,30.3},
               {1,47.9,30.5},{1,50.2,30.7},{1,52.8,30.8},{1,53.2,30.9},{1,56.7,31.5},{1,57,31.7},
               {1,63.5,31.9},{1,65.5,32},{1,71.1,32.1},{1,77,32.5},{1,77.8,32.9}};
    
    double y [][]={{251.3},{251.3},{248.3},{267.5},{273},{276.5},{270.3},{274.9},{285},{290},{297},
               {302.5},{304.5},{309.3},{321.7},{330.7},{349}};//Arreglo Y
double xt [][] = new double [3][17];

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

//Metodo de Transpuesta
public double[][] Transpuesta(){
    for(int i=0;i<3;i++){
        for(int j=0;j<17;j++){
            xt[i][j]=x[j][i];
        }
    }
    return xt;
}

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
//Metodo de la Determianante
public double Determinante(double xt [][]){
    double aux,aux2,aux3,resultado;
    aux = ((xt[1][1] * xt[2][2])-(xt[2][1]*xt[1][2])) * xt[0][0];
    aux2 = ((xt[1][0]*xt[2][2])-(xt[2][0]*xt[1][2])) * -xt[0][1];
    aux3= ((xt[1][0]*xt[2][1])-(xt[2][0]*xt[1][1])) * xt[0][2];
    resultado = aux+aux2+aux3;
    return resultado;
}


//Metodo de la inversa
public double [] [] Inversa(double [][]xt){
    //Obtencion de la matriz
    double aux = Determinante(xt);
    double aux2[][]=Adjunta(xt);
    
    int fila = aux2.length;
    int columna = aux2[0].length;
    double resultado[][]= new double [fila][columna];
    
    //Resultado de la Matriz
    for(int i=0;i<fila;i++){
        for(int j=0;j<columna;j++){
            resultado[i][j]= aux2[i][j]/aux;
        }
    }
  return resultado; 
}


//Metodo de la adjunta
public double [][] Adjunta (double xt[][]){
    double adj [][]= new double [3][3];
    //Operaciones
    adj[0][0]=((xt[1][1]*xt[2][2]))-((xt[2][1]*xt[1][2]));
    adj[0][1]=-1*(((xt[1][0]*xt[2][2]))-((xt[2][0]*xt[1][2])));
    adj[0][2]=(xt[1][0]*xt[2][1])-(xt[2][0]*xt[1][1]);
    adj[1][0]=-1*((xt[0][1]*xt[2][2])-(xt[2][1]*xt[0][2]));
    adj[1][1]=(xt[0][0]*xt[2][2])-(xt[2][0]*xt[0][2]);
    adj[1][2]=-1*((xt[0][0]*xt[2][1])-(xt[2][0]*xt[0][1]));
    adj[2][0]=(xt[0][1]*xt[1][2])-(xt[1][1]*xt[0][2]);
    adj[2][1]=-1*((xt[0][0]*xt[1][2])-(xt[1][0]*xt[0][2]));
    adj[2][2]=(xt[0][0]*xt[1][1])-(xt[1][0]*xt[0][1]);
    return adj;
}

}

