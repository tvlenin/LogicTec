package com.logictec;

import Compuertas.LogicCompuertas;
import com.EstructurasDeDatos.Arbol;
import com.EstructurasDeDatos.Lista;
import com.EstructurasDeDatos.Rama_Hoja;


public class LogicTec {
    
    private Lista<Rama_Hoja> _compuertasDesconectadas; 
    private Arbol _circuito;
    
    public LogicTec(){
        this._compuertasDesconectadas = new Lista<>();
        this._circuito = new Arbol();
        
    }
    
    
    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();

        Rama_Hoja a = new Rama_Hoja("OR", "OUT");
        Rama_Hoja b = new Rama_Hoja("OR", "IN");
        Rama_Hoja c = new Rama_Hoja("OR", "IN");
        Rama_Hoja d = new Rama_Hoja("OR", "IN");
        
        arbol.conectar_A_ArribaDe_B(a, null);
        arbol.conectar_A_ArribaDe_B(arbol.getRoot(), b);
        arbol.conectar_A_ArribaDe_B(arbol.getRoot(), c);
        arbol.conectar_A_ArribaDe_B(arbol.getRoot(), d);
        
        Rama_Hoja iterador = arbol.getRoot();
        System.out.println(arbol.revisarEntradasYSalidas());
    }
    
}
