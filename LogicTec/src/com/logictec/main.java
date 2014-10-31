package com.logictec;

import com.LogicTec.EstructurasDeDatos.Arbol;
import com.LogicTec.EstructurasDeDatos.Lista;
import com.LogicTec.EstructurasDeDatos.Rama_Hoja;
import com.LogicTec.compuertas.LogicCompuertas;


public class main {

    public static void main(String[] args) {
       // Circuito circuito = new Circuito();
        Lista<String> a = new Lista<>();
        a.insertar("4");
        a.insertar("3");
        a.insertar("2");
        a.insertar("1");
        
        Lista<String> array = new Lista<>(a);
        
        
        array.insertarEnIndex("4", "String");
        System.out.println(array.getDataIndex("21"));
    }
    
}
