package com.logictec;

import Compuertas.LogicCompuertas;
import com.EstructurasDeDatos.Arbol;
import com.EstructurasDeDatos.Lista;
import com.EstructurasDeDatos.Rama_Hoja;


public class LogicTec {

    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();

        Rama_Hoja a = new Rama_Hoja("AND", "A");
        Rama_Hoja b = new Rama_Hoja("OR", "B");
        
    //    arbol.insertar_A_ArribaDe_B(a, null);
   //     arbol.insertar_A_ArribaDe_B(arbol.getRoot(), b);
        
        boolean res = LogicCompuertas.doLogic(false, true, "XNOR");
        System.out.println(res);
        
        Rama_Hoja iterador = arbol.getRoot();
    
//        iterador.printInPuts();
 //       iterador.printOutPuts();
    }
    
}
