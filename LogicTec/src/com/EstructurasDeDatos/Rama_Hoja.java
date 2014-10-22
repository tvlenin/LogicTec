package com.EstructurasDeDatos;

public class Rama_Hoja{
    
    protected String _nombre; //identificador unico para cada compuerta, creado por la GUI
    protected boolean _ValorOutPut; //resultado de todas las entradas
    protected Lista<Rama_Hoja> _listaInPuts;
    protected Lista<Rama_Hoja> _listaOutPuts;
    protected String logicaCompuerta; //and, or, nor, not, etc
    
    
    public Rama_Hoja(String pCompuerta,String pNombre){
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
    
    public String getIdentificador(){
        return _nombre;
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
}

