package com.logictec;

import com.LogicTec.compuertas.LogicCompuertas;
import com.LogicTec.EstructurasDeDatos.Arbol;
import com.LogicTec.EstructurasDeDatos.Lista;
import com.LogicTec.EstructurasDeDatos.Nodo;
import com.LogicTec.EstructurasDeDatos.Rama_Hoja;


public class LogicTec {
    
    private Lista<Rama_Hoja> _compuertasDesconectadas; 
    private Arbol _circuito;
    
    public LogicTec(){
        this._compuertasDesconectadas = new Lista<>();
        this._circuito = new Arbol();   
    }
    
    public static void main(String[] args) {
        
        Rama_Hoja a = new Rama_Hoja("IN", "A1", 0);
        Rama_Hoja b = new Rama_Hoja("OR", "B1", 10);
        Rama_Hoja c = new Rama_Hoja("AND", "C2", 10);
        Rama_Hoja d = new Rama_Hoja("OUT", "D3", 1);
        Arbol arbol = new Arbol();
        
        arbol.conectar_A_ArribaDe_B(a, null);
        
        arbol.conectar_A_ArribaDe_B(b, a);
        arbol.conectar_A_ArribaDe_B(c, a);
        
        
    //    arbol.printlnSalidas();
     //   arbol.conectar_A_ArribaDe_B(d, b);
     //   arbol.conectar_A_ArribaDe_B(d, c);
        
        
        
    }
    
}
