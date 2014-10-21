package com.EstructurasDeDatos;

import Compuertas.Compuerta;

public class Arbol<E> {
    
    protected Rama_Hoja _root;
    protected int _profundidad; 
    
    public Arbol(){
        this._profundidad = -1; //profundidad por defecto de -1
        this._root = null;
    }
    
  
    public void insertar_A_ArribaDe_B(Rama_Hoja pRamaA,Rama_Hoja pRamaB){
        if(_profundidad == -1 && pRamaB == null)//se asume que si pCompuerta es nulo, el arbol esta vacio
            this.insertarPrimerElemento(pRamaA);
        
        else if(pRamaB == null)
            System.out.println("El arbol no esta vacio, se trato de insertar un nodo como raiz");
        else{
            pRamaA.setNewInput(pRamaB);
            pRamaB.setNewOutPut(pRamaA);
            this._profundidad++;
            System.out.println("Agregue un elemento nuevo al tree");
        }
    }
    private void insertarPrimerElemento(Rama_Hoja pNewRama){
        this._root = pNewRama;
        this._profundidad++;
        System.out.println("Extio un elemento en el arbol");
    }
    
    public Rama_Hoja getRoot(){
        return _root;
    }
    
    public void eliminar(){}

}
