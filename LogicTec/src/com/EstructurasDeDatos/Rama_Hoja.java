package com.EstructurasDeDatos;

import Compuertas.And;
import Compuertas.Compuerta;

public class Rama_Hoja{
    
    protected String _nombre;
    protected boolean _ValorOutPut;
    protected Lista<Rama_Hoja> _listaInPuts;
    protected Lista<Rama_Hoja> _listaOutPuts;
    protected Compuerta logicaCompuerta;
    
    
    public Rama_Hoja(Compuerta pCompuerta,String pNombre){
        this._nombre = pNombre;
        this.logicaCompuerta = pCompuerta;
        this._listaInPuts = new Lista<>();
        this._listaOutPuts = new Lista<>();
        this._ValorOutPut = false;
    }
    
    public void setNewInput(Rama_Hoja pRama){
        _listaInPuts.insertar(pRama);
    }
    
    public void setNewOutPut(Rama_Hoja pRama){
        _listaOutPuts.insertar(pRama);
    }
    
    public void actualizarData(){
        for(Nodo<Rama_Hoja> iterador = _listaInPuts.getHead(); iterador != null; iterador = iterador.getSiguiente() ){
            //hacer la logica de la compuerta para cada dato de input
        }
    }
    
    public String getName(){
        return _nombre;
    }
    
    public void printOutPuts(){ //Imprimir el nombre de todos los outpus 
        if(_listaOutPuts == null)
            System.out.println("No tiene Outputs");
        else
            for(Nodo<Rama_Hoja> iterador = _listaOutPuts.getHead(); iterador != null; iterador = iterador.getSiguiente())
                System.out.println(iterador.getDato().getName());
    }
    
    public void printInPuts(){// Imprimir todos los nombres de los Inputs
        if(_listaInPuts == null)
            System.out.println("No tiene Inputs");
        else
            for(Nodo<Rama_Hoja> iterador = _listaInPuts.getHead(); iterador != null; iterador = iterador.getSiguiente())
                System.out.println(iterador.getDato().getName());
    }
}

