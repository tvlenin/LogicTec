package com.logictec;

import com.LogicTec.compuertas.LogicCompuertas;
import com.LogicTec.EstructurasDeDatos.Arbol;
import com.LogicTec.EstructurasDeDatos.Lista;
import com.LogicTec.EstructurasDeDatos.Nodo;
import com.LogicTec.EstructurasDeDatos.Rama_Hoja;


public class Circuito {
    
    private Lista<Rama_Hoja> _compuertasDesconectadas; 
    private Arbol _circuito;
    
    public Circuito(){
        this._compuertasDesconectadas = new Lista<>();
        this._circuito = new Arbol();   
    }
    
    public void conectar_A_ArribaDe_B(String A, String B){
        _circuito.conectar_A_ArribaDe_B(A, B);
    }
    
    public boolean eliminar(String pData){
        return _circuito.eliminar(pData);
    }
    
    public boolean revisar(){
        return _circuito.revisarEntradasYSalidas();
    }
    
    
    public static void main(String[] args) {}
}
