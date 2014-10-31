package com.logictec;

import com.LogicTec.EstructurasDeDatos.Arbol;
import com.LogicTec.EstructurasDeDatos.Lista;
import com.LogicTec.EstructurasDeDatos.Rama_Hoja;
import com.LogicTec.compuertas.LogicCompuertas;


public class main {

    public static void main(String[] args) {
        Circuito circuito = new Circuito();
        Lista<String> lista1 = new Lista<>();
        lista1.insertar("A_111_I");
        lista1.insertar("A_222_I");
        lista1.insertar("A_333_I");
        Lista<String> lista2 = new Lista<>();
        lista2.insertar("B_444_I");
        lista2.insertar("B_555_I");
        lista2.insertar("B_666_I");
        Lista<String> lista3 = new Lista<>();
        lista3.insertar("C_777_I");
        lista3.insertar("C_888_I");
        lista3.insertar("C_999_I");
        
        
        circuito.crearNodo("A", "AND", lista1);
        circuito.crearNodo("B", "AND", lista2);
        circuito.crearNodo("C", "AND", lista3);
        
        circuito.conectar("222", "333");
    
    } 
}
