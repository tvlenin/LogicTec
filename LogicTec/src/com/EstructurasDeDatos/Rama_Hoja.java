package com.EstructurasDeDatos;

import Compuertas.And;
import Compuertas.Compuerta;

public class Rama_Hoja{
    
    protected boolean _outPut;
    protected Lista<Rama_Hoja> _inPuts;
    protected Compuerta logicaCompuerta;
    
    
    public Rama_Hoja(Compuerta pCompuerta){
        this.logicaCompuerta = pCompuerta;
        this._inPuts = null;
        this._outPut = false;
    }
}

