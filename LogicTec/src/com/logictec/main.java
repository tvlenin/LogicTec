package com.logictec;

import com.LogicTec.EstructurasDeDatos.Arbol;
import com.LogicTec.EstructurasDeDatos.Lista;
import com.LogicTec.EstructurasDeDatos.Rama_Hoja;
import com.LogicTec.compuertas.LogicCompuertas;


public class main {

    public static void main(String[] args) {
 /*       Circuito testCircuit = new Circuito();
        testCircuit.crearNodo("A", "A1", 5);
        testCircuit.crearNodo("B", "B1", 6);
        testCircuit.conectar_A_ArribaDe_B("B1", null);
   */
        Lista<String> lista = new Lista<>();
        lista.insertar("4");
        lista.insertar("3");
        lista.insertar("2");
        lista.insertar("1");
        

        
        
        Arbol arbol = new Arbol();
        Rama_Hoja a = new Rama_Hoja("AND", "A", lista , lista);
        Rama_Hoja b = new Rama_Hoja("IN", "BIN1", lista,lista);
        Rama_Hoja c = new Rama_Hoja("IN", "CIN2", lista,lista);
        Rama_Hoja d = new Rama_Hoja("IN", "DIN3", lista,lista);
        Rama_Hoja e = new Rama_Hoja("IN", "EIN4", lista,lista);
        
        arbol.conectar_A_ArribaDe_B(a, null);
        arbol.conectar_A_ArribaDe_B(a, b);
        arbol.conectar_A_ArribaDe_B(a, c);
        
       /* System.out.println("salidas");
        arbol.printlnSalidas();
        System.out.println("entradas");
        arbol.printlnEntradas();
        arbol.conectar_A_ArribaDe_B(a, d);
        arbol.conectar_A_ArribaDe_B(a, e);
        */
        
        Lista<Integer> cva = new Lista<>();
        
    }
    
}
