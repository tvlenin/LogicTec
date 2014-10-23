package com.logictec;

import Compuertas.LogicCompuertas;
import com.EstructurasDeDatos.Arbol;
import com.EstructurasDeDatos.Lista;
import com.EstructurasDeDatos.Nodo;
import com.EstructurasDeDatos.Rama_Hoja;


public class LogicTec {
    
    private Lista<Rama_Hoja> _compuertasDesconectadas; 
    private Arbol _circuito;
    
    public LogicTec(){
        this._compuertasDesconectadas = new Lista<>();
        this._circuito = new Arbol();
        
    }
    
    
    public static void main(String[] args) {
    }
    
}
