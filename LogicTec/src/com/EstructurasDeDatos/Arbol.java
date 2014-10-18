package com.EstructurasDeDatos;

import Compuertas.Compuerta;

public class Arbol<E> {
    
    protected Rama_Hoja _root;
    protected int _profundidad;
    
    public Arbol(){
        this._profundidad = -1;
        this._root = null;
    }
    
    public void insertar(Compuerta pCompuerta){
        Rama_Hoja nuevaRama = new Rama_Hoja(pCompuerta);
        if(_profundidad == -1){
            this._root = nuevaRama;
            this._profundidad++;
        }
    }
    
    public void eliminar(){}

}
