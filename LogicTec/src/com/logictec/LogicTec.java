package com.logictec;

import Compuertas.And;
import Compuertas.Compuerta;
import Compuertas.NAnd;
import com.EstructurasDeDatos.Arbol;
import com.EstructurasDeDatos.Lista;
import com.EstructurasDeDatos.Rama_Hoja;


public class LogicTec {

    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();
        
        Compuerta tmpcompuerta1 = new And();
        Compuerta tmpcompuerta2 = new NAnd();
        Rama_Hoja a = new Rama_Hoja(tmpcompuerta1, "A");
        Rama_Hoja b = new Rama_Hoja(tmpcompuerta2, "B");
        
        
        arbol.insertar_AarribaB(null, a);
        arbol.insertar_AarribaB( arbol.getRoot(), b);
        
        
        Rama_Hoja iterador = arbol.getRoot();
    
        iterador.printInPuts();
        iterador.printOutPuts();
    }
    
}
