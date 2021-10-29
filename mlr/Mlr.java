//Demian Mora Hernandez
//SIMULACION
//Hands-on 6: MLR-based Agents
package mlr;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Mlr extends Agent {

    @Override
    public void setup(){
        System.out.println("Agente "+getLocalName()+" iniciado");
        imprimir op= new imprimir();
        transpuesta trans=new transpuesta();
        xporxt xxt=new xporxt();
        determinante deter=new determinante();
        inversa inve=new inversa();
        adjunta adju =new adjunta();
        
         double x [][]={{1,41.9,29.1},{1,43.9,29.5},{1,43.9,29.5},{1,44.5,29.7},{1,47.3,29.9},{1,47.3,30.3},
                        {1,47.9,30.5},{1,50.2,30.7},{1,52.8,30.8},{1,53.2,30.9},{1,56.7,31.5},{1,57,31.7},
                        {1,63.5,31.9},{1,65.5,32},{1,71.1,32.1},{1,77,32.5},{1,77.8,32.9}}; 
         
         double y [][]={{251.3},{251.3},{248.3},{267.5},{273},{276.5},{270.3},{274.9},{285},{290},{297},
                        {302.5},{304.5},{309.3},{321.7},{330.7},{349}};
         
         double xt [][];
         double xmuxt [][];
         double xtmuly [][];
         double determin;
         double inv[][];
         double adj [][];
         double rfinal [][];
         
         
        System.out.println("Matriz(X): \n"); 
        op.Imprimir(x);
        System.out.println("Matriz(Y): \n"); 
        op.Imprimir(y);
        
        //Transpuesta
        xt = trans.Transpuesta();
        xmuxt = xxt.xmuxt(xt,x);
        
        System.out.println("(X * XT): \n"); 
        op.Imprimir(xmuxt);
        xtmuly = xxt.xmuxt(xt,y);
        
        System.out.println("(XT * Y) : \n"); 
        op.Imprimir(xtmuly);
        
        System.out.println("Resultado Determinante: \n"); 
        determin= deter.Determinante(xmuxt);
        System.out.println(determin);
        
        System.out.println("Resultado Adjunta: \n"); 
        adj=adju.Adjunta(xmuxt);
        op.Imprimir(adj);
        
        System.out.println("Resultado Inversa: \n"); 
        inv=inve.Inversa(xmuxt);
        op.Imprimir(inv);
        
        System.out.println("Resultado Final: \n"); 
        rfinal=xxt.xmuxt(inv,xtmuly);
        op.Imprimir(rfinal);
        addBehaviour(new MyOneshotBehaviour());
    }


 private class MyOneshotBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            System.out.println("Agente ejecutado");
        }
        
        @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
    
}
