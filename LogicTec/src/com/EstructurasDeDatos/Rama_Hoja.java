package com.EstructurasDeDatos;

import Compuertas.LogicCompuertas;

public class Rama_Hoja{
    
    protected String _nombre; //identificador unico para cada compuerta, creado por la GUI
    protected boolean _ValorOutPut; //resultado de todas las entradas
    protected Lista<Rama_Hoja> _listaInPuts;
    protected Lista<Rama_Hoja> _listaOutPuts;
    protected String _logicaCompuerta; //and, or, nor, not, etc
    
    
    public Rama_Hoja(String pCompuerta,String pNombre){
        this._nombre = pNombre;
        this._logicaCompuerta = pCompuerta;
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
        if(_listaInPuts.getTalla() == 1)
            _ValorOutPut = _listaInPuts.getHead().getDato().getValorOutPut();
        else{
            _ValorOutPut = _listaInPuts.getHead().getDato().getValorOutPut();
            for(Nodo<Rama_Hoja> iterador = _listaInPuts.getHead().getSiguiente(); iterador != null; iterador = iterador.getSiguiente() ){
                _ValorOutPut = LogicCompuertas.doLogic(_ValorOutPut, iterador.getDato().getValorOutPut(), _logicaCompuerta);
            }
        }
    }
    
    public boolean getValorOutPut(){
        return this._ValorOutPut;
    }
    
    public String getIdentificador(){//identificador unico asignado en la GUI
        return this._nombre;
    }
    
    public Lista<Rama_Hoja> getEntradas(){//obtener la lista con todas las entradas que tiene este nodo
        return _listaInPuts;
    }
    
    public Lista<Rama_Hoja> getSalidas(){
        return _listaOutPuts;
    }
    
    public String getLogicAccion(){// String en MAYUSCULA que describe la accion logica de esta compuerta
        return this._logicaCompuerta;
    }
    
    public void printOutPuts(){ //Imprimir el nombre de todos los outpus 
        if(_listaOutPuts == null)
            System.out.println("No tiene Outputs");
        else
            for(Nodo<Rama_Hoja> iterador = _listaOutPuts.getHead(); iterador != null; iterador = iterador.getSiguiente())
                System.out.println(iterador.getDato().getIdentificador());
    }
    
    public void printInPuts(){// Imprimir todos los nombres de los Inputs
        if(_listaInPuts == null)
            System.out.println("No tiene Inputs");
        else
            for(Nodo<Rama_Hoja> iterador = _listaInPuts.getHead(); iterador != null; iterador = iterador.getSiguiente())
                System.out.println(iterador.getDato().getIdentificador());
    }
    public void setValueOfOutPut(boolean pData){
        if (_logicaCompuerta == "IN")
            _ValorOutPut = pData;
        else
            System.out.println("Por seguridad solo es permitido cambiar el resultado de logica a las compuertas de InPut");
    }
}

